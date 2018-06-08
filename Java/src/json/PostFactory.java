package json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.json.JSONObject;

import model.Answer;
import model.Comment;
import model.Question;
import model.User;

public class PostFactory {
	
	private static ArrayList<Question> questions = new ArrayList<Question>();
	
	
	public static Date getDateFromString(String dateString) {
		Date date = null;
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss'Z'");
			date = format.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static void getQuestions(File file) {
		Question question = new Question();
		HashMap<Integer, User> mapUser = new HashMap<Integer, User>();
		
		StringBuilder jsonString = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                jsonString.append(sCurrentLine).append("\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
		
        //create JsonObject from string
		JSONObject json = new JSONObject(jsonString.toString());
		
		//read json's element
		//get users
		int userId;
		String pseudo;
		int reputation;
		for (Object user : json.getJSONArray("users")) {
			userId = ((JSONObject) user).getInt("userId");
			pseudo = ((JSONObject) user).getString("pseudo");
			reputation = ((JSONObject) user).getInt("reputation");
			mapUser.put(userId, new User(userId, pseudo, reputation));
		}
		
		//set attributes
		question.setId(json.getJSONObject("question").getInt("questionId"));
		question.setTitle(json.getJSONObject("question").getString("title"));
		question.setContent(json.getJSONObject("question").getString("content"));
		question.setUpvoteCount(json.getJSONObject("question").getInt("upvoteCount"));
		question.setFavoriteCount(json.getJSONObject("question").getInt("favoriteCount"));
		
		//set owner
		question.setUser(mapUser.get(json.getJSONObject("question").getInt("userId")));
		
		//set date
		question.setPostDate(getDateFromString(json.getJSONObject("question").getString("date")));
		
		//set tags
		for (Object tag : json.getJSONObject("question").getJSONArray("tags")) {
			question.addTag(tag.toString());
		}
		
		//set question comments
		for (Object comment : json.getJSONObject("question").getJSONArray("comments")) {
			question.addComment(new Comment(
					((JSONObject) comment).getInt("commentId"),
					((JSONObject) comment).getString("content"),
					((JSONObject) comment).getInt("upvoteCount"),
					mapUser.get(((JSONObject) comment).getInt("userId")),
					getDateFromString(((JSONObject) comment).getString("date")))
					);
		}
		
		//set answers
		for (Object answer : json.getJSONObject("question").getJSONArray("answers")) {
			Answer ans = new Answer(
				((JSONObject) answer).getInt("answerId"),
				((JSONObject) answer).getString("content"),
				((JSONObject) answer).getInt("upvoteCount"),
				mapUser.get(((JSONObject) answer).getInt("userId")),
				getDateFromString(((JSONObject) answer).getString("date"))
			);
			//add answer comments
			for (Object comment : ((JSONObject) answer).getJSONArray("comments")) {
				ans.addComment(new Comment(
					((JSONObject) comment).getInt("commentId"),
					((JSONObject) comment).getString("content"),
					((JSONObject) comment).getInt("upvoteCount"),
					mapUser.get(((JSONObject) comment).getInt("userId")),
					getDateFromString(((JSONObject) comment).getString("date"))
				));
						
			}
			
			question.addAnswer(ans);
			
			//if this answer is the selected one
			if (ans.getId() == json.getJSONObject("question").getInt("selectedAnswer")) {
				question.setSelectedAnswer(ans);
			}
			
			questions.add(question);
		}
	}
	
	public static void main(String[] args) {
		
		//read file in filePath
		File file = new File(args[0]);
		if (file.isFile() && args[0].endsWith(".json")) {
			getQuestions(file);
		} else if (file.isDirectory()) {
			//for all the ".json" files in the directory at filePath -> getQuestion()
			for (File fichier : file.listFiles(new FilenameFilter() {
				
				@Override
				public boolean accept(File dir, String name) {
					if (name.endsWith(".json")) return true;
					return false;
				}
			})) {
				
				getQuestions(fichier);
			}
		}
		
		
		System.out.println(questions.toString());
	}

}

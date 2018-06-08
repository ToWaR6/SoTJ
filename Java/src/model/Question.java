package model;
import java.util.ArrayList;
import java.util.Date;

public class Question extends Post {

	private String title;
	private int favoriteCount;
	private Answer selectedAnswer;
	private ArrayList<Answer> listAnswer;
	private ArrayList<Comment> listComment;
	private ArrayList<String> listTag;
	
	//CONSTRUCTOR
	public Question() {
		this.listAnswer = new ArrayList<Answer>();
		this.listComment = new ArrayList<Comment>();
		this.listTag = new ArrayList<String>();
	}
	
	public Question(int id, String content, int upvoteCount, User user, Date postDate, String title, int favoriteCount, Answer selectedAnswer) {
		super(id, content, upvoteCount, user, postDate);
		this.listAnswer = new ArrayList<Answer>();
		this.listComment = new ArrayList<Comment>();
		this.listTag = new ArrayList<String>();	
	}

	//GETTER & SETTER
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getFavoriteCount() {
		return favoriteCount;
	}

	public void setFavoriteCount(int favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

	public Answer getSelectedAnswer() {
		return selectedAnswer;
	}

	public void setSelectedAnswer(Answer selectedAnswer) {
		this.selectedAnswer = selectedAnswer;
	}

	public ArrayList<Answer> getListAnswer() {
		return listAnswer;
	}

	public void setListAnswer(ArrayList<Answer> listAnswer) {
		this.listAnswer = listAnswer;
	}

	public ArrayList<Comment> getListComment() {
		return listComment;
	}

	public void setListComment(ArrayList<Comment> listComment) {
		this.listComment = listComment;
	}

	public ArrayList<String> getListTag() {
		return listTag;
	}

	public void setListTag(ArrayList<String> listTag) {
		this.listTag = listTag;
	}

	//FONCTION
	public String toString() {
		return 	super.toString()+
				"\nTitre: "+this.title+
				"\nFavori: "+this.favoriteCount+
				"\nReponseSelectionné : "+this.selectedAnswer+
				"\nReponses : "+this.listAnswer+
				"\nCommentaires : "+this.listComment+
				"\nTags : "+this.listTag;              
	}
	
	public void addAnswer(Answer a) {
		this.listAnswer.add(a);
	}

	public void addComment(Comment c) {
		this.listComment.add(c);
	}
	
	public void addTag(String t) {
		this.listTag.add(t);
	}
		
}

package model;
import java.util.ArrayList;
import java.util.Date;

public class Answer extends Post {

	private ArrayList<Comment> listCom;

	public Answer(int id, String content, int upvoteCount, User user, Date postDate) {
		super(id, content, upvoteCount, user, postDate);
		this.listCom = new ArrayList<Comment>();
	}

	public ArrayList<Comment> getListCom() {
		return listCom;
	}
	
	public void addComment(Comment c) {
		this.listCom.add(c);
	}

	public String toString() {
		return 	super.toString()+
				"\nCommentaires : "+this.listCom;
	}
	
}

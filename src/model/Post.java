package model;
import java.util.Date;

public abstract class Post {

	private int id;
	private String content;
	private int upvoteCount;
	private User user;
	private Date postDate;
	
	//cONSTRUCTOR
	public Post(){}
	public Post(int id, String content, int upvoteCount, User user, Date postDate) {
		super();
		this.id = id;
		this.content = content;
		this.upvoteCount = upvoteCount;
		this.user = user;
		this.postDate = postDate;
	}

	//GETTER & SETTER
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUpvoteCount() {
		return upvoteCount;
	}

	public void setUpvoteCount(int upvoteCount) {
		this.upvoteCount = upvoteCount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	
	//FONCTION
	public String toString() {
		return 	"Id: "+this.id+
				"\nContent: "+this.content+
				"\nUpvote: "+this.upvoteCount+
				"\nUser: "+this.user+
				"\nDate: "+this.postDate;
	}
	
	
}

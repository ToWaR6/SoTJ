package model;

import java.util.Date;

public class Comment extends Post {

	public Comment(int id, String content, int upvoteCount, User user, Date postDate) {
		super(id, content, upvoteCount, user, postDate);
	}
	
}

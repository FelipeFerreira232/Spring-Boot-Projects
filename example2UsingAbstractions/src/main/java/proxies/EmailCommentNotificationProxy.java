package proxies;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import model.Comment;

@Component
@Qualifier(value="EMAIL")
public class EmailCommentNotificationProxy implements CommentNotificationProxy {

	@Override
	public void sendComment(Comment comment) {
		
		System.out.println("Sending email notification for comment: " + comment.getMessage());

	}

}

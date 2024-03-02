package services;

import java.util.logging.Logger;	

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import aspects.LoggingAspect;
import aspects.ToLog;
import model.Comment;
import proxies.CommentNotificationProxy;
import repositories.CommentRepository;

@Service
public class CommentService {
	private Logger logger = Logger.getLogger(CommentService.class.getName());
	private final CommentNotificationProxy proxy;
	private final CommentRepository repository;
	
	public CommentService(@Qualifier("PUSH") CommentNotificationProxy proxy, CommentRepository repository) {
		super();
		this.proxy = proxy;
		this.repository = repository;
	}
	
	public void publishComment(Comment comment) {
		logger.info("Publishing comment:" + comment.getMessage());
	}
	
	@ToLog
	public String deleteComment(Comment comment) {
		logger.info("Deleting comment:" + comment.getMessage());
		return "COMMENT DELETED";
	}
	
	public void editComment(Comment comment) {
		logger.info("Editing comment:" + comment.getMessage());
	}
	
	
}

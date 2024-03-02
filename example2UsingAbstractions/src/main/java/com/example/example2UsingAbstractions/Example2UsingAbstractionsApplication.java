package com.example.example2UsingAbstractions;

import java.util.Arrays;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import aspects.LoggingAspect;
import model.Comment;
import proxies.CommentNotificationProxy;
import proxies.EmailCommentNotificationProxy;
import repositories.CommentRepository;
import repositories.DBCommentRepository;
import services.CommentService;

@SpringBootApplication
public class Example2UsingAbstractionsApplication {
	private static Logger logger = Logger.getLogger(Example2UsingAbstractionsApplication.class.getName());

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		
		Comment comment = new Comment("Felipe", "RJ");
		CommentService service = context.getBean(CommentService.class);
		
		String returnedValue = service.deleteComment(comment);
		logger.info(returnedValue);
	}

}

package com.in28minutes.springboot.learnspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import java.util.Date;

@SpringBootApplication
public class LearnSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void applicationReadyEvent(ApplicationReadyEvent event) {
		System.out.println("Application ready to respond to Services at " + new Date(event.getTimestamp()));
	}

}

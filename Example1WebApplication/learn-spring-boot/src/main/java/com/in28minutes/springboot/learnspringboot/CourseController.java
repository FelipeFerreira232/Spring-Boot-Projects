package com.in28minutes.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	
	
	@RequestMapping("/courses")
	public List<Course> retrieveAllCourses(){
		Course[] courses = {
				new Course(1, "Learn AWS", "in28minues"),
				new Course(2, "Learn Docker", "book"),
				new Course(3, "Learn Angular", "Udemy"),
				new Course(4, "Learn CyberSecurity", "Udemy"),
				new Course(5, "Jiu Jitsu", "FP")};
		return Arrays.asList(courses);
	}
}

package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import com.in28minutes.springboot.learnjpaandhibernate.course.CourseJPARepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.CourseSpringDataJPARepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{
	
	/*
	@Autowired
	private CodeJDBCRepository repository;
	*/
	
	/*
	@Autowired
	private CourseJPARepository repository;
	*/
	
	@Autowired
	private CourseSpringDataJPARepository repository;	
	
	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(1, "Learn AWS JPA", "in28minutes"));
		repository.save(new Course(2, "Learn Docker JPA", "in28minutes"));
		repository.save(new Course(3, "Learn Azure JPA", "in28minutes"));
		System.out.println("Course getting deleted? " + repository.findById(3l));
		repository.deleteById(3l);
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		System.out.println(repository.findByAuthor("in28minutes"));
	}
}
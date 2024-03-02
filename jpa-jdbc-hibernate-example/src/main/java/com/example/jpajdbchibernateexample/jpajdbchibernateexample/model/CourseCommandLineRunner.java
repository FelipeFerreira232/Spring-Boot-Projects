package com.example.jpajdbchibernateexample.jpajdbchibernateexample.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.jpajdbchibernateexample.jpajdbchibernateexample.repositories.CourseJDBCRepository;
import com.example.jpajdbchibernateexample.jpajdbchibernateexample.repositories.CourseJPARepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourseJDBCRepository jdbcRepository;
	
	@Autowired
	private CourseJPARepository jpaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
	//Using the Spring JBDC sql/field mapping approach
	/*
		Course course1 = new Course(23, "Mastering AWS", "Felipe");
		jdbcRepository.insert(course1);
		Course course2 = new Course(2, "Mastering Spring Boot", "Felipe");
		jdbcRepository.insert(course2);
		Course course3 = new Course(9, "Mastering Docker", "Felipe");
		jdbcRepository.insert(course3);
		Course course4 = new Course(29, "Mastering Jiu Jitsu", "Felipe");
		jdbcRepository.insert(course4);
		
		Course courseReturned = jdbcRepository.findById(29);
		System.out.println("Course returned \n" + courseReturned);
	*/
		
	//Using the jpa EntityManager approach
		Course course1 = new Course(23, "Mastering AWS", "Felipe");
		jpaRepository.insert(course1);
		jpaRepository.deleteById(23);
		Course course2 = new Course(2, "Mastering Spring Boot", "Felipe");
		jpaRepository.insert(course2);
		Course course3 = new Course(9, "Mastering Docker", "Felipe");
		jpaRepository.insert(course3);
		Course course4 = new Course(29, "Mastering Jiu Jitsu", "Felipe");
		jpaRepository.insert(course4);
		
		System.out.println("Course with id 29: \n" + jpaRepository.findById(29));
		
		
			
	}

}

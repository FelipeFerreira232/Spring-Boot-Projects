package com.in28minutes.springboot.learnjpaandhibernate.course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataJPARepository extends JpaRepository<Course, Long>{
	public List<Course> findByAuthor(String author);
}

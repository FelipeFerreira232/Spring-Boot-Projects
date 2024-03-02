package com.in28minutes.springboot.learnjpaandhibernate.course;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJPARepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	public void insert(Course course) {
		//Mapping is automatically done show each entityProperty - tableColumn
		//Basically, inserts a row (object) into the DB
		entityManager.merge(course);
	}
	
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById(long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}
}

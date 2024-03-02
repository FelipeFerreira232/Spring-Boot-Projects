package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

@Repository
public class CodeJDBCRepository {
	
	@Autowired
	private JdbcTemplate springJDBCTemplate;
	
	private static String INSERT_QUERY = """
			insert into course(id, name, author)
				values(?, ?, ?);
			""";
	
	private static String DELETE_QUERY = """
			delete from course
				where id = ?;
			""";
	
	private static String SELECT_QUERY = """
			select *
			from course
			where id = ?;
			""";
	
	public void insert(Course course) {
		springJDBCTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}
	
	public Course findById(long id) {
		return springJDBCTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
	}
	
	public void delete(long id) {
	    if(springJDBCTemplate.update(DELETE_QUERY, id) == 1)
	    	System.out.println("Item deleted");
	    else
	    	System.out.println("Operation failed.");
	};
}

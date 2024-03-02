package com.example.jpajdbchibernateexample.jpajdbchibernateexample.repositories;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.jpajdbchibernateexample.jpajdbchibernateexample.model.Course;

@Repository
public class CourseJDBCRepository {

	private final JdbcTemplate jdbc;

	private static String INSERT_QUERY = """
			insert into course values(?, ?, ?);
			""";
	private static String DELETE_QUERY = """
			delete from course
			where id = ?;
			""";

	private static String SELECT__QUERY = """
			select * from course
			where id = ?;
			""";

	public CourseJDBCRepository(JdbcTemplate jdbc) {
		super();
		this.jdbc = jdbc;
	}

	public void insert(Course course) {
		jdbc.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}

	public void delete(long id) {
		jdbc.update(DELETE_QUERY, id);
	}

	public Course findById(long id) {
		return jdbc.queryForObject(SELECT__QUERY, new BeanPropertyRowMapper<>(Course.class), id);
	}

}

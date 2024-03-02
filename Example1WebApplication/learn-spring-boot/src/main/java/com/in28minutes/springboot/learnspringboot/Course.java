package com.in28minutes.springboot.learnspringboot;

public class Course {
	private int id;
	private String name;
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	private String author;
	
	public Course(int id, String name, String author) {
		this.id = id;
		this.name = name;
		this.author = author;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
}
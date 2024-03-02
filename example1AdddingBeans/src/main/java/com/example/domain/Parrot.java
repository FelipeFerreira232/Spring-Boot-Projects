package com.example.domain;

import org.springframework.stereotype.Component;

@Component
public class Parrot {
	String name;

	public Parrot() {
	}
	
	public Parrot(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Parrot [name=" + name + "]";
	}
	
}

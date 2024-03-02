package com.in28minutes.rest.webservices.restfulwebservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.restfulwebservices.User.User;
import com.in28minutes.rest.webservices.restfulwebservices.User.UserDAO;
import com.in28minutes.rest.webservices.restfulwebservices.exception.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
public class SocialMediaController {
	
	private UserDAO userDao;
	
	
	public SocialMediaController(UserDAO userDao) {
		super();
		this.userDao = userDao;
	}

	

	//users
	@GetMapping(path="/users")
	public List<User> retrieveAllUsers(){
		return userDao.findAll();
	}
	
	//users/{id}
	@GetMapping(path="/users/{id}")
	public User findById(@PathVariable int id) {
		User user = userDao.findOne(id);
		if(user==null)
			throw new UserNotFoundException("id " + id);
		return user;
	}
	
	//Adds new User
	@PostMapping(path="/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = userDao.saveUser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().
						path("/{id}").
						buildAndExpand(savedUser.getId()).
						toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	//Deletes user
	@DeleteMapping(path="/users/{id}")
	public void deleteById(@PathVariable int id) {
		userDao.deleteById(id);
	}
	
	//users/{id}/posts
	//users/{id}/posts/{post_id}
}

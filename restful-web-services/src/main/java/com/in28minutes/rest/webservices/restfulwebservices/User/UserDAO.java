package com.in28minutes.rest.webservices.restfulwebservices.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDAO {
	//JPA or HIBERNATE to talk to the Database
	//For examples purposes, we'll be using a static List
	
	private static List<User> users = new ArrayList<>();
	
	private static int usersCount = 3;
	
	static {
		users.add(new User(1, "Adam", LocalDate.now().minusYears(23)));
		users.add(new User(2, "Felipe", LocalDate.now().minusYears(27)));
		users.add(new User(3, "Jim", LocalDate.now().minusYears(30)));
	}
	
	//Returns a List of all Users
	public List<User> findAll(){
		return users;
	}
	//Returns a specific User
	//Saves a User

    public User findOne(int id) {
    	Predicate<? super User> predicate = user -> user.getId() == id; 
    	return users.stream().filter(predicate).findFirst().orElse(null);
    }
    
    public User saveUser(User user) {
    	user.setId(++usersCount);
    	users.add(user);
    	return user;
    }
    
    public void deleteById(int id) {
    	Predicate<? super User> predicate = user -> user.getId() == id;
    	users.removeIf(predicate);
    }
}

package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;
import com.example.demo.service.impl.Status;

public interface UserService {
	
	User saveUser(User user);

	List<User> getAllUsers();
	
	User logUserIn(User user, long id);

	Status logoutUser(User user, long id);
}

package com.example.ParkEasy.service;

import java.util.List;

import com.example.ParkEasy.model.User;
import com.example.ParkEasy.service.impl.Status;

public interface UserService {

	User saveUser(User user);

	List<User> getAllUsers();

	User userLogin(User user, long id);

	Status userLogout(User user, long id);
}

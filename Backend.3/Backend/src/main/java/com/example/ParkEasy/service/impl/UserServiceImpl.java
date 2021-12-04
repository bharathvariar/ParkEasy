package com.example.ParkEasy.service.impl;

import java.util.List;

import com.example.ParkEasy.exception.ResourceNotFoundException;
import com.example.ParkEasy.model.User;
import com.example.ParkEasy.repository.UserRepository;
import com.example.ParkEasy.service.UserService;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public List<com.example.ParkEasy.model.User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public com.example.ParkEasy.model.User saveUser(com.example.ParkEasy.model.User user) {
		return userRepository.save(user);
	}

	// NEW
	@Override
	public User userLogin(User user, long id) {

		User existingUser = userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("User", "Id", id));
		existingUser.setLoggedIn(true);
		userRepository.save(existingUser);

		return existingUser;
	}

	@Override
	public Status userLogout(User user, long id) {

		User existingUser = userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("User", "Id", id));
		existingUser.setLoggedIn(false);
		userRepository.save(existingUser);

		return Status.SUCCESS;
	}

}

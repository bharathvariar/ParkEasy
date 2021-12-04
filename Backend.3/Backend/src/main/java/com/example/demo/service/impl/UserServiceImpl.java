package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public List<com.example.demo.model.User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public com.example.demo.model.User saveUser(com.example.demo.model.User user) {
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

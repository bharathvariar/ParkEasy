package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.Status;

@RestController
@RequestMapping("/parkeasy/user")
public class UserController {

	private UserService userService;
	@Autowired
	UserRepository userRepository;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping
	@PutMapping
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);

	}

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@CrossOrigin
	@PostMapping("/register")
	public @Valid User registerUser(@Valid @RequestBody User newUser) {

		List<User> users = userRepository.findAll();

		for (User user : users) {
			if (user.equals(newUser)) {
				System.out.println("User Already exists!");
				newUser.setUsername("null");
				// return Status.USER_ALREADY_EXISTS;
				return newUser;
			}
		}
		userRepository.save(newUser);
		return newUser;
		// return Status.SUCCESS;
	}

	// @CrossOrigin()
	// @PostMapping("/login")
	// public @Valid User loginUser(@Valid @RequestBody User user) {

	// 	List<User> users = userRepository.findAll();

	// 	for (User other : users) {
	// 		if (other.equals(user)) {
	// 			user.setLoggedIn(true);
	// 			userRepository.save(user);
	// 			// return Status.SUCCESS
	// 			return user;
	// 		}
	// 	}

	// 	// return Status.FAILURE
	// 	user.setUsername("null");
	// 	return user;
	// }

	// NEW

	@CrossOrigin
	@PatchMapping("/login")
	public ResponseEntity<User> loginUser(@Valid @RequestBody User user) {

		List<User> users = userRepository.findAll();

		for (User other : users) {
			if (other.equals(user)) {
				return new ResponseEntity<User>(userService.logUserIn(other, other.getId()), HttpStatus.OK);
			}
		}
		// return Status.FAILURE
		// user.setUsername("null");
		// return user;
		user.setUsername(null);
		return null;

	}

	// @CrossOrigin()
	// @PostMapping("/logout")
	// public Status logUserOut(@Valid @RequestBody User user) {
	// 	List<User> users = userRepository.findAll();

	// 	for (User other : users) {
	// 		if (other.equals(user)) {
	// 			user.setLoggedIn(false);
	// 			userRepository.save(user);
	// 			return Status.SUCCESS;
	// 		}
	// 	}

	// 	return Status.FAILURE;
	// }

	@CrossOrigin
	@PatchMapping("/logout")
	public Status logUserOut(@Valid @RequestBody User user) {
		
		List<User> users = userRepository.findAll();

		for (User other : users) {
			if (other.equals(user)) {
				
				return (userService.logoutUser(other, other.getId()));
			}
		}

		return Status.FAILURE;
	}

	@CrossOrigin
	@DeleteMapping("/deleteall")
	public Status deleteUsers() {
		userRepository.deleteAll();
		return Status.SUCCESS;
	}

}

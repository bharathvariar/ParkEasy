package com.example.ParkEasy.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.ParkEasy.model.User;
import com.example.ParkEasy.repository.UserRepository;
import com.example.ParkEasy.service.UserService;
import com.example.ParkEasy.service.impl.Status;

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

@RestController
@CrossOrigin
@RequestMapping("/parkeasy/user")
public class UserController {

	private UserService userService;
	@Autowired
	UserRepository userRepository;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@CrossOrigin
	@PostMapping
	@PutMapping
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);

	}

	@CrossOrigin
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
				return null;
			}
		}
		userRepository.save(newUser);
		return newUser;
	}

	@CrossOrigin
	@PatchMapping("/login")
	public ResponseEntity<User> loginUser(@Valid @RequestBody User user) {

		List<User> users = userRepository.findAll();

		for (User other : users) {
			if (other.equals(user)) {
				return new ResponseEntity<User>(userService.userLogin(other, other.getId()), HttpStatus.OK);
			}
		}
		
		return null;

	}

	@CrossOrigin
	@PatchMapping("/logout")
	public Status logoutUser(@Valid @RequestBody User user) {

		List<User> users = userRepository.findAll();

		for (User other : users) {
			if (other.equals(user)) {

				return (userService.userLogout(other, other.getId()));
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
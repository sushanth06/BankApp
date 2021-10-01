package com.example.BankApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankApp.entity.User;
import com.example.BankApp.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	@PostMapping("/createUser")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
	return userService.getUserById(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUserById(@PathVariable Long id) {
		userService.deleteUserById(id);
		return "Success";
}
 
}
package com.example.BankApp.service;

import java.util.List;

import com.example.BankApp.entity.User;

public interface UserService {

	public User addUser(User user);

	public List<User> getAllUsers();

	public User getUserById(Long id);

	public void deleteUserById(Long id);
}

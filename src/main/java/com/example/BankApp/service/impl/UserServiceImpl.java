package com.example.BankApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BankApp.entity.User;
import com.example.BankApp.repository.UserRepository;
import com.example.BankApp.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User addUser(User user) {
		validateUserData(user);
		return userRepository.save(user);
	}
	
	@Override
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).get();
	}
	
	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}
	
	private void validateUserData(User user) throws IllegalArgumentException {
//        String emailPattern = "^[a-z0-9-\\+]+(\\.[a-z0-9-]+)*@"
//                + "[a-z0-9-]+(\\.[a-z0-9]+)*(\\.[a-z]{2,})$";

        if (user.getFirstName() == null || user.getFirstName().length() == 0) {
            throw new IllegalArgumentException("First Name is manadatory");
        } else  if (user.getLastName() == null || user.getLastName().length() == 0) {
            throw new IllegalArgumentException("Last Name is manadatory");
        }else if (user.getAge() < 18) {
            throw new IllegalArgumentException("Minimum age requirement is 18 to create an account");
        } 
        //similarly we can add other validations
    }
}
 


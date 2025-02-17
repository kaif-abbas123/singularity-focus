package com.singularityFocus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.singularityFocus.entity.User;
import com.singularityFocus.repository.UserRepo;



@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
	
	public User createUser(User user) {
		return userRepo.save(user);
	}
	
	public User getUserById(Long id) {
		return userRepo.findById(id).orElse(null);
	}
	
	public List<User> findAllUsers() {
		return userRepo.findAll();
	}

	
	
	public User updateUser(Long id, User user) {
		User existingUser = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		existingUser.setName(user.getName());
		existingUser.setAim(user.getAim());
		existingUser.setTime(user.getTime());
		return userRepo.save(existingUser);

	}
	
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}

}

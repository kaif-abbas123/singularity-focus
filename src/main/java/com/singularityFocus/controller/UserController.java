package com.singularityFocus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.singularityFocus.entity.User;
import com.singularityFocus.service.UserService;
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

  
    
    @PostMapping
    public User createUser(@ModelAttribute User user) {
        return userService.createUser(user);
    }

    
	@GetMapping("/{id}")
	public User getUserByID(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	
	/*
	 * @GetMapping("/users") public String findAllUsers(Model model) { List<User>
	 * users = userService.findAllUsers(); model.addAttribute("users", users);
	 * return "find"; // This maps to find.html }
	 */	 
	
	@GetMapping("/user")
	public List<User> findAllUsers()
	{
		return userService.findAllUsers();
	}
	

	/*
	 * @PutMapping("/{id}") public User updateUser(@PathVariable Long
	 * id, @RequestBody User user) { return userService.updateUser(id, user); }
	 */
	
	@PostMapping("/user/update")
	public ResponseEntity<String> updateUser(@RequestParam Long id, @RequestParam(required = false) String name,
			@RequestParam(required = false) String aim, @RequestParam(required = false) String time) {
		// Your update logic here
		return ResponseEntity.ok("User updated successfully");
	}
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id)
	{
		userService.deleteUser(id);	
	}

}

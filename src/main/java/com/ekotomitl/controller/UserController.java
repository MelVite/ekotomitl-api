package com.ekotomitl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekotomitl.models.User;
import com.ekotomitl.services.UserService;

@RestController
@RequestMapping("/user/")
public class UserController {
	@Autowired
	private UserService userService;
	
	//Get all
	@GetMapping
	public List<User> getAllUser() {
		return userService.findAllUser();
	}
	
	//Get regresa un JSON valido
	@GetMapping("{id}") //Solicita una id para filtrar
	public ResponseEntity<User> getUserById (@PathVariable Long id) {
		return userService.findUserById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	//Post
	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	//Put
	@PutMapping("{id}")
	public User updateUser(@RequestBody User newUser, @PathVariable Long id) {
		return userService.replaceUser(newUser, id);
	}
	
	//Delete
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
		return userService.findUserById(id)
				.map(user -> {
					userService.deleteUserById(id);
					return ResponseEntity.ok().<Void>build();
				})
				.orElse(ResponseEntity.notFound().build());
	}

}

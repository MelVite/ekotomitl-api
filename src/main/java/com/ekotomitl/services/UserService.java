package com.ekotomitl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekotomitl.models.User;
import com.ekotomitl.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	//Get todos los usuarios
	public List<User> findAllUser() {
		return userRepository.findAll();
	}
	
	//Get un solo usurario
	public Optional<User> findUserById(Long id) {
		return userRepository.findById(id);
	}
	
	//Post
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	//Put
	public User replaceUser(User newUser, Long id) {
		return userRepository.findById(id)
				.map(user -> {
					user.setEmail(newUser.getEmail());
					user.setPhone(newUser.getPhone());
					user.setAdress(newUser.getAdress());
					return userRepository.save(user);
				}) 
				.orElseGet(() -> {
					return userRepository.save(newUser);
				});
	}
	
	
	//Delete un usuario
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}

}

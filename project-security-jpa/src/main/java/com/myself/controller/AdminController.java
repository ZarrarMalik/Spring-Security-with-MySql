package com.myself.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myself.model.User;
import com.myself.repository.UserRepository;

@RestController
@RequestMapping("/secure/rest")
public class AdminController {

	@Autowired
	UserRepository userRepository;
	
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping("/admin/add")
	public String addUserByAdmin(@RequestBody User user) {
		String pwd= user.getPassword();
		String encryptPassword= passwordEncoder.encode(pwd);
		user.setPassword(encryptPassword);
		userRepository.save(user);
		return "User added successfully.........";
	}
	
	
}

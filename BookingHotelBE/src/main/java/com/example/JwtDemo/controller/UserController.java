package com.example.JwtDemo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.JwtDemo.entity.User;
import com.example.JwtDemo.service.user.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/auth/signin")
public class UserController {
	@Autowired
	private UserService<User> userService;
	
//	@Autowired
//	private UserRoleRepository userRoleRepository;
	
	@GetMapping("/users")
	public ResponseEntity<Iterable<User>> getUserByUserName(@RequestParam(required = false)String username){
		try {
			if(username == null)
				return new ResponseEntity<>(userService.findAll(),HttpStatus.OK);
			else
				return new ResponseEntity<>(userService.findByKeyUserName(username),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id){
		Optional<User> userOptional = userService.findById(id);
		return userOptional.map(user -> new ResponseEntity<>(user,HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
//	@GetMapping("/users/role/{id}")
//	public ResponseEntity<UserRole> getRoleById(@PathVariable Long id){
//		Optional<UserRole> roleOptional = userRoleRepository.findById(id);
//		return roleOptional.map(role -> new ResponseEntity<>(role,HttpStatus.OK))
//				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//	}
	
	@GetMapping("/users/detail/{username}")
	public ResponseEntity<User> getUserByName(@PathVariable String username){
		Optional<User> userOptional = userService.findByUserName(username);
		return userOptional.map(user -> new ResponseEntity<>(user,HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User user){
		Optional<User> userOptional = userService.findById(id);
		return userOptional.map(user1 -> {
			user.setId(user1.getId());
			return new ResponseEntity<>(userService.save(user),HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.OK));
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable Long id){
		Optional<User> userOptional = userService.findById(id);
		return userOptional.map(user -> {
			userService.removeById(id);
			return new ResponseEntity<>(user,HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}

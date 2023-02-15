package com.example.JwtDemo.service.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JwtDemo.entity.User;
import com.example.JwtDemo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService<User> {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public User save(User t) {
		return userRepository.save(t);
	}

	@Override
	public void removeById(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public Iterable<User> findByKeyUserName(String username) {
		return userRepository.findByKeyUserName(username);
	}

	@Override
	public Optional<User> findByUserName(String username) {
		return userRepository.findByUsername(username);
	}
	
}

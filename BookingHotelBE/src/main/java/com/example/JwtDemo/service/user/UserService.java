package com.example.JwtDemo.service.user;

import java.util.Optional;

public interface UserService<T> {
	Iterable<T> findAll();
	
	Optional<T> findById(Long id);
	
	T save(T t);
	
	void removeById(Long id);
	
	Iterable<T> findByKeyUserName(String username);

	Optional<T> findByUserName(String username);
}

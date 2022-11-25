package com.example.demo.service;

import java.util.Optional;

public interface BaseService<T> {
	Iterable<T> findAll();
	
	Optional<T> findById(Integer id);
	
	T save(T t);
	
	void remove(Integer id);
}

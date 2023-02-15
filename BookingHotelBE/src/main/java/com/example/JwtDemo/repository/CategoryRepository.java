package com.example.JwtDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.JwtDemo.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	Category getCategoryByCategoryName(String name);
	
	List<Category> findAll();
}

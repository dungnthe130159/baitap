package com.example.JwtDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JwtDemo.entity.Category;
import com.example.JwtDemo.service.CategoryService;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("api/auth/signin")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
//	@RequestMapping("/findallCategory")
	@GetMapping("/findallCategory")
	private List<Category> findCategory(){
		return categoryService.getAllCategories();
	}
}

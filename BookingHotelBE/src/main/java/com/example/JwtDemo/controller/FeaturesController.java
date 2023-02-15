package com.example.JwtDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JwtDemo.entity.Feature;
import com.example.JwtDemo.service.FeaturesService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/auth/signin")
public class FeaturesController {
	@Autowired
	private FeaturesService featuresService;
	
//	@RequestMapping("/findallFeatures")
	@GetMapping("/findallFeatures")
	private List<Feature> findedAllFeatures(){
		return featuresService.findedAllFeatures();
	}
}

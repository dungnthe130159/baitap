package com.example.JwtDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JwtDemo.entity.Feature;
import com.example.JwtDemo.repository.FeaturesRepository;

@Service
public class FeaturesService {
	@Autowired
	public FeaturesRepository featuresRepository;
	
	public List<Feature> findedAllFeatures(){
		return featuresRepository.findAll();
	}
}

package com.example.JwtDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.JwtDemo.entity.Feature;

@Repository
public interface FeaturesRepository extends JpaRepository<Feature, Long> {
	List<Feature> findAll();
}

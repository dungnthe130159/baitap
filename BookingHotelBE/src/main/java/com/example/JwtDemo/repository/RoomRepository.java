package com.example.JwtDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.JwtDemo.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{
	List<Room> findAll();
}

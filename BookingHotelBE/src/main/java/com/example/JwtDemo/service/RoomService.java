package com.example.JwtDemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JwtDemo.entity.Category;
import com.example.JwtDemo.entity.Room;
import com.example.JwtDemo.repository.CategoryRepository;
import com.example.JwtDemo.repository.RoomRepository;

@Service
public class RoomService {
	@Autowired	
	private RoomRepository roomRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	public List<Room> getAllRooms(){
		return roomRepository.findAll();
	}
	
	public List<Room> findByCategoryName(String name) {
		Category category = categoryRepository.getCategoryByCategoryName(name);
		List<Room> rooms = filterByCategory(category);
		return rooms;
	}
	
	public List<Room> filterByCategory(Category category){
		List<Room> result = new ArrayList<>();
		for (Room room : roomRepository.findAll()) {
			if(room.getCategory().equals(category)) {
				result.add(room);
			}
		}
		return result;
	}
	
	public List<Room> availableRooms(){
		List<Room> result = new ArrayList<>();
		for (Room room : roomRepository.findAll()) {
			if (room.getAvailable() == 1) {
				result.add(room);
			}
		}
		return result;
	}
	
	public Room save(Room room) {
		return roomRepository.save(room);
	}
	
	public Optional<Room> findById(Long id){
		return roomRepository.findById(id);
	}
}

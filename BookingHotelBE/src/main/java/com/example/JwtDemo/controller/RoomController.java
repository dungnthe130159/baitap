package com.example.JwtDemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JwtDemo.entity.Room;

import com.example.JwtDemo.service.JournalService;
import com.example.JwtDemo.service.RoomService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/auth/signin")

public class RoomController {
	@Autowired
	private RoomService roomService;
	private JournalService journalService;
	
	@GetMapping("/findAllRooms")
	private List<Room> findAllRoom(){
		return roomService.getAllRooms();
	}
	
	@PostMapping("/addRoom")
	public ResponseEntity<Room> createNewRoom(@RequestBody Room room){
		return ResponseEntity.ok(roomService.save(room));
	}

	@GetMapping("/find/category/{name}")
	private List<Room> findByCategoryName(@PathVariable String name) {
		return roomService.findByCategoryName(name);
	}
	
	@GetMapping("/room/available")
	private List<Room> getAvailableRooms() {
		return roomService.availableRooms();
	}
	
	@GetMapping("/room/{id}")
	public ResponseEntity<Room> getRoomById(@PathVariable Long id){
		Optional<Room> roomOptional = roomService.findById(id);
		return roomOptional.map(room -> new ResponseEntity<>(room,HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}

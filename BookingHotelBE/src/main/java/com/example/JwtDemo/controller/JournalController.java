package com.example.JwtDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JwtDemo.entity.BookingJournal;
import com.example.JwtDemo.entity.User;
import com.example.JwtDemo.service.JournalService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/auth/signin")
public class JournalController {
	@Autowired 
	private JournalService journalService;
	
//	@RequestMapping(value = "/booking",method = RequestMethod.GET)
	@GetMapping("/booking")
	private List<BookingJournal> findallBooking(){
		return journalService.findAllBookingJournals();
	}
	
//  @RequestMapping(value = "/findBookingUser/{userID}", method = RequestMethod.GET)
    @GetMapping("/findBookingUser/{userID}")
	private List<BookingJournal> findBookingUser(@PathVariable("userID") User user){
    	return journalService.findBookingUser(user);
    }
    
    @PostMapping("/bookingRoom")
    public ResponseEntity<BookingJournal> createNewBook(@RequestBody BookingJournal book){
    	return ResponseEntity.ok(journalService.save(book));
    }
}
//2023-01-17

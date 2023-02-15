package com.example.JwtDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JwtDemo.entity.BookingJournal;
import com.example.JwtDemo.entity.User;
import com.example.JwtDemo.repository.BookingJournalRepository;

@Service
public class JournalService {
	@Autowired
	private BookingJournalRepository bookingJournalRepository;
	
//    public Room bookRoom(Room room, User user, List<Feature> features, int year, int month, int dayOfMonth) {
//		LocalDate dateFrom = LocalDate.now();
//		LocalDate dateTo = LocalDate.of(year, month, dayOfMonth);
//		
//        List<Feature> featuresList = new ArrayList<>();
//		
//        return bookRoom(user, room, dateFrom, dateTo, featuresList);
//    }
    
//    private Room bookRoom(User user, Room room, LocalDate dateFrom, LocalDate dateTo, List<Feature> features) {
//    	double price = PriceCalculator.getPrice(room, features);
//    	BookingJournal journalEntry = new BookingJournal(user, room, dateFrom, dateTo, price);
//    	return bookingJournalRepository.save(journalEntry).getRoomId();
//    }
    
    public List<BookingJournal> findAllBookingJournals(){
    	return bookingJournalRepository.findAll();
    }
    
    public List<BookingJournal> findBookingUser(User user){
    	return bookingJournalRepository.findByUser(user);
    }
    
	public BookingJournal save(BookingJournal book) {
		// TODO Auto-generated method stub
		return bookingJournalRepository.save(book);
	}
}

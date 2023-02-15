package com.example.JwtDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.JwtDemo.entity.BookingJournal;
import com.example.JwtDemo.entity.User;

@Repository
public interface BookingJournalRepository extends JpaRepository<BookingJournal, Long> {
	
	List<BookingJournal> findByUser(User user);
	
	List<BookingJournal> findAll();
}

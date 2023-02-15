package com.example.JwtDemo.playload.request;

import java.util.List;

import com.example.JwtDemo.entity.Feature;
import com.example.JwtDemo.entity.Room;
import com.example.JwtDemo.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookingRequest {
	private User userId;
	private Room roomId;
	private List<Feature> features;
	private int year;
	private int month;
	private int dayOfMonth;
	
	
	
}

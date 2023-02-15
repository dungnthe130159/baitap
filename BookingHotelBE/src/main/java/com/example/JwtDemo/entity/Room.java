package com.example.JwtDemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "room")
@Getter
@Setter
public class Room {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    private String number;
    private double price;
    private int available;
    
	public Room(Category category, String number, double price, int available) {
		this.category = category;
		this.number = number;
		this.price = price;
		this.available = available;
	}
	public Room() {
		
	}
}

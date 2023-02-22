package com.example.JwtDemo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "user")
@Getter
@Setter
@SuperBuilder
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(max = 20)
	private String username;

	@Size(max = 20)
	@Email
	private String email;

	@Size(max = 20)
	private String phone;
	
	@Size(max = 20)
	private String address;
	
	@Size(max = 120)
	private String password;
	
	private Date birthDate;
	
	@Size(min = 12, max = 12)
	private int CCCD;
	
	
}

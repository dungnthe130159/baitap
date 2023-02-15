package com.example.JwtDemo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "user", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "userName"),
      @UniqueConstraint(columnNames = "email") 
    })
@Getter
@Setter
@SuperBuilder
@Data
public class User {
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

	@ManyToMany
	@JoinTable(  name = "user_roles", 
	        joinColumns = @JoinColumn(name = "user_id"), 
	        inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public User() {
	
	}

	public User(String username, String email,String phone,String address,String password) {
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.password = password;
	}


	
//	public UserDto toDto() {
//		return UserDto.builder()
//				.id(this.id)
//				.username(this.username)
//				.email(this.email)
//				.phone(this.phone)
//				.address(address)
//				.build();
//				
//	}
//	
//	public static User toDomain(UserDto user) {
//		return User.builder()
//				.id(user.getId())
//				.username(user.getUsername())
//				.email(user.getEmail())
//				.phone(user.getPhone())
//				.address(user.getAddress())
//				.build();
//	}
}

package com.example.JwtDemo.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
	private Long id;
	private String username;
	private String email;
	private String phone;
	private String address;
	private Set<String> roles;

}

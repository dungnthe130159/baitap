package com.example.JwtDemo.playload.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {
	  private String token;
	  private String type = "Bearer";
	  private Long id;
	  private String username;
	  private String email;
	  private String phone;
	  private String address;
	  private List<String> roles;
	public JwtResponse(String accessToken, Long id, String username, String email, String phone, String address,
			List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.roles = roles;
	}
}

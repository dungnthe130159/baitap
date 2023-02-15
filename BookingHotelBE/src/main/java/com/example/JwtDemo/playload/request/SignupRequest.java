package com.example.JwtDemo.playload.request;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {
	  @NotBlank
	  @Size(min = 3, max = 20)
	  private String username;
	  
	  @NotBlank
	  @Size(max = 50)
	  @Email
	  private String email;	  
	  
	  @NotBlank
	  @Size(max = 50)
	  private String phone;
	  
	  @NotBlank
	  @Size(max = 50)
	  private String address;
	  
	  private Set<String> role;

	  @NotBlank
	  @Size(min = 6, max = 40)
	  private String password;
}

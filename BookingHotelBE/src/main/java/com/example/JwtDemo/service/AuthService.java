package com.example.JwtDemo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.JwtDemo.dto.Message;
import com.example.JwtDemo.entity.Response;
import com.example.JwtDemo.entity.Role;
import com.example.JwtDemo.entity.User;
import com.example.JwtDemo.models.ERole;
import com.example.JwtDemo.playload.request.LoginRequest;
import com.example.JwtDemo.playload.request.SignupRequest;
import com.example.JwtDemo.playload.response.JwtResponse;
import com.example.JwtDemo.repository.RoleRepository;
import com.example.JwtDemo.repository.UserRepository;
import com.example.JwtDemo.security.jwt.JwtUtils;
import com.example.JwtDemo.security.service.UserDetailsImpl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


@Service
public class AuthService {
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	JwtUtils jwtUtils;
	
	public JwtResponse Login(LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt =  jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		
		return new JwtResponse(jwt,userDetails.getId(),
				userDetails.getUsername(),
				userDetails.getEmail(),
				userDetails.getPhone(),
				userDetails.getAddress(),
				roles);
	}
	
	public Response<User> signup(SignupRequest signUpRequest) {
		boolean checkUsername = userRepository.existsByUsername(signUpRequest.getUsername());
		boolean checkEmail = userRepository.existsByEmail(signUpRequest.getEmail());
		Message message = new Message();
		
		if(checkUsername) {
			message = new Message("Error: Username is already in use");
		}
		
		if(checkEmail) {
			message = new Message("Error: Username is already in use");
		}
		
		User user = new User(signUpRequest.getUsername(),
				signUpRequest.getEmail(),
				signUpRequest.getPhone(),
				signUpRequest.getAddress(),
				signUpRequest.getBirthDate(),
				encoder.encode(signUpRequest.getPassword()));
		
		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
		
		if(strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not fond."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Error: Role is not fond."));
					roles.add(adminRole);
					
					break;
				case "mod":
					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
						.orElseThrow(() -> new RuntimeException("Error: Role is not fond."));
					roles.add(modRole);
					
					break;	
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
		              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		          roles.add(userRole);
				}
			});
		}
		
		user.setRoles(roles);
		userRepository.save(user);
		message = new Message("Register successfully");
		return new Response<>(message, user);
	}
}

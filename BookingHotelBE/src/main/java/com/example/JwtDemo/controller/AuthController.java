package com.example.JwtDemo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContext;

import com.example.JwtDemo.dto.Message;
import com.example.JwtDemo.entity.Role;
import com.example.JwtDemo.entity.User;
import com.example.JwtDemo.models.ERole;
import com.example.JwtDemo.playload.request.LoginRequest;
import com.example.JwtDemo.playload.request.MessageRequest;
import com.example.JwtDemo.playload.request.SignupRequest;
import com.example.JwtDemo.playload.response.JwtResponse;
import com.example.JwtDemo.playload.response.MessageResponse;
import com.example.JwtDemo.repository.RoleRepository;
import com.example.JwtDemo.repository.UserRepository;
import com.example.JwtDemo.security.jwt.JwtUtils;
import com.example.JwtDemo.security.service.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
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
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
	
	SecurityContextHolder.getContext().setAuthentication(authentication);
	String jwt = jwtUtils.generateJwtToken(authentication);
	
	UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
	List<String> roles = userDetails.getAuthorities().stream()
			.map(item -> item.getAuthority())
			.collect(Collectors.toList());
	
		return ResponseEntity.ok(new JwtResponse(jwt,
				userDetails.getId(),
				userDetails.getUsername(),
				userDetails.getEmail(),
				userDetails.getPhone(),
				userDetails.getAddress(),
				roles));
	}
	
	 @PostMapping("/signup")
	  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			Message message = new Message("Error: Username is already in use!");
			return new ResponseEntity<>(message,HttpStatus.OK);
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			Message message = new Message("Error: Email is already in use!");
			return new ResponseEntity<>(message,HttpStatus.OK);
		}
		
	    // Create new user's account
	    User user = new User(signUpRequest.getUsername(),
	    		signUpRequest.getEmail(),
	    		signUpRequest.getPhone(),
	    		signUpRequest.getAddress(),
	    		encoder.encode(signUpRequest.getPassword()));

	    Set<String> strRoles = signUpRequest.getRole();
	    Set<Role> roles = new HashSet<>();

	    if (strRoles == null) {
	      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
	          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	      roles.add(userRole);
	    } else {
	      strRoles.forEach(role -> {
	        switch (role) {
	        case "admin":
	          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(adminRole);

	          break;
	        case "mod":
	          Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(modRole);

	          break;
	        default:
	          Role userRole = roleRepository.findByName(ERole.ROLE_USER)
	              .orElseThrow(() -> new RuntimeException(MessageResponse("Error: Role is not found.")));
	          roles.add(userRole);
	        }
	      });
	    }
		
		user.setRoles(roles);
		userRepository.save(user);
		
		Message message = new Message("User registered successfully!");
		return new ResponseEntity<>(message,HttpStatus.OK);
//		return ResponseEntity.ok(new MessageResponse());
	}

	private String MessageResponse(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
//{
//    "username":"mod",
//    "email":"da@gmail.com",
//    "password":"asdasdas",
//    "phone":"312414",
//    "address":"hanoi",
//    "roles":["mod","user"]
//} https://www.bezkoder.com/spring-boot-jwt-mysql-spring-security-architecture/

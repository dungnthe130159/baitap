package com.example.JwtDemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JwtDemo.entity.Response;
import com.example.JwtDemo.entity.User;
import com.example.JwtDemo.playload.request.LoginRequest;
import com.example.JwtDemo.playload.request.SignupRequest;
import com.example.JwtDemo.playload.response.JwtResponse;
import com.example.JwtDemo.repository.RoleRepository;
import com.example.JwtDemo.repository.UserRepository;
import com.example.JwtDemo.security.jwt.JwtUtils;
import com.example.JwtDemo.service.AuthService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthService authService;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
		try {
			JwtResponse jwtOptional = authService.Login(loginRequest);
			return new ResponseEntity<>(jwtOptional,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest){
		try {
			Response<User> user = authService.signup(signUpRequest);
			return new ResponseEntity<>(user,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
		}
	}
}
//@PostMapping("/signin")
//public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
//	Authentication authentication = authenticationManager.authenticate(
//			new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//
//SecurityContextHolder.getContext().setAuthentication(authentication);
//String jwt = jwtUtils.generateJwtToken(authentication);
//
//UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//List<String> roles = userDetails.getAuthorities().stream()
//		.map(item -> item.getAuthority())
//		.collect(Collectors.toList());
//
//	return ResponseEntity.ok(new JwtResponse(jwt,
//			userDetails.getId(),
//			userDetails.getUsername(),
//			userDetails.getEmail(),
//			userDetails.getPhone(),
//			userDetails.getAddress(),
//			roles));
//}
	
//	 @PostMapping("/signup")
//	  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
//		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
//			Message message = new Message("Error: Username is already in use!");
//			return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
//		}
//
//		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//			Message message = new Message("Error: Email is already in use!");
//			return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
//		}
//		
//	    // Create new user's account
//	    User user = new User(signUpRequest.getUsername(),
//	    		signUpRequest.getEmail(),
//	    		signUpRequest.getPhone(),
//	    		signUpRequest.getAddress(),
//	    		signUpRequest.getBirthDate(),
//	    		encoder.encode(signUpRequest.getPassword()));
//
//	    Set<String> strRoles = signUpRequest.getRole();
//	    Set<Role> roles = new HashSet<>();
//
//	    if (strRoles == null) {
//	      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//	          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//	      roles.add(userRole);
//	    } else {
//	      strRoles.forEach(role -> {
//	        switch (role) {
//	        case "admin":
//	          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
//	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//	          roles.add(adminRole);
//
//	          break;
//	        case "mod":
//	          Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
//	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//	          roles.add(modRole);
//
//	          break;
//	        default:
//	          Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//	              .orElseThrow(() -> new RuntimeException(MessageResponse("Error: Role is not found.")));
//	          roles.add(userRole);
//	        }
//	      });
//	    }
//		
//		user.setRoles(roles);
//		userRepository.save(user);
//		
//		Message message = new Message("User registered successfully!");
//		return new ResponseEntity<>(message,HttpStatus.OK);
//		return ResponseEntity.ok(new MessageResponse());
//	}

//	private String MessageResponse(String string) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}
//{
//    "username":"mod",
//    "email":"da@gmail.com",
//    "password":"asdasdas",
//    "phone":"312414",
//    "address":"hanoi",
//    "roles":["mod","user"]
//} https://www.bezkoder.com/spring-boot-jwt-mysql-spring-security-architecture/

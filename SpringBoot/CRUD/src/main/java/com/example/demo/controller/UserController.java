package com.example.demo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.exception.BusinessException;
import com.example.demo.service.product.UserService;

@RestController
@RequestMapping("/user")
public class UserController {		
	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<?> createNewUser(@RequestBody @Valid UserDto dto) throws BusinessException  {		
		if(dto.getAge()>18) {
			return ResponseEntity.ok(userService.save(dto));
			
		}else {
			return new ResponseEntity<>("Vui long dien dung form", HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping
	public ResponseEntity<Iterable<UserDto>> getAllCategory() {
		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCategory(@PathVariable @Valid Integer id) throws BusinessException {
		Optional<UserDto> categoryOptional = userService.findById(id);
//		return categoryOptional.map(category -> new ResponseEntity<>(category, HttpStatus.OK))
//				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
		if(categoryOptional.isPresent()) {
			return new ResponseEntity<>(categoryOptional.get(), HttpStatus.OK);
		} else {
//			throw new BusinessException("Không tồn tại");
			return new ResponseEntity<>("Không tồn tại", HttpStatus.NOT_FOUND);
		}	
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable Integer id, @RequestBody UserDto dto ) {
		Optional<UserDto> userOptional = userService.findById(id);
		return userOptional.map(user1 -> {
			dto.setId(user1.getId());
			return new ResponseEntity<>(userService.save(dto), HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<UserDto> deleteUser(@PathVariable Integer id){
		Optional<UserDto> userOptional = userService.findById(id);
		return userOptional.map(user -> {
			userService.remove(id);
			return new ResponseEntity<>(user,HttpStatus.OK);
		}).orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}

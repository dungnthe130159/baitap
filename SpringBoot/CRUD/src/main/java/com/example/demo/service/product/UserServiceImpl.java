package com.example.demo.service.product;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.packageEnum.Role;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	UserDto user = new UserDto();

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Iterable<UserDto> findAll() {
        return userRepository.findAll().stream().map(User::toDto)::iterator;
    }

	@Override
	public Optional<UserDto> findById(Integer id){
		// query method name
		Optional<User> userOptional  = userRepository.findById(id);
		if(userOptional.isPresent()) {
			return Optional.ofNullable(userOptional.get().toDto());
		}else {
			return Optional.ofNullable(null);
		}
		
	}

	@Override
	public UserDto save(UserDto t) {
//		if(t.getAge()>18) {
//			t.setRole(user.getRole());
//			return userRepository.save(User.toDomain(t)).toDto();
//		}
		return userRepository.save(User.toDomain(t)).toDto();	
		}

	@Override
	public void remove(Integer id) {
		userRepository.deleteById(id);
	}

}

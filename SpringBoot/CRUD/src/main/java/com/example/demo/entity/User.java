package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.dto.UserDto;
import com.example.demo.packageEnum.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Builder
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String name;
	private String username;
	private String email;
	private String password;
	private String fullname;
	private String address;
	private int age;
	private String sex;
	private String role; // tạo 1 bảng role gồm ADMIN, USER,...(PHẦN QUYỀN) => ĐĂNG NHẬP 1. TẠO EMUN, 2 TẠO BẢNG ROLE
	
	public UserDto toDto() {
		return UserDto.builder()
				.id(this.id)
				.name(this.name)
				.username(this.username)
				.email(this.email)
				.fullname(this.fullname)
				.address(this.address)
				.age(this.age)
				.sex(this.sex)
				.role(this.role)
				.build();
	}
	
	public static User toDomain(UserDto dto) {
		return User.builder()
				.id(dto.getId())
				.name(dto.getName())
				.username(dto.getUsername())
				.email(dto.getEmail())
				.fullname(dto.getFullname())
				.address(dto.getAddress())
				.age(dto.getAge())
				.sex(dto.getSex())
				.role(dto.getRole())
				.build();
	}
	
	
}

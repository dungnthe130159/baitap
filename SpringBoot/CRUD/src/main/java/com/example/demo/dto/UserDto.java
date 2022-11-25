package com.example.demo.dto;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;

import com.example.demo.packageEnum.Role;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
	private int id;
	
	
	private String name;
	
//	 username là duy nhất có từ 5->20 ký tự
	@Column(nullable = false, length = 128)
    @NotNull @Length(min=5 ,max =20 ,message = "name must be 5-20 characters")
	private String username;
	
	// validate dạng email có @gmail.com
	// sử dụng regexp
//	@Pattern(regexp = "[a-zA-Z0-9._+-]+(\\.[_a-zA-Z0-9]+)*@[_a-zA-Z0-9._+-]+(\\.[a-zA-Z0-9]+))+", message = "validation.input.email")
	@Pattern(regexp = "[a-zA-Z0-9._+-]+(\\.[_a-zA-Z0-9]+)*@[_a-zA-Z0-9._+-]+(\\.[_a-zA-Z0-9]+)+",
			message = "Please enter a valid email address.")
	private String email;
	
	// ít nhất gồm 8 ký tự gồm chữ hoa, thường, số, ký tự đặc biệt
	@Pattern(regexp = "^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$",
			message = "Please enter a valid password.")
	private String password;
	
	private String fullname;
	
	private String address;
	
	// phải trên 18+ mới đăng ký, update được
	private int age;
	
	private String sex;
	
	// khi đăng ký sẽ tự để role là "ROLE_USER"
	private String role =Role.USER.toString() ;
}

package com.example.demo.web.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserForm {

	@NotBlank
	@Size(max=50)
	private String username;
	@NotBlank
	@Size(min=8, max=100)
	private String password;
	@NotBlank
	private String authority;
}

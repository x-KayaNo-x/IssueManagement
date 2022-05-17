package com.example.demo.domain.auth;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	
	@NotNull
	@Size(max = 50)
	private String username;
	
	@NotNull
	@Size(min = 8, max = 100)
	private String password;
	
	private Authority authority;
	
	public enum Authority {
		ADMIN,
		USER,
	}
}

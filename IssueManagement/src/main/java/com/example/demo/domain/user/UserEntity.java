package com.example.demo.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserEntity {

	private int id;
	private String username;
	private String password;
	private String authority;
}

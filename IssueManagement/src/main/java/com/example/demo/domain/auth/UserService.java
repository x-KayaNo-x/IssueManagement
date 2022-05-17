package com.example.demo.domain.auth;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public void create(String username, String password, String authority) {
		var encodedPassword = passwordEncoder.encode(password);
		userRepository.create(username, encodedPassword, authority);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

}

package com.example.demo.domain.user;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;

	public void create(String username, String password, String authority) {
		userRepository.create(username, password, authority);
	}

	public List<UserEntity> findAll() {
		return userRepository.findAll();
	}

}

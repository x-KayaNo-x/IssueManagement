package com.example.demo.domain.auth;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@PreAuthorize("hasAuthority('ADMIN')")
	public void create(String username, String password, String authority) {
		var encodedPassword = passwordEncoder.encode(password);
		userRepository.create(username, encodedPassword, authority);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<User> findAll() {
		return userRepository.findAll();
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	public String delete(String username, String getUsername) {
		if (!username.equals(getUsername)){
			userRepository.delete(username);
			return "";
		}
		return "ログイン中のアカウントは削除できません。";
	}

}

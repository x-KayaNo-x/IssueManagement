package com.example.demo.domain.auth;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 return this.userRepository.findByUsername(username)
				.map(
					user -> new CustomUser(
							user.getUsername(),
							user.getPassword(),
							toGrantedAythorityList(user.getAuthority())
					)
				)
				.orElseThrow(
					() -> new UsernameNotFoundException(
							"Given username is not found.(username = '" + username + "')"
					)
				);
	}

	private Collection<? extends GrantedAuthority> toGrantedAythorityList(User.Authority authority) {
		return Collections.singletonList(new SimpleGrantedAuthority(authority.name()));
	}
}

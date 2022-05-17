package com.example.demo.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.demo.domain.auth.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String>{
	
	private final UserRepository userRepository;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return userRepository.findByUsername(value).isEmpty();
	}
	

}

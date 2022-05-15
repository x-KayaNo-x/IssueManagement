package com.example.demo.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.user.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;

	@GetMapping
	public String showList(Model model) {
		model.addAttribute("userList", userService.findAll());
		return "user/list";
	}
	
	@GetMapping("/createForm")
	public String showCreateForm(@ModelAttribute UserForm form) {
		return "user/createForm";
	}
	
	@PostMapping("createForm")
	public String createForm(@Validated UserForm form, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return showCreateForm(form);
		}
		userService.create(form.getUsername(), form.getPassword(), form.getAuthority());
		return "redirect:/user";
	}
	
	
	
	
	
	
}

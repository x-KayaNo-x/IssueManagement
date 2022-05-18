package com.example.demo.web.user;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.auth.UserService;

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
	@GetMapping("/delete/{username}")
	public String delete(@PathVariable("username") String username, @AuthenticationPrincipal UserDetails user, Model model) {
		String message = userService.delete(username, user.getUsername());
		if (!message.equals("")) {
			model.addAttribute("message",message);
			model.addAttribute("userList", userService.findAll());
			return "user/list";
		}
		return showList(model);
	}
	
}

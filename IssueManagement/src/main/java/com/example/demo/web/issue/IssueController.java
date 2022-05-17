package com.example.demo.web.issue;

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

import com.example.demo.domain.issue.IssueService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/issue")
@RequiredArgsConstructor
public class IssueController {
	
	private final IssueService issueService;

	@GetMapping
	public String showList(@AuthenticationPrincipal UserDetails user, Model model) {
		System.out.print(user.getUsername());
		model.addAttribute("issueList", issueService.findAll(user.getUsername()));
		return "issue/list";
	}
	
	@GetMapping("/select")
	public String showSelectList(@AuthenticationPrincipal UserDetails user, String keyword, Model model) {
		model.addAttribute("issueList", issueService.findByKeyword(keyword, user.getUsername()));
		return "issue/list";
	}
	
	@GetMapping("/{id}")
	public String showDetail(@PathVariable("id") int id, Model model) {
		model.addAttribute("issue", issueService.findById(id));		
		return "issue/detail";
	}
	
	@GetMapping("/createForm")
	public String showCreateForm(@ModelAttribute IssueForm form){
		return "issue/createForm";
	}
	
	@PostMapping("/createForm")
	public String create(@Validated IssueForm form, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return showCreateForm(form);
		}
		issueService.create(form.getSummary(), form.getDescription(), form.getPriority());
		return "redirect:/issue"; 
	}
	
	@GetMapping("/update/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		model.addAttribute("issueForm", issueService.findById(id));
		return "issue/updateForm";
	}
	
	@PostMapping("/updateForm/{id}")
	public String update(@Validated IssueForm form, BindingResult bindingResult,
			@PathVariable("id") int id, Model model) {
		if (bindingResult.hasErrors()) {
			return "issue/updateForm";
		}
		issueService.update(id, form.getSummary(), form.getDescription(), form.getPriority());
		return "redirect:/issue"; 
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id,@AuthenticationPrincipal UserDetails user, Model model) {
		issueService.delete(id);
		return showList(user, model);
	}
	
	
}

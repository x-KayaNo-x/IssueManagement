package com.example.demo.web.issue;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String showList(Model model) {
		model.addAttribute("issueList", issueService.findAll());
		return "issue/list";
	}
	
	@GetMapping("/{id}")
	public String showDetail(@PathVariable("id") int id, Model model) {
		model.addAttribute("issue", issueService.findById(id));		
		return "issue/detail";
	}
	
	@GetMapping("/createForm")
	public String showCreateForm(){
		return "issue/createForm";
	}
	
	@PostMapping("/createForm")
	public String createForm(IssueForm form) {
		issueService.create(form.getSummary(), form.getDesctiption());
		return "redirect:/issue"; 
	}
	
	
	
	
	
}

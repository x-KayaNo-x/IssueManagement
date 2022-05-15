package com.example.demo.web.issue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IssueForm {

	@NotBlank
	@Size(max=200)
	private String summary;
	
	@NotBlank
	@Size(max=200)
	private String desctiption;
}

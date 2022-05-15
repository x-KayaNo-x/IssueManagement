package com.example.demo.web.issue;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IssueForm {

	private String summary;
	private String desctiption;
}

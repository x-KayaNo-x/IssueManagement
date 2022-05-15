package com.example.demo.domain.issue;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IssueEntity {

	private int id;
	private String summary;
	private String description;
	private String priority;
}

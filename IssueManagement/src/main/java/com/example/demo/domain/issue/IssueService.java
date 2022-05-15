package com.example.demo.domain.issue;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IssueService {
	
	private final IssueRepository issueRepository;
	
	public List<IssueEntity> findAll(){
		return issueRepository.findAll();
	}

	public IssueEntity findById(int id) {
		return issueRepository.findById(id);
	}

	public void create(String summary, String description) {
		issueRepository.create(summary, description);
	}

}

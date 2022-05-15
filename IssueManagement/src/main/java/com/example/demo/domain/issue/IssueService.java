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

}

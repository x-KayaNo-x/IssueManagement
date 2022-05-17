package com.example.demo.domain.issue;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IssueService {
	
	private final IssueRepository issueRepository;
	
	public List<IssueEntity> findAll(String username){
		return issueRepository.findAll(username);
	}

	public IssueEntity findById(int id) {
		return issueRepository.findById(id);
	}

	public void create(String summary, String description, String username, String priority) {
		int priorityId = Integer.parseInt(priority);
		issueRepository.create(summary, description, username, priorityId);
	}

	public void update(int id, String summary, String description, String priority) {
		int priorityId = Integer.parseInt(priority);
		issueRepository.update(id, summary, description, priorityId);
	}

	public void delete(int id) {
		issueRepository.delete(id);
	}

	public List<IssueEntity> findByKeyword(String keyword, String username) {
		return issueRepository.findByKeyword(keyword, username);
	}

}

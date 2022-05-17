package com.example.demo.domain.issue;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IssueService {
	
	private final IssueRepository issueRepository;
//	private final UserRepository userRepository;
	
	public List<IssueEntity> findAll(){
//		int userId = userRepository.findUserId();
		return issueRepository.findAll();
	}

	public IssueEntity findById(int id) {
		return issueRepository.findById(id);
	}

	public void create(String summary, String description, String priority) {
		int priorityId = Integer.parseInt(priority);
		issueRepository.create(summary, description, priorityId);
	}

	public void update(int id, String summary, String description, String priority) {
		int priorityId = Integer.parseInt(priority);
		issueRepository.update(id, summary, description, priorityId);
	}

	public void delete(int id) {
		issueRepository.delete(id);
	}

	public List<IssueEntity> findByKeyword(String keyword) {
		return issueRepository.findByKeyword(keyword);
	}

}

package com.keyin.server.service;

import com.keyin.server.entity.Issue;
import com.keyin.server.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService {
    
    @Autowired
    private IssueRepository issueRepository;
    
    public List<Issue> getAllIssues() {return issueRepository.findAll();}
    
    public Issue getIssueByID(Long ID) {return issueRepository.findById(ID).orElse(null);}
    
    public Issue saveIssue(Issue issue) {return issueRepository.save(issue);}
    
    public Issue updateIssue(Long ID, Issue issue) {
        issue.setID(ID);
        return issueRepository.save(issue);
    }
    
    public void deleteIssue(Long ID) {issueRepository.deleteById(ID);}
    
    public List<Issue> getIssuesByCustomerID(Long customerID) {return issueRepository.findByCustomerID(customerID);}
} 
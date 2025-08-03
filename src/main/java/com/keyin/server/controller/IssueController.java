package com.keyin.server.controller;

import com.keyin.server.entity.Issue;
import com.keyin.server.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/issues")
@CrossOrigin(origins = "*")
public class IssueController {
    
    @Autowired
    private IssueService issueService;
    
    @GetMapping
    public List<Issue> getAllIssues() {return issueService.getAllIssues();}
    
    @GetMapping("/{id}")
    public Issue getIssueByID(@PathVariable Long id) {return issueService.getIssueByID(id);}
    
    @PostMapping
    public Issue createIssue(@RequestBody Issue issue) {return issueService.saveIssue(issue);}

    @PutMapping("/{id}")
    public Issue updateIssue(@PathVariable Long id, @RequestBody Issue issue) {return issueService.updateIssue(id, issue);}
    
    @DeleteMapping("/{id}")
    public void deleteIssue(@PathVariable Long id) {issueService.deleteIssue(id);}
    
    @GetMapping("/customer/{customerID}")
    public List<Issue> getIssuesByCustomer(@PathVariable Long customerID) {return issueService.getIssuesByCustomerID(customerID);}
} 
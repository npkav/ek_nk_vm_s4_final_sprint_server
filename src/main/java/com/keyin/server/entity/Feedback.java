package com.keyin.server.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "customer_id")
    private Long customerID;
    
    @Column(name = "rep_id")
    private Long repID;
    
    @Column(name = "issue_id")
    private Long issueID;
    
    private Integer rating;
    private String comment;
    
    
    
    public Feedback() {}

    @JsonProperty("id")
    public Long getID() { return id; }
    public void setID(Long id) { this.id = id; }
    
    @JsonProperty("customerID")
    public Long getCustomerID() { return customerID; }
    public void setCustomerID(Long customerID) { this.customerID = customerID; }
    
    @JsonProperty("repID")
    public Long getRepID() { return repID; }
    public void setRepID(Long repID) { this.repID = repID; }
    
    @JsonProperty("issueID")
    public Long getIssueID() { return issueID; }
    public void setIssueID(Long issueID) { this.issueID = issueID; }
    
    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }
    
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
} 
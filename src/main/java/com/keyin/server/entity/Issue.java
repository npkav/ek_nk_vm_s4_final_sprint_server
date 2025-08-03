package com.keyin.server.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "issues")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "customer_id")
    private Long customerID;
    
    @Column(name = "assigned_rep_id")
    private Long assignedRepID;
    
    private String title;
    private String description;
    private String status;
    private String priority;
    

    
    public Issue() {}

    public Issue(String title, String description, String status, String priority) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    @JsonProperty("id")
    public Long getID() { return id; }
    public void setID(Long id) { this.id = id; }
    
    @JsonProperty("customerID")
    public Long getCustomerID() { return customerID; }
    public void setCustomerID(Long customerID) { this.customerID = customerID; }
    
    @JsonProperty("assignedRepID")
    public Long getAssignedRepID() { return assignedRepID; }
    public void setAssignedRepID(Long assignedRepID) { this.assignedRepID = assignedRepID; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }
    
    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
} 
package com.keyin.server.repository;

import com.keyin.server.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
    @Query("SELECT i FROM Issue i WHERE i.customerID = ?1")
    List<Issue> findByCustomerID(Long customerID);
    List<Issue> findByAssignedRepID(Long repId);
}
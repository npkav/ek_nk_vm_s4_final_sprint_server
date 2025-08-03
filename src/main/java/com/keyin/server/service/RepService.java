package com.keyin.server.service;

import com.keyin.server.entity.ServiceRep;
import com.keyin.server.entity.Issue;
import com.keyin.server.repository.RepRepository;
import com.keyin.server.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepService {

    @Autowired
    private IssueRepository issueRepository;
    
    @Autowired
    private RepRepository RepRepository;
    
    public List<ServiceRep> getAllServiceReps() {return RepRepository.findAll();}
    
    public ServiceRep getServiceRepByID(Long ID) {return RepRepository.findById(ID).orElse(null);}

    public List<Issue> getIssuesByRepID(Long repID) {
        return issueRepository.findByAssignedRepID(repID);
    }

    public List<ServiceRep> filterReps(Long departmentID, Long roleID) {
        if (departmentID != null && roleID != null) {
            return RepRepository.findByDepartmentIDAndRoleID(departmentID, roleID);
        } else if (departmentID != null) {
            return RepRepository.findByDepartmentID(departmentID);
        } else if (roleID != null) {
            return RepRepository.findByRoleID(roleID);
        } else {
            return RepRepository.findAll();
        }
    }

    public List<ServiceRep> searchRepsByName(String name) {
        return RepRepository.findByFirstNameOrLastName(name, name);
    }

    public List<ServiceRep> getRepsByRole(Long roleID) {
        return RepRepository.findByRoleID(roleID);
    }
    
    public ServiceRep saveServiceRep(ServiceRep serviceRep) {return RepRepository.save(serviceRep);}
    
    public ServiceRep updateServiceRep(Long ID, ServiceRep serviceRep) {
        serviceRep.setID(ID);
        return RepRepository.save(serviceRep);
    }
    
    public void deleteServiceRep(Long ID) {RepRepository.deleteById(ID);}
} 
package com.keyin.server.controller;

import com.keyin.server.entity.ServiceRep;
import com.keyin.server.entity.Issue;
import com.keyin.server.service.RepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicereps")
@CrossOrigin(origins = "*")
public class RepController {
    
    @Autowired
    private RepService repService;
    
    // READ
    @GetMapping
    public List<ServiceRep> getAllServiceReps() {return repService.getAllServiceReps();}
    
    @GetMapping("/{id}")
    public ServiceRep getServiceRepByID(@PathVariable Long id) {return repService.getServiceRepByID(id);}

    @GetMapping("/{id}/issues")
    public List<Issue> getIssuesByRepID(@PathVariable Long id) {
        return repService.getIssuesByRepID(id);
    }

    @GetMapping("/filter")
    public List<ServiceRep> filterReps(
        @RequestParam(required = false) Long departmentID,
        @RequestParam(required = false) Long roleID) {
        return repService.filterReps(departmentID, roleID);
    }

    @GetMapping("/search")
    public List<ServiceRep> searchRepsByName(@RequestParam String name) {
        return repService.searchRepsByName(name);
    }
    
    // CREATE
    @PostMapping
    public ServiceRep createServiceRep(@RequestBody ServiceRep serviceRep) {return repService.saveServiceRep(serviceRep);}
    
    // UPDATE
    @PutMapping("/{id}")
    public ServiceRep updateServiceRep(@PathVariable Long id, @RequestBody ServiceRep serviceRep) {return repService.updateServiceRep(id, serviceRep);}
    
    // DELETE
    @DeleteMapping("/{id}")
    public void deleteServiceRep(@PathVariable Long id) {repService.deleteServiceRep(id);}
} 
package com.keyin.server.controller;

import com.keyin.server.entity.Department;
import com.keyin.server.entity.ServiceRep;
import com.keyin.server.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin(origins = "*")
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;
    
    // READ
    @GetMapping
    public List<Department> getAllDepartments() {return departmentService.getAllDepartments();}
    
    @GetMapping("/{id}")
    public Department getDepartmentByID(@PathVariable Long id) {return departmentService.getDepartmentByID(id);}

    @GetMapping("/{id}/reps")
    public List<ServiceRep> getRepsByDepartment(@PathVariable Long id) {
        return departmentService.getRepsByDepartment(id);
    }
    
    // CREATE
    @PostMapping
    public Department createDepartment(@RequestBody Department department) {return departmentService.saveDepartment(department);}
    
    // UPDATE
    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department) {return departmentService.updateDepartment(id, department);}
    
    // DELETE
    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {departmentService.deleteDepartment(id);}
} 
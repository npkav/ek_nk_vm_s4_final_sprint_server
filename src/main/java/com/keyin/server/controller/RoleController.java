package com.keyin.server.controller;

import com.keyin.server.entity.Role;
import com.keyin.server.entity.ServiceRep;
import com.keyin.server.service.RoleService;
import com.keyin.server.service.RepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    
    @Autowired
    private RoleService roleService;

    @Autowired
    private RepService repService;

    // READ
    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }
    
    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable Long id) {
        return roleService.getRoleByID(id);
    }

    @GetMapping("/{id}/reps")
    public List<ServiceRep> getRepsByRole(@PathVariable Long id) {
        return repService.getRepsByRole(id);
    }
    
    // CREATE
    @PostMapping
    public Role createRole(@RequestBody Role role) {
        return roleService.saveRole(role);
    }
    
    // UPDATE
    @PutMapping("/{id}")
    public Role updateRole(@PathVariable Long id, @RequestBody Role role) {
        return roleService.updateRole(id, role);
    }
    
    // DELETE
    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }
}
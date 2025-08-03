package com.keyin.server.service;

import com.keyin.server.entity.Role;
import com.keyin.server.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    
    @Autowired
    private RoleRepository roleRepository;
    
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
    
    public Role getRoleByID(Long id) {
        return roleRepository.findById(id).orElse(null);
    }
    
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }
    
    public Role updateRole(Long id, Role role) {
        role.setID(id);
        return roleRepository.save(role);
    }
    
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
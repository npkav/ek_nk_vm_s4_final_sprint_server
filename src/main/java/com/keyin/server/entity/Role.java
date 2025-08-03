package com.keyin.server.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "role_name")
    private String roleName;
    
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;
    

    
    public Role() {}
    
    @JsonProperty("id")
    public Long getID() { return id; }
    public void setID(Long id) { this.id = id; }
    
    public String getRoleName() { return roleName; }
    public void setRoleName(String roleName) { this.roleName = roleName; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    @JsonProperty("departmentID")
    public void setDepartmentFromId(Long departmentID) {
        this.department = new Department();
        this.department.setID(departmentID);
    }
    public Long getDepartmentID() {
        return department != null ? department.getID() : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id != null && id.equals(role.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Role{" + "id=" + id + ", roleName='" + roleName + '\'' + ", description='" + description + '\'' + ", department=" + (department != null ? department.getID() : "null") + '}';
    }
}
package com.keyin.server.repository;

import com.keyin.server.entity.ServiceRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RepRepository extends JpaRepository<ServiceRep, Long> {
    @Query("SELECT sr FROM ServiceRep sr WHERE sr.departmentID.id = :departmentID")
    List<ServiceRep> findByDepartmentID(@Param("departmentID") Long departmentID);

    @Query("SELECT sr FROM ServiceRep sr WHERE sr.roleID.id = :roleID")
    List<ServiceRep> findByRoleID(@Param("roleID") Long roleID);

    @Query("SELECT sr FROM ServiceRep sr WHERE sr.departmentID.id = :departmentID AND sr.roleID.id = :roleID")
    List<ServiceRep> findByDepartmentIDAndRoleID(@Param("departmentID") Long departmentID, @Param("roleID") Long roleID);
    
    List<ServiceRep> findByFirstNameOrLastName(String firstName, String lastName);
}
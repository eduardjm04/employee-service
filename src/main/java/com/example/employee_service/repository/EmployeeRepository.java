package com.example.employee_service.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.employee_service.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

    @Query("""
                SELECT e
                FROM EmployeeEntity e
                WHERE LOWER(e.firstName) LIKE CONCAT('%', LOWER(:name), '%')
                OR LOWER(e.secondName) LIKE CONCAT('%', LOWER(:name), '%')
            """)
    Page<EmployeeEntity> searchByName(@Param("name") String name, Pageable pageable);

}

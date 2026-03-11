package com.example.employee_service.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.employee_service.dto.EmployeeCreateDTO;
import com.example.employee_service.dto.EmployeeResponseDTO;
import com.example.employee_service.dto.EmployeeUpdateDTO;

public interface EmployeeService {

    Page<EmployeeResponseDTO> getAllEmployees(Pageable pageable);

    EmployeeResponseDTO getEmployee(Integer id);

    List<EmployeeResponseDTO> createEmployees(List<EmployeeCreateDTO> employees);

    EmployeeResponseDTO updateEmployee(Integer id, EmployeeUpdateDTO employeeUpdateDTO);

    void deleteEmployee(Integer id);

    Page<EmployeeResponseDTO> searchEmployeeByName(String name, Pageable pageable);
}

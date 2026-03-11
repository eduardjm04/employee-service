package com.example.employee_service.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.employee_service.dto.EmployeeCreateDTO;
import com.example.employee_service.dto.EmployeeResponseDTO;
import com.example.employee_service.dto.EmployeeUpdateDTO;
import com.example.employee_service.mapper.EmployeeMapper;
import com.example.employee_service.repository.EmployeeRepository;
import com.example.employee_service.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public Page<EmployeeResponseDTO> getAllEmployees(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllEmployees'");
    }

    @Override
    public EmployeeResponseDTO getEmployee(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmployee'");
    }

    @Override
    public List<EmployeeResponseDTO> createEmployees(List<EmployeeCreateDTO> employees) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createEmployees'");
    }

    @Override
    public EmployeeResponseDTO updateEmployee(Integer id, EmployeeUpdateDTO employeeUpdateDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateEmployee'");
    }

    @Override
    public void deleteEmployee(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteEmployee'");
    }

    @Override
    public Page<EmployeeResponseDTO> searchEmployeeByName(String name, Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchEmployeeByName'");
    }

}

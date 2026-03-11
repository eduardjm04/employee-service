package com.example.employee_service.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.employee_service.dto.EmployeeCreateDTO;
import com.example.employee_service.dto.EmployeeResponseDTO;
import com.example.employee_service.dto.EmployeeUpdateDTO;
import com.example.employee_service.entity.EmployeeEntity;
import com.example.employee_service.exception.ResourceNotFoundException;
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
        log.info("Fetching employees page={} size={}", pageable.getPageNumber(), pageable.getPageSize());
        return employeeRepository.findAll(pageable).map(employeeMapper::toEmployeeResponseDTO);
    }

    @Override
    public EmployeeResponseDTO getEmployee(Integer id) {
        log.info("Fetching employee with id={}", id);

        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Employee not found with id={}", id);
                    return new ResourceNotFoundException("Employee", id);
                });

        return employeeMapper.toEmployeeResponseDTO(employee);
    }

    @Override
    public List<EmployeeResponseDTO> createEmployees(List<EmployeeCreateDTO> employees) {
        log.info("Creating {} employees", employees.size());

        List<EmployeeEntity> entities = employees.stream()
                .map(employeeMapper::toEmployeeEntityCreate)
                .toList();

        List<EmployeeEntity> saved = employeeRepository.saveAll(entities);

        log.info("Employees created successfully");

        return saved.stream()
                .map(employeeMapper::toEmployeeResponseDTO)
                .toList();
    }

    @Override
    public EmployeeResponseDTO updateEmployee(Integer id, EmployeeUpdateDTO employeeUpdateDTO) {
        log.info("Updating employee id={}", id);

        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Employee not found with id={}", id);
                    return new ResourceNotFoundException("Employee", id);
                });

        employeeMapper.updateEmployeeFromDTO(employeeUpdateDTO, employee);

        EmployeeEntity updated = employeeRepository.save(employee);

        log.info("Employee updated id={}", id);

        return employeeMapper.toEmployeeResponseDTO(updated);
    }

    @Override
    public void deleteEmployee(Integer id) {
        log.info("Deleting employee id={}", id);

        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Employee not found with id={}", id);
                    return new ResourceNotFoundException("Employee", id);
                });

        employeeRepository.delete(employee);

        log.info("Employee deleted id={}", id);
    }

    @Override
    public Page<EmployeeResponseDTO> searchEmployeeByName(String name, Pageable pageable) {
        log.info("Fetching employee with name={}", name);

        return employeeRepository.searchByName(
                name.trim().toLowerCase(), pageable)
                .map(employeeMapper::toEmployeeResponseDTO);
    }

}

package com.example.employee_service.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.employee_service.dto.EmployeeResponseDTO;
import com.example.employee_service.entity.EmployeeEntity;
import com.example.employee_service.exception.ResourceNotFoundException;
import com.example.employee_service.mapper.EmployeeMapper;
import com.example.employee_service.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeMapper employeeMapper;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    void shouldReturnEmployeeWhenIdExists() {

        EmployeeEntity entity = new EmployeeEntity();
        entity.setId(1);

        EmployeeResponseDTO dto = new EmployeeResponseDTO();
        dto.setId(1);

        when(employeeRepository.findById(1)).thenReturn(Optional.of(entity));
        when(employeeMapper.toEmployeeResponseDTO(entity)).thenReturn(dto);

        EmployeeResponseDTO result = employeeService.getEmployee(1);

        assertNotNull(result);
        assertEquals(1, result.getId());

        verify(employeeRepository).findById(1);
    }

    @Test
    void shouldThrowExceptionWhenEmployeeNotFound() {

        when(employeeRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class,
                () -> employeeService.getEmployee(1));

        verify(employeeRepository).findById(1);
    }
}

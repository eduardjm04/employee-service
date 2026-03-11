package com.example.employee_service.mapper;

import org.springframework.stereotype.Component;

import com.example.employee_service.constant.AppConstants;
import com.example.employee_service.dto.EmployeeCreateDTO;
import com.example.employee_service.dto.EmployeeResponseDTO;
import com.example.employee_service.dto.EmployeeUpdateDTO;
import com.example.employee_service.entity.EmployeeEntity;
import com.example.employee_service.utils.DateUtils;

@Component
public class EmployeeMapper {

    public EmployeeResponseDTO toEmployeeResponseDTO(EmployeeEntity employeeEntity) {
        return EmployeeResponseDTO.builder()
                .id(employeeEntity.getId())
                .firstName(employeeEntity.getFirstName())
                .secondName(employeeEntity.getSecondName())
                .fatherLastName(employeeEntity.getFatherLastName())
                .motherLastName(employeeEntity.getMotherLastName())
                .gender(employeeEntity.getGender())
                .bornDate(employeeEntity.getBornDate())
                .position(employeeEntity.getPosition())
                .status(employeeEntity.getStatus())
                .age(DateUtils.calculateAge(employeeEntity.getBornDate()))
                .build();
    }

    public EmployeeEntity toEmployeeEntityCreate(EmployeeCreateDTO employeeCreateDTO) {
        return EmployeeEntity.builder()
                .firstName(employeeCreateDTO.getFirstName())
                .secondName(employeeCreateDTO.getSecondName())
                .fatherLastName(employeeCreateDTO.getFatherLastName())
                .motherLastName(employeeCreateDTO.getMotherLastName())
                .gender(employeeCreateDTO.getGender())
                .bornDate(employeeCreateDTO.getBornDate())
                .age(DateUtils.calculateAge(employeeCreateDTO.getBornDate()))
                .position(employeeCreateDTO.getPosition())
                .status(AppConstants.EMPLOYEE_ACTIVE_STATUS)
                .build();
    }

    public void updateEmployeeFromDTO(EmployeeUpdateDTO dto, EmployeeEntity entity) {
        if (dto.getFirstName() != null) {
            entity.setFirstName(dto.getFirstName());
        }

        if (dto.getSecondName() != null) {
            entity.setSecondName(dto.getSecondName());
        }

        if (dto.getFatherLastName() != null) {
            entity.setFatherLastName(dto.getFatherLastName());
        }

        if (dto.getMotherLastName() != null) {
            entity.setMotherLastName(dto.getMotherLastName());
        }

        if (dto.getGender() != null) {
            entity.setGender(dto.getGender());
        }

        if (dto.getBornDate() != null) {
            entity.setBornDate(dto.getBornDate());
            entity.setAge(DateUtils.calculateAge(dto.getBornDate()));
        }

        if (dto.getPosition() != null) {
            entity.setPosition(dto.getPosition());
        }

        if (dto.getStatus() != null) {
            entity.setStatus(dto.getStatus());
        }
    }
}

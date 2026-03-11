package com.example.employee_service.dto;

import java.time.LocalDate;

import com.example.employee_service.entity.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDTO {

    private Integer id;

    private String firstName;

    private String secondName;

    private String fatherLastName;

    private String motherLastName;

    private Gender gender;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate bornDate;

    private String position;

    private Boolean status;

    private Integer age;

}

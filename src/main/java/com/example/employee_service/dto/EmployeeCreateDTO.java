package com.example.employee_service.dto;

import java.time.LocalDate;

import com.example.employee_service.entity.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeCreateDTO {

    @NotBlank(message = "First name is required")
    private String firstName;

    private String secondName;

    @NotBlank(message = "Father's last name is required")
    private String fatherLastName;

    @NotBlank(message = "Mother's last name is required")
    private String motherLastName;

    @NotNull(message = "Gender is required")
    private Gender gender;

    @NotNull(message = "Born date is required")
    @Past(message = "Born date must be in the past")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate bornDate;

    @NotBlank(message = "Position is required")
    private String position;

}

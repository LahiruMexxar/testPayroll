package com.LV8.Test.DTO;

import lombok.Data;

@Data
public class EmployeeDto {
    private String firstName;
    private String lastName;
    private Long contactNumber;
    private String email;
    private String gender;
    private Long departmentId;
}

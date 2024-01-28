package com.LV8.Test.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class AllowanceDto {
    private Long employeeId;
    private Long departmentId;
    private double allowance;
    private String month;
    private Date date;
    private String status;

}

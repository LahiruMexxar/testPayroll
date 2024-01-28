package com.LV8.Test.Controllers;

import com.LV8.Test.DTO.AllowanceDto;
import com.LV8.Test.DTO.ApiResponse;
import com.LV8.Test.Models.Allowance;
import com.LV8.Test.Service.AllowanceService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/allowance")
@RequiredArgsConstructor
public class AllowanceController {
    @Autowired
    AllowanceService allowanceService;
    @PostMapping("/addAllowance")
    public ApiResponse addAllowanceToEmployee (@RequestBody AllowanceDto allowanceDto){
        try {
            return new ApiResponse<>(200,"Success","Allowance Added To Employee",allowanceService.createAllowanceToEmployees(allowanceDto));
        }catch (Exception e){
            return new ApiResponse<>(500,"Failed","Internal Error",e.getMessage());
        }
    }

    @PutMapping("/updateAllowance/{id}")
    public ApiResponse updateAllowance (@RequestBody AllowanceDto allowanceDto,@PathVariable Long id){
        try {
            return new ApiResponse<>(200,"Success","Allowance Updated To Employee",allowanceService.updateAllowance(allowanceDto,id));
        }catch (Exception e){
            return new ApiResponse<>(500,"Failed","Internal Error",e.getMessage());
        }
    }
    @GetMapping("/{month}")
    public ApiResponse getAllowanceByMonth (@PathVariable String month){
        try {
            return new ApiResponse<>(200,"Success","Allowance Retrieved By Month",allowanceService.getAllowanceByMonth(month));
        }catch (Exception e){
            return new ApiResponse<>(500,"Failed","Internal Error",e.getMessage());
        }
    }

    @GetMapping("/getByDateRange")
    public ApiResponse getAllowanceByDateRange (@RequestParam Date startdate,
                                                @RequestParam Date enddate){
        try {
            return new ApiResponse<>(200,"Success","Allowance Retrieved By Date Range",allowanceService.getAllowanceByDateRange(startdate,enddate));
        }catch (Exception e){
            return new ApiResponse<>(500,"Failed","Internal Error",e.getMessage());
        }
    }
}

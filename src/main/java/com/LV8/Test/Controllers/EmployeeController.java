package com.LV8.Test.Controllers;

import com.LV8.Test.DTO.ApiResponse;
import com.LV8.Test.DTO.EmployeeDto;
import com.LV8.Test.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //get all employees
    @GetMapping
    public ApiResponse getAllEmployees(){
        try {
            return new ApiResponse<>(200,"Success","Employees Retrieved",employeeService.getAllEmployees());
        }catch (Exception e){
            return new ApiResponse<>(500,"Failed","Internal Error",e.getMessage());
        }
    }

    //get department by Id
    @GetMapping("/{id}")
    public ApiResponse getEmployeesById(@PathVariable Long id){
        try {
            return new ApiResponse<>(200,"Success","Employee Retrieved By Id",employeeService.findEmployeesById(id));
        }catch (Exception e){
            return new ApiResponse<>(500,"Failed","Internal Error",e.getMessage());
        }
    }

    @GetMapping("/department/{id}")
    public ApiResponse getEmployeesByDepartmentId(@PathVariable Long id){
        try {
            return new ApiResponse<>(200,"Success","Employee Retrieved By Id",employeeService.getEmployeesByDepartmentId(id));
        }catch (Exception e){
            return new ApiResponse<>(500,"Failed","Internal Error",e.getMessage());
        }
    }

    //create department
    @PostMapping
    public ApiResponse createEmployeeWithDepartment(@RequestBody EmployeeDto employeeDto){
        try {
            return new ApiResponse<>(200,"Success","Employee Created",employeeService.addEmployeesWithDepartment(employeeDto));
        }catch (Exception e){
            return new ApiResponse<>(500,"Failed","Internal Error",e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ApiResponse updateEmployeeById (@RequestBody EmployeeDto employeeDto,@PathVariable long id){
        try {
            return new ApiResponse<>(200,"Success","Employee Updated",employeeService.updateEmployee(employeeDto,id));
        }catch (Exception e){
            return new ApiResponse<>(500,"Failed","Internal Error",e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteEmployeeById (@PathVariable Long id){
        try {
            employeeService.deleteEmployee(id);
            return new ApiResponse<>(200,"Success","Employee Deleted",null);
        }catch (Exception e){
            return new ApiResponse<>(500,"Failed","Internal Error",e.getMessage());
        }
    }
}

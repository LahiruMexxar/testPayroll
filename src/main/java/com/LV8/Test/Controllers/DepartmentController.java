package com.LV8.Test.Controllers;

import com.LV8.Test.DTO.ApiResponse;
import com.LV8.Test.DTO.DepartmentDto;
import com.LV8.Test.Service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/department")
@RequiredArgsConstructor
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    //get all departments
    @GetMapping
    public ApiResponse getAllDepartments(){
        try {
            return new ApiResponse<>(200,"Success","Departments Retrieved",departmentService.getAllDepartments());
        }catch (Exception e){
            return new ApiResponse<>(500,"Failed","Internal Error",e.getMessage());
        }
    }

    //get department by Id
    @GetMapping("/{id}")
    public ApiResponse getDepartmentById(@PathVariable Long id){
        try {
            return new ApiResponse<>(200,"Success","Department Retrieved By Id",departmentService.findDepartmentById(id));
        }catch (Exception e){
            return new ApiResponse<>(500,"Failed","Internal Error",e.getMessage());
        }
    }

    //create department
    @PostMapping
    public ApiResponse createDepartment(@RequestBody DepartmentDto departmentDto){
        try {
            return new ApiResponse<>(200,"Success","Department Created",departmentService.addDepartments(departmentDto));
        }catch (Exception e){
            return new ApiResponse<>(500,"Failed","Internal Error",e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ApiResponse updateDepartmentById (@RequestBody DepartmentDto departmentDto,@PathVariable long id){
        try {
            return new ApiResponse<>(200,"Success","Department Updated",departmentService.updateDepartment(departmentDto,id));
        }catch (Exception e){
            return new ApiResponse<>(500,"Failed","Internal Error",e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteDepartmentById (@PathVariable Long id){
        try {
            departmentService.deleteDepartment(id);
            return new ApiResponse<>(200,"Success","Department Deleted",null);
        }catch (Exception e){
            return new ApiResponse<>(500,"Failed","Internal Error",e.getMessage());
        }
    }
}

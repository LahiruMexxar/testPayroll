package com.LV8.Test.Service;

import com.LV8.Test.DTO.DepartmentDto;
import com.LV8.Test.Models.Department;
import com.LV8.Test.Repositories.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    public Optional<Department> findDepartmentById(Long id){
        return departmentRepository.findById(id);
    }

    public Department addDepartments(DepartmentDto departmentDto) {
        Department departments = new Department();
        if(departmentDto !=null){
            departments.setName(departmentDto.getName());
            departmentRepository.save(departments);
        }
        return departments;
    }

    public Department updateDepartment(DepartmentDto updatedDepartmentDto, Long id){
        Department departments = departmentRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No Department Found By Id"));
        if(updatedDepartmentDto !=null){
            departments.setName(updatedDepartmentDto.getName());
        }
        departmentRepository.save(departments);
        return departments;
    }

    public void deleteDepartment(Long id){
        if (id !=null){
            Department department = departmentRepository.findById(id)
                    .orElseThrow(()->new RuntimeException("No Department Found By Id"));
        }
        departmentRepository.deleteById(id);
    }

}

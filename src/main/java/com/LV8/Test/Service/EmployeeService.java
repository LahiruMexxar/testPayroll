package com.LV8.Test.Service;

import com.LV8.Test.DTO.DepartmentDto;
import com.LV8.Test.DTO.EmployeeDto;
import com.LV8.Test.Enums.Gender;
import com.LV8.Test.Models.Department;
import com.LV8.Test.Models.Employee;
import com.LV8.Test.Repositories.DepartmentRepository;
import com.LV8.Test.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> findEmployeesById(Long id){
        return employeeRepository.findById(id);
    }

    public List<Employee> getEmployeesByDepartmentId(Long departmentId){
        return employeeRepository.findAllEmployeesByDepartmentId(departmentId);
    }

    public Employee addEmployeesWithDepartment(EmployeeDto employeeDto) {
        Department departments = departmentRepository.findById(employeeDto.getDepartmentId())
                .orElseThrow(()->new RuntimeException("No Department Found By Id"));

        Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setContactNumber(employeeDto.getContactNumber());
        employee.setEmail(employeeDto.getEmail());
        employee.setGender(Gender.valueOf(employeeDto.getGender()));
        employee.setDepartment(departments);
        employeeRepository.save(employee);
        return employee;
    }

    public Employee updateEmployee(EmployeeDto updatedEmployeeDto, Long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No Employee Found By Id"));
        if(updatedEmployeeDto !=null){
            employee.setFirstName(updatedEmployeeDto.getFirstName());
            employee.setLastName(updatedEmployeeDto.getLastName());
            employee.setContactNumber(updatedEmployeeDto.getContactNumber());
            employee.setEmail(updatedEmployeeDto.getEmail());
            employee.setGender(Gender.valueOf(updatedEmployeeDto.getGender()));
        }
        employeeRepository.save(employee);
        return employee;
    }

    public void deleteEmployee(Long id){
        if (id !=null){
            Employee employee = employeeRepository.findById(id)
                    .orElseThrow(()->new RuntimeException("No Employee Found By Id"));
        }
        employeeRepository.deleteById(id);
    }

}

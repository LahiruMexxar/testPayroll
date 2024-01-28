package com.LV8.Test.Repositories;

import com.LV8.Test.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findAllEmployeesByDepartmentId(Long departmentId);
}

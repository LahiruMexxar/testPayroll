package com.LV8.Test.Service;

import com.LV8.Test.DTO.AllowanceDto;
import com.LV8.Test.Enums.Status;
import com.LV8.Test.Models.Allowance;
import com.LV8.Test.Models.Department;
import com.LV8.Test.Models.Employee;
import com.LV8.Test.Repositories.AllowanceRepository;
import com.LV8.Test.Repositories.DepartmentRepository;
import com.LV8.Test.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AllowanceService {
    @Autowired
    private AllowanceRepository allowanceRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public Allowance createAllowanceToEmployees(AllowanceDto allowanceDto){
        Employee employee = employeeRepository.findById(allowanceDto.getEmployeeId())
                .orElseThrow(()->new RuntimeException("No Employee Id Found"));
        Allowance allowance = new Allowance();
        if (employee !=null){
            Department department = departmentRepository.findById(allowanceDto.getDepartmentId())
                    .orElseThrow(()->new RuntimeException("No Department Found"));
            allowance.setEmployee(employee);
            allowance.setDepartment(department);
            allowance.setAllowance(allowanceDto.getAllowance());
            allowance.setMonth(allowanceDto.getMonth());
            allowance.setDate(allowanceDto.getDate());
            allowance.setStatus(Status.Pending);
            allowanceRepository.save(allowance);
        }
        return allowance;
    }

    public Allowance updateAllowance(AllowanceDto allowanceDto,Long id){
        Allowance allowance = allowanceRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No Allowance Id Found"));

        allowance.setAllowance(allowanceDto.getAllowance());
        allowanceRepository.save(allowance);
        return allowance;
    }

    public Allowance changeAllowanceStatus(AllowanceDto allowanceDto, Long id){
        Allowance allowance = allowanceRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No Allowance Id Found"));

        allowance.setStatus(Status.valueOf(allowanceDto.getStatus()));
        allowanceRepository.save(allowance);
        return allowance;
    }

    public List<Allowance> getAllowanceByMonth (String month){
        return allowanceRepository.getAllAllowancesByMonth(month);
    }

    public List<Allowance> getAllowanceByDateRange (Date startdate, Date endate){
        return allowanceRepository.getAllAllowancesByDateGreaterThanAndDateLessThan(startdate,endate);
    }
}

package com.ems.ems.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.ems.Entity.Employee;
import com.ems.ems.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    //This is a service layer, so we need to inject dependency of Repository Layer
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

}

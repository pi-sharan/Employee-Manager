package com.ems.ems.Service;

import java.util.List;

import com.ems.ems.Entity.Employee;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    
    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    void deleteEmployeeById(Long id);
}

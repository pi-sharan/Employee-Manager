package com.ems.ems.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ems.ems.Entity.Employee;
import com.ems.ems.Service.EmployeeService;

@Controller
public class EmployeeController {
    //This is controller layer, so we need to inject dependency of Service Layer
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //Handler method which returns model and view to list all students
    //returns the view name as String

    @GetMapping("/api/employees")
    public String listEmployees(Model model) {
        model.addAttribute("employeeList", employeeService.getAllEmployees());
        return "employees";
    }

    @GetMapping("/api/employees/new")
    public String addEmployeeForm(Model model) {

        //Temp Employee object which will get data from the Form
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "create_employee";
    }

    @PostMapping("/api/employees")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/api/employees";
    }
    
}

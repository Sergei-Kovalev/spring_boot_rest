package ru.ngs.summerjob.springboot.spring_boot_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ngs.summerjob.springboot.spring_boot_rest.entity.Employee;
import ru.ngs.summerjob.springboot.spring_boot_rest.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/1")
    public String show1() {
        return "1";
    }

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {

        List<Employee> allEmployees = employeeService.getAllEmployees();

        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String  deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "Employee with id = " + id + " was deleted!!!";
    }
}

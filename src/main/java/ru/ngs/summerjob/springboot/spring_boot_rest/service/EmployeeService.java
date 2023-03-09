package ru.ngs.summerjob.springboot.spring_boot_rest.service;


import ru.ngs.summerjob.springboot.spring_boot_rest.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployeeById(int id);

    void deleteEmployee(int id);
}

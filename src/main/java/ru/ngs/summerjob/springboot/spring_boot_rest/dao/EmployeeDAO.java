package ru.ngs.summerjob.springboot.spring_boot_rest.dao;


import ru.ngs.summerjob.springboot.spring_boot_rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployeeById(int id);

    void deleteEmployee(int id);
}

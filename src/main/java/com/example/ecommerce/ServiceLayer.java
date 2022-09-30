package com.example.ecommerce;


import java.util.List;

public interface ServiceLayer {

    Employee addEmployees(Employee employee);

    List<Employee> getAllEmployees();

    Employee findEmployeeById(Integer id);

    Employee updateEmployee(Employee employee, Integer id);

    void deleteEmployeeById(Integer id);
}

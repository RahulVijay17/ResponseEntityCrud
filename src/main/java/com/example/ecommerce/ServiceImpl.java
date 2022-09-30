package com.example.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements ServiceLayer {

    @Autowired
    private  RepositoryLayer repositoryLayer;

   /* public ServiceImpl(RepositoryLayer repositoryLayer){
        super();
        this.repositoryLayer=repositoryLayer;
    }*/

    @Override
    public Employee addEmployees(Employee employee) {
        return repositoryLayer.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repositoryLayer.findAll();
    }

    @Override
    public Employee findEmployeeById(Integer id) {
      return repositoryLayer.findById(id).orElseThrow(()->new RuntimeException(String.valueOf(id)));
    }

    @Override
    public Employee updateEmployee(Employee employee, Integer id) {

        // we need to check whether employee with given id is exist in DB or not
        Employee existingEmployee = repositoryLayer.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Id", id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        // save existing employee to DB
        repositoryLayer.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        repositoryLayer.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Employee","Id",id));
        repositoryLayer.deleteById(id);
    }

}

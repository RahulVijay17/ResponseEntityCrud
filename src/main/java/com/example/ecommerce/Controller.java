package com.example.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employee")
public class Controller {

    @Autowired
    private ServiceLayer serviceLayer;
/*   *//* public Controller(ServiceLayer serviceLayer){
        super();
        this.serviceLayer=serviceLayer;
    }
*/
    @PostMapping()
    public ResponseEntity<Employee> addEmployees(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(serviceLayer.addEmployees(employee), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<Employee> getAllEmployees(){
        return serviceLayer.getAllEmployees();
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable("id")Integer id){
            return new ResponseEntity<Employee>(serviceLayer.findEmployeeById(id),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Integer id
            ,@RequestBody Employee employee){
        return new ResponseEntity<Employee>(serviceLayer.updateEmployee(employee, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id")Integer id){
        serviceLayer.deleteEmployeeById(id);
        return new ResponseEntity<String>("Deleted",HttpStatus.OK);
    }

}

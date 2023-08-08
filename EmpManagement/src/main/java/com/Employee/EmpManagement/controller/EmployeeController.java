package com.Employee.EmpManagement.controller;

import com.Employee.EmpManagement.model.Employee;
import com.Employee.EmpManagement.service.impl.EmployeeSrevice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeSrevice employeeSrevice;
    public EmployeeController(EmployeeSrevice employeeSrevice) {
        super();
        this.employeeSrevice=employeeSrevice;
    }
    //build create employee RESTAPI;
    @PostMapping
    public ResponseEntity<Employee>saveEmployee(@RequestBody Employee employee){
      return new ResponseEntity<Employee>(employeeSrevice.saveEmployee(employee), HttpStatus.CREATED);
    }

    //build get all employees RESTApi
    @GetMapping
  public List<Employee> getAllEmployees(){
    return employeeSrevice.getAllEmployees();
  }

  //build get employeeid restAPI
    //path :http://localhost:8081/api/employee/1(1 is dynamic id of employee)
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeId(@PathVariable("id") long employeeid){
    return  new ResponseEntity<Employee>(employeeSrevice.getEmployeeByID(employeeid),HttpStatus.OK);
    }



    //build employe update restApi
    //path :http://localhost:8081/api/employee/1

    @PutMapping("{id}")
  public ResponseEntity<Employee>updateEmployeeResponseEntity(@PathVariable("id") long id
                   ,@RequestBody Employee employee){
     return  new ResponseEntity<Employee>(employeeSrevice.updateEmployee(employee,id),HttpStatus.OK);
  }
//build delete employee rrestApi
    @DeleteMapping("{id}")
   public ResponseEntity<String>deleteEmployee(@PathVariable("id")long id){
              employeeSrevice.deleteEmployee(id);
        return new  ResponseEntity<String>("Employee deleted sucessfully",HttpStatus.OK);
   }

}

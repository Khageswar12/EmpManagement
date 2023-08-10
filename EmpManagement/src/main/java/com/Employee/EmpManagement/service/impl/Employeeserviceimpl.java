package com.Employee.EmpManagement.service.impl;

import com.Employee.EmpManagement.exception.ResourceNotFoundException;
import com.Employee.EmpManagement.model.Employee;
import com.Employee.EmpManagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Employeeserviceimpl implements EmployeeSrevice {

    private EmployeeRepository
            employeeRepository;
    public Employeeserviceimpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee );
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll() ;
    }

    @Override
    public Employee getEmployeeByID(long id) {
//        Optional<Employee>  employee=employeeRepository.findById(id);
//        if (employee.isPresent()){
//            return employee.get();
//        }else {
//            throw new ResourceNotFoundException("Employee","id",id);

        return employeeRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Employee","Id",id));
        }

    @Override
    public Employee updateEmployee(Employee employee, long id)
    {
        //we need to check whethe the employe with given id is exit or not
        Employee exitingEmployee=employeeRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Employee","Id",id)
        );
        exitingEmployee.setFirstName(employee.getFirstName());
        exitingEmployee.setLastName(employee.getLastName());
        exitingEmployee.setEmail(employee.getEmail());
        //save exiting employ to data base
        employeeRepository.save(exitingEmployee);

        return exitingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        //check whether employee exit in database or not
        employeeRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Employee","Id",id));
        employeeRepository.deleteById(id);
    }


}


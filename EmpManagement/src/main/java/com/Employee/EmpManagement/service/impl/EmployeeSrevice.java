package com.Employee.EmpManagement.service.impl;

import com.Employee.EmpManagement.model.Employee;

import java.util.List;

public interface EmployeeSrevice {
    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeByID(long id);

    Employee updateEmployee(Employee employee,long id);
    void  deleteEmployee(long id);
}


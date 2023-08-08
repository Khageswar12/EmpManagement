package com.Employee.EmpManagement.repository;

import com.Employee.EmpManagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}

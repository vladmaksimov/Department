package com.department.service;

import com.department.exeption.ErrorException;
import com.department.exeption.ValidateException;
import com.department.model.Department;
import com.department.model.Employee;

import java.util.List;

public interface EmployeeService {

    void addOrUpdateEmployee(Employee employee) throws ValidateException, ErrorException;
    void deleteEmployee(Employee employee) throws ErrorException;
    List<Employee> getAllEmployees(Department department) throws ErrorException;
    Employee getOneEmployee(Integer id) throws ErrorException;

}

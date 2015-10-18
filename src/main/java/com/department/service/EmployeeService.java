package com.department.service;

import com.department.exeption.ErrorException;
import com.department.exeption.ValidateException;
import com.department.model.Employee;

import java.util.List;

public interface EmployeeService {

    void addOrUpdateEmployee(Employee employee) throws ValidateException, ErrorException;

    void deleteEmployee(Integer id) throws ErrorException;

    List<Employee> getAllEmployees(Integer id) throws ErrorException;

    Employee getOneEmployee(Integer id) throws ErrorException;

}

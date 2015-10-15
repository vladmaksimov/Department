package com.department.service.employee;

import com.department.exeption.ValidateException;
import com.department.model.Department;
import com.department.model.Employee;

import java.util.List;

public interface EmployeeService {

    void addOrUpdateEmployee(Employee employee) throws ValidateException;

    void deleteEmployee(Employee employee);

    List<Employee> getAllEmployees(Department department);

    Employee getOneEmployee(Integer id);

}

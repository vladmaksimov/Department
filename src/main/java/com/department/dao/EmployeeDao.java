package com.department.dao;

import com.department.model.Employee;

import java.util.List;
import java.util.Set;

public interface EmployeeDao {

    String ADD = "INSERT INTO employees(name, email, date, departmentId, salary) VALUES (?, ?, ?, ?, ?)";
    String DELETE = "DELETE FROM employees WHERE id=?";
    String GET_ONE = "SELECT * FROM employees WHERE id=?";
    String GET_ALL = "SELECT * FROM employees WHERE departmentId=?";
    String UPDATE = "UPDATE employees SET name = ?, email = ?, date = ?, departmentId = ?, salary = ? WHERE id=?";
    String GET_EMAILS = "SELECT email FROM employees";
    String GET_BY_NAME = "SELECT * FROM employees WHERE email = ?";

    void addOrEditEmployee(Employee employee);

    void delete(Integer id);

    Employee getOneEmployee(Integer id);

    List<Employee> getAllEmployees(Integer id);

    Set<String> getEmails();

    Employee getByEmail(String email);
}

package com.department.dao;

import com.department.exeption.ErrorException;
import com.department.model.Department;
import com.department.model.Employee;

import java.util.List;

public interface EmployeeDao extends GenericDao<Employee> {

    String GET_ALL = "from Employee a where a.department = :department";
    String GET_BY_NAME = "from Employee a where a.email = :email";

    List<Employee> getAllEmployees(Department department) throws ErrorException;
    Employee getByEmail(String email) throws ErrorException;
}

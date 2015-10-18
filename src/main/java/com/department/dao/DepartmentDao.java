package com.department.dao;

import com.department.exeption.ErrorException;
import com.department.model.Department;

import java.util.List;

public interface DepartmentDao {
    String ADD = "INSERT INTO departments(name) VALUES(?)";
    String GET_ALL = "SELECT * FROM departments";
    String GET_ONE = "SELECT * FROM departments WHERE id=?";
    String DELETE = "DELETE FROM departments WHERE id=?";
    String UPDATE = "UPDATE departments SET name=? WHERE id=?";
    String GET_BY_NAME = "SELECT * FROM departments WHERE name = ?";

    void add(Department department) throws ErrorException;
    void delete(Integer id) throws ErrorException;
    Department getOne(Integer id) throws ErrorException;
    List<Department> getAll() throws ErrorException;
    Department getByName(String name) throws ErrorException;
}

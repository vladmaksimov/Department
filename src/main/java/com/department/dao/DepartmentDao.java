package com.department.dao;

import com.department.model.Department;

import java.util.List;

public interface DepartmentDao {
    String ADD = "INSERT INTO departments(name) VALUES(?)";
    String GET_ALL = "SELECT * FROM departments";
    String GET_ONE = "SELECT * FROM departments WHERE id=?";
    String DELETE = "DELETE FROM departments WHERE id=?";
    String UPDATE = "UPDATE departments SET name=? WHERE id=?";
    String GET_BY_NAME = "SELECT * FROM departments WHERE name = ?";

    void add(Department department);
    void delete(Integer id);
    Department getOne(Integer id);
    List<Department> getAll();
    Department getByName(String name);
}

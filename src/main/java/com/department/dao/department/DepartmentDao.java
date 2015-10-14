package com.department.dao.department;

import com.department.model.Department;

import java.util.List;
import java.util.Set;

public interface DepartmentDao {
//    String ADD = "INSERT INTO departments(name) VALUES(?)";
//    String GET_ALL = "SELECT * FROM departments";
//    String GET_ONE = "SELECT * FROM departments WHERE id=?";
//    String DELETE = "DELETE FROM departments WHERE id=?";
//    String UPDATE = "UPDATE departments SET name=? WHERE id=?";
//    String GET_NAMES = "SELECT name FROM departments";

    void add(Department department);

    void delete(Integer id);

    Department getOne(Integer id);

    List<Department> getAll();

    Set<String> getNames();
}

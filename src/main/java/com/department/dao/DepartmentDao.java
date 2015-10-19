package com.department.dao;

import com.department.exeption.ErrorException;
import com.department.model.Department;
import com.department.model.Employee;

import java.util.List;

public interface DepartmentDao extends GenericDao<Department> {

    String GET_BY_NAME = "from Department a where a.name = :name";

    Department getByName(String name) throws ErrorException;
}

package com.department.dao.department.impl;

import com.department.dao.department.DepartmentDao;
import com.department.model.Department;
import com.department.utils.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DepartmentDaoImpl implements DepartmentDao {



    public void add(Department department) {
        String request;
        if (department.getId() != null) {
            request = UPDATE;
        } else {
            request = ADD;
        }
        Connection connection = DBConnector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setString(1, department.getName());
            if (request.equals(UPDATE)){
                preparedStatement.setInt(2,department.getId());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnector.closeConnection(connection);
        }
    }

    public void delete(Integer id) {
        Connection connection = DBConnector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnector.closeConnection(connection);
        }
    }

    public Department getOne(Integer id) {
        Department department = new Department();
        Connection connection = DBConnector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ONE);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                department.setId(resultSet.getInt("id"));
                department.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnector.closeConnection(connection);
        }
        return department;
    }

    public List<Department> getAll() {
        List<Department> list = new ArrayList<Department>();
        Connection connection = DBConnector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Department department = new Department();
                department.setId(resultSet.getInt("id"));
                department.setName(resultSet.getString("name"));
                list.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnector.closeConnection(connection);
        }
        return list;
    }

    public Set<String> getNames() {
        Connection connection = DBConnector.getConnection();
        Set<String> names = new HashSet<String>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_NAMES);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                names.add(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return names;
    }
}

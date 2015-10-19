package com.department.dao.impl;

import com.department.dao.DepartmentDao;
import com.department.exeption.ErrorException;
import com.department.model.Department;
import com.department.utils.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {


    public void add(Department department) throws ErrorException {
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
            if (request.equals(UPDATE)) {
                preparedStatement.setInt(2, department.getId());
            }
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
//            e.printStackTrace();
            throw new ErrorException("Failed to add department");
        } finally {
            DBConnector.closeConnection(connection);
        }
    }

    public void delete(Integer id) throws ErrorException{
        Connection connection = DBConnector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
//            e.printStackTrace();
            System.err.println(e);
            throw new ErrorException("Failed to remove the department");
        } finally {
            DBConnector.closeConnection(connection);
        }
    }

    public Department getOne(Integer id) throws ErrorException {
        Department department = new Department();
        Connection connection = DBConnector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ONE);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                department.setId(resultSet.getInt("id"));
                department.setName(resultSet.getString("name"));
            }
        } catch (Exception e) {
            System.err.println(e);
//            e.printStackTrace();
            throw new ErrorException("Error getting data from the database");
        } finally {
            DBConnector.closeConnection(connection);
        }
        return department;
    }

    public List<Department> getAll() throws ErrorException {
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
        } catch (Exception e) {
//            e.printStackTrace();
            System.err.println(e);
            throw new ErrorException("Error getting data from the database");
        } finally {
            DBConnector.closeConnection(connection);
        }
        return list;
    }


    public Department getByName(String name) throws ErrorException {
        Department department = null;
        Connection connection = DBConnector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                department = new Department();
                department.setId(resultSet.getInt("id"));
                department.setName(resultSet.getString("name"));
            }
        } catch (Exception e) {
            System.err.println(e);
//            e.printStackTrace();
            throw new ErrorException("Error getting data from the database");
        } finally {
            DBConnector.closeConnection(connection);
        }
        return department;
    }
}

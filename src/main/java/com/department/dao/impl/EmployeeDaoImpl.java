package com.department.dao.impl;

import com.department.dao.EmployeeDao;
import com.department.model.Employee;
import com.department.utils.DBConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao  {
    public void addOrEditEmployee(Employee employee) {
        String request;
        if (employee.getId()!=null) {
            request = UPDATE;
        } else {
            request = ADD;
        }
        Connection connection = DBConnector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setDate(3, (Date) employee.getDate());
            preparedStatement.setInt(4, employee.getDepartmentId());
            preparedStatement.setFloat(5, employee.getSalary());
            if (request.equals(UPDATE)) {
                preparedStatement.setInt(6, employee.getId());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
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
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DBConnector.closeConnection(connection);
        }
    }

    public Employee getOneEmployee(Integer id) {
        Connection connection = DBConnector.getConnection();
        Employee employee = new Employee();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ONE);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setDate(resultSet.getDate("date"));
                employee.setDepartmentId(resultSet.getInt("departmentId"));
                employee.setSalary(resultSet.getFloat("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DBConnector.closeConnection(connection);
        }
        return employee;
    }

    public List<Employee> getAllEmployees(Integer id) {
        Connection connection = DBConnector.getConnection();
        List<Employee> list = new ArrayList<Employee>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setDate(resultSet.getDate("date"));
                employee.setDepartmentId(resultSet.getInt("departmentId"));
                employee.setSalary(resultSet.getFloat("salary"));
                list.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DBConnector.closeConnection(connection);
        }
        return list;
    }

    public Employee getByEmail(String email) {
        Connection connection = null;
        Employee employee = null;
        try {
            connection = DBConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_NAME);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setDate(resultSet.getDate("date"));
                employee.setDepartmentId(resultSet.getInt("departmentId"));
                employee.setSalary(resultSet.getFloat("salary"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnector.closeConnection(connection);
        }
        return employee;
    }
}

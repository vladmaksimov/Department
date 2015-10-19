package com.department.controller.processor.impl.employees;

import com.department.controller.processor.Processor;
import com.department.exeption.ErrorException;
import com.department.model.Department;
import com.department.model.Employee;
import com.department.service.DepartmentService;
import com.department.service.impl.DepartmentServiceImpl;
import com.department.service.EmployeeService;
import com.department.service.impl.EmployeeServiceImpl;
import com.department.utils.GetDataUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 16.09.2015.
 */
public class DeleteEmployees implements Processor {
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ErrorException {
        DepartmentService departmentService = new DepartmentServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl();
        Department department = departmentService.getOneDepartment(GetDataUtil.getInteger(req, "departmentId"));
        Employee employee = employeeService.getOneEmployee(GetDataUtil.getInteger(req, "id"));
        employeeService.deleteEmployee(employee);
        req.setAttribute("department", department);
        req.setAttribute("employeeList", employeeService.getAllEmployees(department));
        req.getRequestDispatcher("jsp/employees/showEmployees.jsp").forward(req, resp);
    }
}

package com.department.controller.processor.impl.employees;

import com.department.controller.processor.Processor;
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

public class ShowEditEmployeeForm implements Processor {
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee;
        EmployeeService employeeService = new EmployeeServiceImpl();
        DepartmentService departmentService = new DepartmentServiceImpl();
        employee = employeeService.getOneEmployee(GetDataUtil.getInteger(req, "id"));
        req.setAttribute("department", departmentService.getOneDepartment(employee.getDepartmentId()));
        req.setAttribute("employee", employee);
        req.getRequestDispatcher("jsp/employees/addEmployees.jsp").forward(req, resp);
    }
}

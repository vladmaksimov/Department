package com.department.controller.processor.impl.employees;

import com.department.controller.processor.Processor;
import com.department.exeption.ErrorException;
import com.department.service.DepartmentService;
import com.department.service.impl.DepartmentServiceImpl;
import com.department.service.EmployeeService;
import com.department.service.impl.EmployeeServiceImpl;
import com.department.utils.GetDataUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowEmployee implements Processor {

    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ErrorException {
        EmployeeService employeeService = new EmployeeServiceImpl();
        DepartmentService departmentService = new DepartmentServiceImpl();
        req.setAttribute("department", departmentService.getOneDepartment(GetDataUtil.getInteger(req, "id")));
        req.setAttribute("employeeList", employeeService.getAllEmployees(GetDataUtil.getInteger(req, "id")));
        req.getRequestDispatcher("jsp/employees/showEmployees.jsp").forward(req, resp);
    }
}

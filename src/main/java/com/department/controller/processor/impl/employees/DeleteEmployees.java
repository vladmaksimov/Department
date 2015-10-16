package com.department.controller.processor.impl.employees;

import com.department.controller.processor.Processor;
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
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeService service = new EmployeeServiceImpl();
        DepartmentService departmentService = new DepartmentServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl();
        service.deleteEmployee(GetDataUtil.getInteger(req, "id"));
        req.setAttribute("department", departmentService.getOneDepartment(GetDataUtil.getInteger(req, "departmentId")));
        req.setAttribute("employeeList", employeeService.getAllEmployees(GetDataUtil.getInteger(req, "departmentId")));
        req.getRequestDispatcher("jsp/employees/showEmployees.jsp").forward(req, resp);
    }
}

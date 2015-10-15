package com.department.controller.processor.impl.employees;

import com.department.controller.processor.Processor;
import com.department.model.Department;
import com.department.service.department.DepartmentService;
import com.department.service.department.impl.DepartmentServiceImpl;
import com.department.service.employee.EmployeeService;
import com.department.service.employee.impl.EmployeeServiceImpl;
import com.department.utils.GetDataUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowEditEmployeeForm implements Processor {
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeService employeeService = new EmployeeServiceImpl();
        DepartmentService departmentService = new DepartmentServiceImpl();
        Department department = departmentService.getOneDepartment(GetDataUtil.getInteger(req, "departmentId"));
        req.setAttribute("department", department);
        req.setAttribute("employee", employeeService.getOneEmployee(GetDataUtil.getInteger(req, "id")));
        req.getRequestDispatcher("jsp/employees/addEmployees.jsp").forward(req, resp);
    }
}

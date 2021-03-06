package com.department.controller.processor.impl.employees;

import com.department.controller.processor.Processor;
import com.department.exeption.ErrorException;
import com.department.service.DepartmentService;
import com.department.service.impl.DepartmentServiceImpl;
import com.department.utils.GetDataUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowAddEmployeeForm implements Processor {
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ErrorException {
        DepartmentService departmentService = new DepartmentServiceImpl();
        req.setAttribute("department", departmentService.getOneDepartment(GetDataUtil.getInteger(req, "id")));
        req.getRequestDispatcher("jsp/employees/addEmployees.jsp").forward(req, resp);
    }
}

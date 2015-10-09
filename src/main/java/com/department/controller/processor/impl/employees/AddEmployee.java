package com.department.controller.processor.impl.employees;

import com.department.controller.processor.Processor;
import com.department.exeption.ValidateException;
import com.department.model.Employee;
import com.department.service.department.DepartmentService;
import com.department.service.department.impl.DepartmentServiceImpl;
import com.department.service.employee.EmployeeService;
import com.department.service.employee.impl.EmployeeServiceImpl;
import com.department.utils.GetDataUtil;
import net.sf.oval.guard.Guarded;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Guarded
public class AddEmployee implements Processor {

    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ValidateException {
        Employee employee = new Employee();
        EmployeeService employeeService = new EmployeeServiceImpl();
        DepartmentService departmentService = new DepartmentServiceImpl();
        employee.setId(GetDataUtil.getInteger(req, "id"));
        employee.setName(req.getParameter("name"));
        employee.setEmail(req.getParameter("email"));
        employee.setDate(GetDataUtil.getSqlDate(req, "date"));
        employee.setDepartmentId(GetDataUtil.getInteger(req, "departmentId"));
        employee.setSalary(GetDataUtil.getFloat(req, "salary"));
        try {
            employeeService.addOrUpdateEmployee(employee);
            req.setAttribute("department", departmentService.getOneDepartment(GetDataUtil.getInteger(req, "departmentId")));
            req.setAttribute("employeeList", employeeService.getAllEmployees(GetDataUtil.getInteger(req, "departmentId")));
            req.getRequestDispatcher("jsp/employees/showEmployees.jsp").forward(req, resp);
        } catch (ValidateException e) {
            req.setAttribute("department", departmentService.getOneDepartment(GetDataUtil.getInteger(req, "departmentId")));
            req.setAttribute("employee", employee);
            req.setAttribute("errors", e.getErrors());
            req.getRequestDispatcher("jsp/employees/addEmployees.jsp").forward(req, resp);
        }
    }
}

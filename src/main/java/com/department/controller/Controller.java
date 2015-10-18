package com.department.controller;

import com.department.controller.processor.Processor;
import com.department.controller.processor.impl.departments.*;
import com.department.controller.processor.impl.employees.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 16.09.2015.
 */
public class Controller extends HttpServlet {
    private static final Map<String, Processor> ACTION_MAP = new HashMap<String, Processor>() {{
        put("editEmployee", new ShowEditEmployeeForm());
        put("showEmployeeForm", new ShowAddEmployeeForm());
        put("addOrEditEmployee", new AddEmployee());
        put("deleteEmployee", new DeleteEmployees());
        put("showEmployees", new ShowEmployee());
        put("addDepartment", new AddOrEditDepartment());
        put("deleteDepartment", new DeleteDepartment());
        put("showDepartments", new ShowDepartments());
        put("showDepartmentsForm", new ShowAddDepartmentForm());
        put("editDepartment", new ShowEditDepartmentForm());
        put("backButton", new BackButton());
    }};

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (!ACTION_MAP.containsKey(action)) {
            action = "showDepartments";
        }
        Processor processor = ACTION_MAP.get(action);
        try {
            processor.service(req, resp);
        } catch (Exception e) {
            req.getRequestDispatcher("jsp/error.jsp");
        }
    }

}

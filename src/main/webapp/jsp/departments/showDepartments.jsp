<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 16.09.2015
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Departments</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/css/bootstrap.css">
</head>
<body>
<div class="container">
    <table class="table table-striped" style="width: 800px">
        <thead>
        <tr>
            <th style="width: 550px">Department name</th>
            <th colspan="3" style="text-align: center; width: 250px">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${departmentsList}" var="department">
            <tr>
                <td><c:out value="${department.name}"/></td>
                <td>
                    <form name="edit" method="post" style="margin-bottom: 0px">
                        <button class="btn btn-default btn-sm" type="submit" name="action" value="editDepartment" >Edit</button>
                        <input type="hidden" name="id" value="<c:out value="${department.id}"/>" >
                    </form>
                </td>
                <td>
                    <form name="delete" method="post" style="margin-bottom: 0px">
                        <button class="btn btn-default btn-sm" type="submit" name="action" value="deleteDepartment" >Delete</button>
                        <input type="hidden" name="id" value="<c:out value="${department.id}"/>" >
                    </form>
                </td>
                <td>
                    <form name="show employees" action="employee" method="post" style="margin-bottom: 0px">
                        <button class="btn btn-default btn-sm" type="submit" name="action" value="showEmployees" >Show employees</button>
                        <input type="hidden" name="id" value="<c:out value="${department.id}"/>" >
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <form name="Add new Department" method="post">
        <button class="btn btn-default" type="submit" name="action" value="showDepartmentsForm">Add new Department
        </button>
    </form>
</div>
</body>
</html>
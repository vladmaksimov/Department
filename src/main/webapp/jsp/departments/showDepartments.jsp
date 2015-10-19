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
                    <a class="btn btn-default btn-sm" href="?action=editDepartment&id=${department.id}" role="button">Edit</a>
                </td>
                <td>
                    <a class="btn btn-default btn-sm" href="?action=deleteDepartment&id=${department.id}">Delete</a>
                </td>
                <td>
                    <a class="btn btn-default btn-sm" href="?action=showEmployees&id=<c:out value="${department.id}"/>" role="button">Show employees</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a class="btn btn-default" href="?action=showDepartmentsForm">Add new Department</a>
    <%--<form name="Add new Department" method="post">--%>
        <%--<button class="btn btn-default" type="submit" name="action" value="showDepartmentsForm">Add new Department--%>
        <%--</button>--%>
    <%--</form>--%>
</div>
</body>
</html>
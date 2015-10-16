<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 16.09.2015
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    <%@include file='/css/bootstrap.css' %>
</style>
<html>
<head>
    <link type="text/css" href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet" media="screen"/>
    <title></title>
    <style>
        body {
            margin: auto;
        }

        .parent {
            margin: 20px;
            padding-right: 60%;
        }

        body {
            margin: auto;
        }

        .text {
            padding-left: 20px;
        }
    </style>
</head>
<body>
<form name="Department Form" method="get">
    <div class="parent">
        <table class="parent table-bordered">
            <col width="600" valign="top">
            <col width="150" valign="top">
            <col width="150" valign="top">
            <col width="150" valign="top">
            <tr>
                <td>Department name</td>
                <td colspan="3">Action</td>
            </tr>
            <c:forEach items="${departmentsList}" var="department">
                <tr>
                    <td><c:out value="${department.name}"/></td>
                    <td>
                        <button class="btn btn-default btn-md" type="submit" name="action" value="editDepartment">Edit
                            <input type="hidden" name="id" value="<c:out value="${department.id}"/>">
                        </button>
                    </td>
                    <td>
                        <button class="btn btn-default btn-md" type="submit" name="action" value="deleteDepartment">Delete
                            <input type="hidden" name="id" value="<c:out value="${department.id}"/>">
                        </button>
                    </td>
                    <td>
                        <button class="btn btn-default btn-md" type="submit" name="action" value="showEmployees">Show employees
                            <input type="hidden" name="id" value="<c:out value="${department.id}"/>">
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <br>
</form>

<form name="Add new Department" method="post">
    <button class="btn btn-default" type="submit" name="action" value="showDepartmentsForm">Add new Department</button>
</form>

</body>
</html>
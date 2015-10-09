<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<form name="controller" method="post">
    <input hidden value="${department.id}">

    <h2>Department: ${department.name}</h2>
    <table border="1">
        <tr>
            <td>User name</td>
            <td>User email</td>
            <td>Birthday</td>
            <td>Salary</td>
            <td colspan="2" align="center">Actions</td>
        </tr>

        <c:forEach items="${employeeList}" var="employee">
            <tr>
                <td><c:out value="${employee.name}"/></td>
                <td><c:out value="${employee.email}"/></td>
                <td><c:out value="${employee.date}"/></td>
                <td><c:out value="${employee.salary}"/></td>
                <td><a href="?action=editEmployee&id=${employee.id}"><input type="button" value="Edit"></a></td>
                <td><a href="?action=deleteEmployee&id=${employee.id}&departmentId=${employee.departmentId}"><input
                        type="button" value="Delete"></a></td>
            </tr>
        </c:forEach>
    </table>
    <br> <br>
</form>
<form action="?action=showEmployeeForm&id=${department.id}" method="post">
    <input type="submit" value="Add new employee">
</form>
<form action="showDepartments" method="post">
    <input type="submit" value="Back to Department list">
</form>
</body>
</html>

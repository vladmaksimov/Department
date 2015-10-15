<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add or edit employee</title>
</head>
<body>
<form name="Controller" method="post" action="?action=addOrEditEmployee">
    <input type="hidden" name="id" value="${employee.id}">
    <input type="hidden" name="departmentId" value="${department.id}">
    <input type="hidden" name="departmentId" value="${employee.department.id}">


    <h2>Add new employee to <c:out value="${department.name}"/> department</h2> <br>

    <strong>Enter your name:</strong> <br>
    <font color="red" size="2"><c:out value="${errors.name}"/></font><br>
    <input type="text" name="name" value="<c:out value="${employee.name}"/>"> <br><br>

    <strong>Enter your email:</strong> <br>
    <font color="red" size="2"><c:out value="${errors.email}"/></font><br>
    <input type="email" name="email" value="<c:out value="${employee.email}"/>"> <br><br>

    <strong>Enter your salary:</strong> <color red>*</color><br>
    <font color="red" size="2"><c:out value="${errors.salary}"/></font><br>
    <input type="text" name="salary" value="<c:out value="${employee.salary}"/>"> <br><br>

    <strong>Enter your birthday:</strong> <color red>*</color><br>
    <font color="red" size="2"><c:out value="${errors.date}"/></font><br>
    <input type="date" name="date" value="<c:out value="${employee.date}"/>"> <br><br>

    <input type="submit" name="action" value="addEmployee"><div></div>
</form>
<form action="?action=showEmployees&id=<c:out value="${department.id}"/>" method="post">
    <input type="submit" value="back">
</form>
</body>
</html>
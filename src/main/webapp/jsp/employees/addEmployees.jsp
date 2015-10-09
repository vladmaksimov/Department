<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add or edit employee</title>
</head>
<body>
<form name="Controller" method="post" action="?action=addOrEditEmployee">
    <input type="hidden" name="id" value="${employee.id}">
    <input type="hidden" name="departmentId" value="${department.id}">
    <input type="hidden" name="departmentId" value="${employee.departmentId}">


    <h2>Add new employee to ${department.name} department</h2> <br>

    <strong>Enter your name:</strong> <br>
    <font color="red" size="2">${errors.name}</font><br>
    <input type="text" name="name" value="${employee.name}" > <br><br>

    <strong>Enter your email:</strong> <br>
    <font color="red" size="2">${errors.email}</font><br>
    <input type="email" name="email" value="${employee.email}"> <br><br>

    <strong>Enter your salary:</strong> <color red>*</color><br>
    <font color="red" size="2">${errors.salary}</font><br>
    <input type="text" name="salary" value="${employee.salary}"> <br><br>

    <strong>Enter your birthday:</strong> <color red>*</color><br>
    <font color="red" size="2">${errors.date}</font><br>
    <input type="date" name="date" value="${employee.date}"> <br><br>

    <%--<font color="red">${error}</font><br><br>--%>
    <input type="submit" name="action" value="addEmployee"><div></div>
</form>
<form action="?action=showEmployees&id=${department.id}" method="post">
    <input type="submit" value="back">
</form>
</body>
</html>

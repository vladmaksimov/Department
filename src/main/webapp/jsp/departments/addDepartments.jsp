<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form name="controller" method="get">
    <strong>Enter department name:</strong> <br>
    <input type="hidden" name="id" value="<c:out value="${department.id}"/>">
    <input type="text" name="name" value="<c:out value="${department.name}"/>"><br>
    <font color="red" size="2"><c:out value="${errors.name}"/></font><br>
    <input type="submit" name="action" value="addDepartment">

    <div/>
</form>
<br>

<form action="?action=showDepartments" method="get">
    <input type="submit" value="Back to department list">
</form>
</body>
</html>

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
    <title></title>
</head>
<body>
<form name="Department Form" method="post">
  <table border="2">
    <tr>
      <td>Department name</td>
      <td colspan="3">Action</td>
    </tr>
    <c:forEach items="${departmentsList}" var="department">
    <tr>
      <td><c:out value="${department.name}" /></td>
      <td><a href="?action=editDepartment&id=${department.id}"><input type="button" value="Edit"></a></td>
      <td><a href="?action=deleteDepartment&id=${department.id}"><input type="button" value="Delete"></a></td>
      <td><a href="?action=showEmployees&id=${department.id}"><input type="button" value="Show employees"></a></td>
    </tr>
  </c:forEach>
  </table>
  <br>
</form>
<form action="?action=showDepartmentsForm" method="post">
  <input type="submit" name="action" value="add new department">
</form>
</body>
</html>

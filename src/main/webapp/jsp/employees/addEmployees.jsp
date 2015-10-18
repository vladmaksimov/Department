<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Add or edit employee</title>
    <link type="text/css" href= "<c:url value="/css/bootstrap.css"/>" rel="stylesheet"/>
</head>
<body>
<div class="container">

    <form name="Ann or edit employee" method="post">

        <input type="hidden" name="id" value="${employee.id}">
        <input type="hidden" name="departmentId" value="${department.id}">
        <input type="hidden" name="departmentId" value="${employee.departmentId}">

        <div class="text"><h2><c:out value="${department.name}"/> department</h2></div>
        <br>

            <div style="width: 400px">
                <div class="form-group">
                    <label>Enter employee name:</label>
                    <font color="red" size="2"><c:out value="${error.name}"/></font> <br>
                    <input type="text" class="form-control" name="name" placeholder="Input employee name"
                           value="${employee.name}">
                </div>



                <div class="form-group">
                    <label>Enter employee email:</label>
                    <font color="red" size="2"><c:out value="${error.email}"/></font>
                    <input type="text" class="form-control" name="email" placeholder="Input employee email"
                           value="${employee.email}">
                </div>


                <div class="form-group">
                    <label>Enter employee salary: *</label>
                    <font color="red" size="2"><c:out value="${error.salary}"/></font>
                    <input type="text" class="form-control" name="salary" placeholder="Input employee salary"
                           value="${employee.salary}">
                </div>

                <div class="form-group">
                    <label>Enter employee birthday</label>
                    <font color="red" size="2"><c:out value="${error.date}"/></font>
                    <input type="text" class="form-control" name="date" placeholder="1990-01-01"
                           value="${employee.date}">
                </div>
            </div>
        <button type="submit" class="btn btn-default" name="action" value="addOrEditEmployee">Submit</button>
    </form>
    <form name="Back to employees" action="emploee" method="post">
        <button class="btn btn-default" name="action" type="submit" value="showEmployees">Back to employees list</button>
        <input type="hidden" name="id" value="<c:out value="${department.id}"/>">
    </form>
</div>
</body>
</html>

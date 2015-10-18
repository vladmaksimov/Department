<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vlad-m
  Date: 16.10.15
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <%--<link href="<c:url value="/css/bootstrap.css" />" rel="stylesheet">--%>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1 style="text-align: center"><c:out value="${error}"/></h1>
    <%--<form name="Back to department list" method="get">--%>
    <%--<button type="submit" class="btn btn-default" name="action" value="backButton">Back to department list--%>
    <%--</button>--%>
    <%--</form>--%>
</div>

</body>
</html>

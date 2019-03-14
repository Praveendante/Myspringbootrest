<%--
  Created by IntelliJ IDEA.
  User: mobile
  Date: 2019-03-13
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Users DetailList</title>
    <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
    <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
<div class="container1">
    <h2>User FullList</h2>
    <table class="table table-striped">
        <thead>
        <th scope="row">ID</th>
        <th scope="row">STATE</th>
        <th scope="row">CITY</th>
        </thead>
        <tbody>
        <c:forEach items="${fulluserList}" var="model2" >
            <tr>
                <td>${model2.id }</td>
                <td>${model2.state}</td>
                <td>${model2.city}</td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

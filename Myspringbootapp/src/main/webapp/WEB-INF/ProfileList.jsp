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
    <title>User Profile</title>
    <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
    <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <h2>User Profile</h2>
    <table class="table table-striped">
        <thead>
        <th scope="row">ID</th>
        <th scope="row">NAME</th>
        <th scope="row">EMAIL</th>
        <th scope="row">AGE</th>
        <th scope="row">STATE</th>
        <th scope="row">CITY</th>
        </thead>
        <tbody>
        <c:forEach items="${ProfileList}" var="model" >
            <tr>
                <td>${model.id }</td>
                <td>${model.name }</td>
                <td>${model.email }</td>
                <td>${model.userProfile.age }</td>
                <td>${model.userProfile.city }</td>
                <td>${model.userProfile.state }</td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
    <spring:url value="/users" var="addURL" />
    <a class="btn btn-primary" href="${addURL }" role="button" >Return Userlist</a>
</div>
</body>
</html>

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
    <title>Users List</title>
    <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
    <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <h2>User List</h2>
    <table class="table table-striped">
        <thead>
        <th scope="row">ID</th>
        <th scope="row">NAME</th>
        <th scope="row">EMAIL</th>
        <th scope="row">GET DETAILS</th>
        <th scope="row">Update</th>
        <th scope="row">Delete</th>
        </thead>
        <tbody>
        <c:forEach items="${userList}" var="model" >
            <tr>
                <td>${model.id }</td>
                <td>${model.name }</td>
                <td>${model.email }</td>

                <td>
                    <spring:url value="/getdetails/${model.id}" var="detailsURL" />
                    <a class="btn btn-primary" href="${detailsURL}" role="button" >Get details</a>
                </td>
                <td>
                    <spring:url value="/updateuser/${model.id}" var="updateURL" />
                    <a class="btn btn-primary" href="${updateURL}" role="button" >Update</a>
                </td>
                <td>
                    <spring:url value="/deleteuser/${model.id}" var="deleteURL" />
                    <a class="btn btn-primary" href="${deleteURL}" role="button" >Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <spring:url value="/adduser/" var="addURL" />
    <a class="btn btn-primary" href="${addURL }" role="button" >Add New Article</a>
</div>
</body>
</html>

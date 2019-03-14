<%--
  Created by IntelliJ IDEA.
  User: mobile
  Date: 2019-03-13
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Form</title>
    <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
    <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <spring:url value="/savedetails" var="saveURLL" />
    <h2>UserForm</h2>
    <%--@elvariable id="Userform" type=""--%>
    <%--@elvariable id="Userdetails" type=""--%>
    <form:form modelAttribute="Userdetails" method="post" action="${saveURLL}" cssClass="form" >

        <form:hidden path="id"/>
        <div class="form-group">
            <label>STATE</label>
            <form:input path="state" cssClass="form-control" id="state" />
        </div>
        <div class="form-group">
            <label>CITY</label>
            <form:input path="city" cssClass="form-control" id="city" />
        </div>
        <button type="submit" class="btn btn-primary">Savedetails</button>
    </form:form>

</div>
</body>
</html>
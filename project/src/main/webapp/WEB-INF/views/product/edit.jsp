<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>

<h1>Edit User</h1>

<form:form action="update" modelAttribute="product">

    <label for="id">Id:</label>
    <form:input path="id" id="for" readonly="true"/>
    <form:errors path="id"/>

    <br><br>

     <label for="username">Id:</label>
        <form:input path="username" id="for" readonly="true"/>
        <form:errors path="username"/>

        <br><br>

    <label for="Product name">Name:</label>
    <form:input path="name" id="name"/>
    <form:errors path="name"/>

    <br><br>

    <label for="description">Description:</label>
    <form:input path="description" id="description"/>
    <form:errors path="description"/>

    <br><br>

    <label for="address">Address:</label>
    <form:input path="address" id="address"/>
    <form:errors path="address"/>

    <br><br>

  <label for="number">Number:</label>
    <form:input path="number" id="number"/>
    <form:errors path="number"/>

    <br><br>
  <label for="p_price">Price:</label>
     <form:input path="p_price" id="p_price"/>
     <form:errors path="p_price"/>

     <br><br>


     <label for="type">number:</label>
            <form:input path="type" id="type"/>
            <form:errors path="type"/>

            <br><br>

    <input type="submit">

</form:form>

</body>
</html>

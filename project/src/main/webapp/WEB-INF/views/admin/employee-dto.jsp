<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create Employee</title>
 <style>
        /* CSS for header and navigation */
        header {

          display: flex;
          align-items: center;
          justify-content: space-between;
          background-color: #70cae0;
          padding: 10px 20px;
          box-shadow: 0 0 5px rgba(78, 37, 37, 0.1);
        }

        .header-left {
          flex: 1;
        }

        .header-center {
          flex: 1;
          text-align: center;
        }

        .header-center img {
          height: 50px;
        }

        .header-right {
          flex: 1;
          text-align: right;
        }
        nav ul {
           list-style: none;
           margin: 0;
           padding: 0;
         }

         nav ul li {
           display: inline-block;
           margin-left: 10px;
         }

         nav ul li:first-child {
           margin-left: 0;
         }

         nav ul li a {
           color: #333333;
           text-decoration: none;
           font-size: 16px;
           font-weight: bold;
         }

         nav ul li a:hover {
           color: #000000;
         }
         main {
          padding: 20px;
        }
        fieldset {

          margin: 30px auto;
          width: 40%;
        }
        footer {

            bottom: 0;
            width: 100%;
            height: 60px;
            line-height: 60px;
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 10px;
         }

        label {
          display: inline-block;
          width: 100px;
        }

        input[type="text"],
        input[type="password"],
        input[type="date"] {
          padding: 2px;
          border: 1px solid #ccc;
          border-radius: 2px;
          box-sizing: border-box;
          margin-top: 5px;
          margin-bottom: 10px;
          width: 100%;
          max-width: 200px;
        }

        input[type="submit"] {
          background-color: #4CAF50;
          color: white;
          padding: 10px 15px;
          border: none;
          border-radius: 4px;

        }

        input[type="submit"]:hover {
          background-color: #45a049;
        }
    </style>
</head>
<body>

<header>
    <div class="header-left">
        <h1>Marketplace</h1>
    </div>
    <div class="header-center">
        <a href="#"><img src="path/to/logo.png" alt="Logo"></a>
    </div>
    <div class="header-right">
       <nav>
          <ul>
                <li><a href="${pageContext.request.contextPath}">Profile</a></li>
                <li><a href="${pageContext.request.contextPath}">View</a></li>
                <li><a href="${pageContext.request.contextPath}#">Contact</a></li>
                <li><a href="${pageContext.request.contextPath}#">About</a></li>
                <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
            </ul>
       </nav>
    </div>
</header>

<fieldset >
<h1>CREATE EMPLOYEE</h1>
<form:form action="storeEmp_dto" modelAttribute="employeeDto">

    <label for="username">Username:</label>
    <form:input path="username" id="username"/>
    <form:errors path="username"/>

    <br><br>

    <label for="full_name">Full Name:</label>
    <form:input path="fullName" id="full_name"/>
    <form:errors path="fullName"/>

    <br><br>

     <label for="password">Password:</label>
         <form:input path="password" id="password"/>
         <form:errors path="password"/>

     <br><br>

     <label for="uni_id">University ID:</label>
     <form:input path="uni_id" id="uni_id"/>
     <form:errors path="uni_id"/>

     <br><br>

      <label for="address">Address:</label>
      <form:input path="address" id="address"/>
     <form:errors path="address"/>

     <br><br>




    <label for="gender">Gender:</label>
    <form:radiobutton path="gender" id="gender" value="MALE"/>MALE
    <form:radiobutton path="gender" id="gender" value="FEMALE"/>FEMALE
    <form:errors path="gender"/>

    <br><br>

    <label for="dob">Date Of Birth:</label>
    <form:input type="date" path="dateOfBirth" id="dob"/>
    <form:errors path="dateOfBirth"/>

    <br><br>



    <input type="submit">

</form:form>

</fieldset>
<footer>
    <p>&copy; 2023 Ecom. All rights reserved.</p>
</footer>
</body>
</html>

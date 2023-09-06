<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create </title>
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
        <a href="#"><img src="${pageContext.request.contextPath}/resources/img/AIUBTRADE.png" alt="Logo"></a>
    </div>
    <div class="header-right">
       <nav>
          <ul>
             <li><a href="${pageContext.request.contextPath}">Profile</a></li>
           <li><a href="${pageContext.request.contextPath}/products/postList">PostList</a></li>
             <li><a href="${pageContext.request.contextPath}#">Contact</a></li>
             <li><a href="${pageContext.request.contextPath}#">About</a></li>
             <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
            </ul>
       </nav>
    </div>
</header>

<fieldset >
<h1>Create Product</h1>
<form:form action="store" modelAttribute="product">




    <label for="name">Product Name</label>
    <form:input path="name" id="name"/>
    <form:errors path="name"/>

    <br><br>

     <label for="type">Product Type:</label>
         <form:radiobutton path="type" id="type" value="BOOK"/>BOOK
         <form:radiobutton path="type" id="type" value="MOBILE"/>MOBILE
         <form:radiobutton path="type" id="type" value="LAB EQUIPMENT"/>LAB EQUIPMENT
          <form:radiobutton path="type" id="type" value="TO-LET"/>TO-LET
     <form:errors path="type"/>

     <br><br>

     <label for="description">Description:</label>
         <form:input path="description" id="description"/>
         <form:errors path="description"/>

     <br><br>

     <label for="p_price">Product Price:</label>
     <form:input path="p_price" id="p_price"/>
     <form:errors path="p_price"/>

     <br><br>

      <label for="address">Address:</label>
      <form:input path="address" id="address"/>
     <form:errors path="address"/>

     <br><br>

    <label for="number">Mobile Number:</label>
    <form:input  path="number" id="number"/>
    <form:errors path="number"/>

    <br><br>



    <input type="submit">

</form:form>

</fieldset>
<footer>
    <p>&copy; 2023 AIUB. All rights reserved.</p>
</footer>
</body>
</html>

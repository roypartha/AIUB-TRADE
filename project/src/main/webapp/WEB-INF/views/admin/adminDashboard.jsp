<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home -AIUB Marketplace </title>

 <style>
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
          .body{
              text-align: center;
          }
          footer {
                position: absolute;
                bottom: 0;
                width: 100%;
                height: 60px;
                line-height: 60px;
                background-color: #333;
                color: #fff;
                text-align: center;
                padding: 10px;
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
<main>
    <div class="body" >
        <h1>ADMIN DASHBOARD</h1>
        <h2>Welcome , ${loggedInUser}</h2>
    </div>
     <nav>
        <ul>
           <li><a href="${pageContext.request.contextPath}/admin/edit">Update Personal Info</a></li> <br><br>
           <li><a href="${pageContext.request.contextPath}/admin/changePassword">Change Password</a></li> <br><br>
           <li><a href="${pageContext.request.contextPath}/admin/employee-dto">Add Employee</a></li> <br><br>
           <li><a href="${pageContext.request.contextPath}/admin/updateEmployee">Update Employee</a></li> <br><br>
           <li><a href="${pageContext.request.contextPath}/admin/list">Update &  Delete </a></li> <br><br>
           <li><a href="${pageContext.request.contextPath}/admin/customerList">View Customer </a></li><br><br>
             <li><a href="${pageContext.request.contextPath}/admin/employeeList">View Employee </a></li><br><br>
        </ul>
    </nav>
</main>
<footer>
    <p>&copy; 2023 AIUB. All rights reserved.</p>
</footer>
</body>
</html>


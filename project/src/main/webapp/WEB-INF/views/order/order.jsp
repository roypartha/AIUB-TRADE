<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create Order</title>
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

         label {
           display: inline-block;
           width: 100px;
         }


         input[type="text"],
         input[type="password"],
         input[type="date"],
         select {
           padding: 8px;
           border: 1px solid #ccc;
           border-radius: 2px;
           box-sizing: border-box;
           margin-top: 5px;
           margin-bottom: 10px;
           width: 100%;
           max-width: 200px;
           font-size: 16px;
         }

         input[type="submit"] {
           background-color: #70cae0;
           border: none;
           color: white;
           padding: 10px 20px;
           text-align: center;
           text-decoration: none;
           display: inline-block;
           font-size: 16px;
           margin-top: 10px;
           border-radius: 5px;
           cursor: pointer;
         }

         table {
           border-collapse: collapse;
           width: 100%;
         }

         th, td {
           padding: 8px;
           text-align: left;
           border-bottom: 1px solid #ddd;
         }

         th {
           background-color: #70cae0;
           color: white;
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
<fieldset>
<h1>Create Order</h1>

<form:form action="store_order" method="post" modelAttribute="orderDto">
    <label for="product-select">Select a product:</label>
    <select name="productId" id="product-select">
        <c:forEach items="${products}" var="product">
            <option value="${product.id}">${product.name}</option>
        </c:forEach>
    </select>

    <br><br>

    <label for="customer-select">Select a customer:</label>
    <select name="customerId" id="customer-select">
        <c:forEach items="${customers}" var="customer">
            <option value="${customer.id}">${customer.user.fullName}</option>
        </c:forEach>
    </select>

    <br><br>

    <input type="submit" value="Submit">
</form:form>
<fieldset>
<footer>
    <p>&copy; 2023 AIUB. All rights reserved.</p>
</footer>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Products</title>
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
<h1>Products</h1>

<input type="button" value="Add Product" onclick="window.location.href='create';return false;">

<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Product Name</th>
        <th>Product Type</th>
        <th>Product Description</th>
        <th>Product Address</th>
        <th>Product price</th>
        <th>Action</th>


    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="product">
        <tr>
            <c:url var="updateLink" value="/products/edit">
                <c:param name="productId" value="${product.id}" />
            </c:url>
            <c:url var="deleteLink" value="/products/delete">
                <c:param name="productId" value="${product.id}" />
            </c:url>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.type}</td>
            <td>${product.description}</td>
            <td>${product.address}</td>
            <td>${product.p_price}</td>

            <td><a href="${updateLink}">Update</a> | <a href="${deleteLink}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<footer>
    <p>&copy; 2023 AIUB. All rights reserved.</p>
</footer>
</body>
</html>

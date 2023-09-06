<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>About -AIUB TRADE</title>

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
            <h1>AIUB TRADE</h1>
        </div>
        <div class="header-center">
            <a href="/img"><img src="${pageContext.request.contextPath}/images/AIUBTRADE.png" alt="Logo"></a>
        </div>
        <div class="header-right">
        <nav>
            <ul>
                <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
               <li><a href="${pageContext.request.contextPath}/home/create_dto">Signup</a></li>
               <li><a href="${pageContext.request.contextPath}/home/adminDashboard">Contact</a></li>
               <li><a href="${pageContext.request.contextPath}/home/about">About</a></li>
            </ul>
        </nav>
        </div>
</header>
<main>
    <h1>ABOUT US</h1>
    <p>
    AIUB Trade is a user-friendly online marketplace that enables university students to buy and sell their used items easily and efficiently. <br>
    The website is designed to facilitate the buying and selling of a wide range of products, including books, sports gear, electronics, and more.<br><br>

    Students can create an account on AIUB Trade and start listing their items for sale immediately.<br>
    The platform features a user-friendly interface that makes it easy for sellers to create and manage their listings.<br>
    They can upload photos of their items, set a price, and include a description to attract potential buyers.<br><br>

    For buyers, AIUB Trade offers a wide selection of used items at competitive prices.<br>
    The platform allows users to search for specific items or browse by category. <br>
    Buyers can also message sellers directly to ask questions or negotiate prices.<br><br>

    AIUB Trade provides a safe and secure platform for transactions to take place.<br>
     The website uses advanced security measures to protect user information and payment details.<br>
      Sellers receive payment for their items through the website, which is then transferred to their bank account.<br>

    Overall, AIUB Trade is a convenient and reliable platform for university students to buy and sell their used items.<br>
     Whether you are looking for textbooks, sporting equipment, or electronics, AIUB Trade has got you covered.</p>
</main>
<footer>
    <p>&copy; 2023 AIUB. All rights reserved.</p>
</footer>
</body>
</html>


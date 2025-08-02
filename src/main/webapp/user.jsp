<%--
  Created by IntelliJ IDEA.
  User: kaviruMendis
  Date: 7/10/2025
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Dashboard - Pahana Edu Book Shop</title>
</head>
<body>
<h1 class="text-center mt-5">Welcome User</h1>
<div class="container mt-5">
    <h2 class="text-center mb-4">Welcome, User - Pahana Edu Book Shop</h2>

    <div class="list-group">
        <a href="newcustomer.jsp" class="list-group-item list-group-item-action">
             Add New Customer
        </a>
        <a href="ViewCustomer.jsp" class="list-group-item list-group-item-action">
            View Customer Details
        </a>
        <a href="UpdateCustomer.jsp" class="list-group-item list-group-item-action">
             Update Existing Customer
        </a>
        <a href="DeleteCustomer.jsp" class="list-group-item list-group-item-action">
             Delete Customer
        </a>
        <a href="additems.jsp" class="list-group-item list-group-item-action">
             Add New Items
        </a>
        <a href="UpdateItem.jsp" class="list-group-item list-group-item-action">
             Update Items
        </a>
        <a href="ViewItem.jsp" class="list-group-item list-group-item-action">
             View Items
        </a>
        <a href="deleteUser.jsp" class="list-group-item list-group-item-action">
             Delete Items
        </a>
        <a href="deleteUser.jsp" class="list-group-item list-group-item-action">
             Generate Bills
        </a>
        <a href="deleteUser.jsp" class="list-group-item list-group-item-action">
             Help Menu
        </a>
        <a href="login.jsp" class="list-group-item list-group-item-action text-danger">
            🔒 Logout
        </a>
    </div>
</div>
</body>
</html>


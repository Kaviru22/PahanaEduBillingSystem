<%--
  Created by IntelliJ IDEA.
  User: kaviruMendis
  Date: 7/10/2025
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Dashboard - Pahana Edu Book Shop</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">

    <style>
        /* Body */
        body {
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #74ebd5, #acb6e5); /* light gradient */
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        /* Card container */
        .dashboard-card {
            background-color: #0B3D91; /* dark blue */
            padding: 30px 40px;
            border-radius: 20px;
            box-shadow: 0 8px 25px rgba(0,0,0,0.2);
            max-width: 400px;
            width: 100%;
        }

        /* Heading */
        .dashboard-card h2 {
            text-align: center;
            color: #ffffff;
            font-family: 'Georgia', serif;
            font-size: 1.8rem;
            margin-bottom: 25px;
            text-shadow: 1px 1px 2px rgba(0,0,0,0.3);
        }

        /* List items */
        .list-group-item {
            background-color: #e1e8f0; /* light gray-blue */
            color: #0B3D91; /* dark blue text */
            font-weight: 600;
            border-radius: 10px;
            margin-bottom: 10px;
            transition: all 0.3s ease;
        }

        .list-group-item:hover {
            background-color: #d68910; /* brighter blue on hover */
            color: white;
            transform: translateX(5px);
        }

        /* Logout button */
        .list-group-item.text-danger {
            background-color: #e74c3c; /* red for logout */
            color: white !important;
            text-align: center;
            font-weight: bold;
        }

        .list-group-item.text-danger:hover {
            background-color: #c0392b;
            color: white !important;
            transform: translateX(0);
        }

        @media screen and (max-width: 420px) {
            .dashboard-card { padding: 20px; margin: 10px; }
            .dashboard-card h2 { font-size: 1.5rem; }
        }
    </style>
</head>
<body>
<div class="dashboard-card">
    <h2>User Dashboard</h2>

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
        <a href="ViewItem.jsp" class="list-group-item list-group-item-action">
            View Items
        </a>
        <a href="billing.jsp" class="list-group-item list-group-item-action">
            Generate Bills
        </a>
        <a href="helpsection.jsp" class="list-group-item list-group-item-action">
            Help Menu
        </a>
        <a href="login.jsp" class="list-group-item text-danger list-group-item-action">
            Logout
        </a>
    </div>
</div>
</body>
</html>

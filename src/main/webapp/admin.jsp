<%--
  Created by IntelliJ IDEA.
  User: kaviruMendis
  Date: 7/10/2025
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard - Pahana Edu Book Shop</title>
    <!-- Bootstrap CDN -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">

    <style>
        /* Body */
        body {
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg,#74ebd5,#acb6e5);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        /* Card container */
        .dashboard-card {
            background-color: darkred; /* dark red */
            padding: 30px 40px;
            border-radius: 20px;
            box-shadow: 0 8px 25px rgba(0,0,0,0.2);
            max-width: 400px;
            width: 100%;
        }

        /* Heading */
        .dashboard-card h2 {
            text-align: center;
            color: #fff;
            font-family: 'Georgia', serif;
            font-size: 1.8rem;
            margin-bottom: 25px;
            text-shadow: 1px 1px 2px rgba(0,0,0,0.3);
        }

        /* List items */
        .list-group-item {
            background-color: #f7f7f7;
            color: #2B0808;
            font-weight: 600;
            border-radius: 10px;
            margin-bottom: 10px;
            transition: all 0.3s ease;
        }

        .list-group-item:hover {
            background-color: #d68910;
            color: white;
            transform: translateX(5px);
        }

        .list-group-item.text-danger {
            background-color: green; /* red background */
            color: white !important;   /* force white text */
            text-align: center;
            font-weight: bold;
        }

        .list-group-item.text-danger:hover {
            background-color: darkgreen;
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
    <h2>Admin Dashboard</h2>

    <div class="list-group">
        <a href="newuser.jsp" class="list-group-item list-group-item-action">
            Add New User
        </a>
        <a href="updateUser.jsp" class="list-group-item list-group-item-action">
            Edit Existing User
        </a>
        <a href="deleteUser.jsp" class="list-group-item list-group-item-action">
            Delete a User
        </a>
        <a href="additems.jsp" class="list-group-item list-group-item-action">
            Add New Items
        </a>
        <a href="UpdateItem.jsp" class="list-group-item list-group-item-action">
            Update Items
        </a>
        <a href="DeleteItem.jsp" class="list-group-item list-group-item-action">
            Delete Items
        </a>
        <a href="login.jsp" class="list-group-item text-danger list-group-item-action">
            Logout
        </a>
    </div>
</div>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: kaviruMendis
  Date: 8/2/2025
  Time: 12:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.pahanaeduonlinebillingsys.customer.model.CustomerRegister" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Customer - Pahana Edu Book Shop</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

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

        /* Card */
        .card {
            background-color: #0B3D91; /* dark blue */
            padding: 30px 25px;
            border-radius: 20px;
            box-shadow: 0 8px 25px rgba(0,0,0,0.2);
            max-width: 500px;
            width: 100%;
        }

        /* Heading */
        h3 {
            text-align: center;
            color: #ffffff;
            font-family: 'Georgia', serif;
            font-weight: 700;
            margin-bottom: 25px;
        }

        /* Form labels */
        .form-label {
            color: #ffffff;
            font-weight: 600;
        }

        /* Inputs */
        .form-control {
            border-radius: 8px;
            padding: 8px 10px;
            border: 1px solid #fff;
            background-color: rgba(255,255,255,0.9);
            font-size: 0.9rem;
        }

        .form-control:focus {
            outline: none;
            border-color: #fff;
            box-shadow: 0 0 5px rgba(255,255,255,0.5);
        }

        /* Buttons */
        .btn {
            border-radius: 8px;
            font-weight: bold;
            margin-bottom: 10px;
            padding: 8px 0;
            width: 100%;
            font-size: 0.95rem;
            transition: all 0.3s ease;
        }

        .btn-success { background-color: #27ae60; border: none; color: white; }
        .btn-success:hover { background-color: #1e8449; }

        .btn-primary { background-color: #2980b9; border: none; color: white; }
        .btn-primary:hover { background-color: #1f618d; }

        /* Alerts */
        .alert {
            border-radius: 10px;
            margin-top: 10px;
            font-weight: 500;
            text-align: center;
        }

        /* Customer info display */
        .customer-info {
            color: white;
            background-color: rgba(255,255,255,0.1);
            padding: 15px;
            border-radius: 10px;
            margin-top: 20px;
        }

        .customer-info p {
            margin: 5px 0;
        }

        @media screen and (max-width: 500px) {
            .card { padding: 20px; margin: 10px; }
        }
    </style>
</head>
<body>

<div class="card">
    <h3>Search Customer</h3>

    <!-- Search form -->
    <form action="ViewCustomer" method="get">
        <div class="mb-3">
            <label for="accno" class="form-label">Enter Account No:</label>
            <input type="text" class="form-control" id="accno" name="accno" required>
        </div>
        <button type="submit" class="btn btn-success">Search</button>
        <button type="button" class="btn btn-primary" onclick="window.location.href='user.jsp'">Back to Home</button>
    </form>

    <%
        CustomerRegister customerRegister = (CustomerRegister) request.getAttribute("customer");
        String message = (String) request.getAttribute("message");
    %>

    <% if (message != null) { %>
    <div class="alert alert-info"><%= message %></div>
    <% } %>

    <% if (customerRegister != null) { %>
    <div class="customer-info">
        <h5 class="mb-3">Customer Information</h5>
        <p><strong>Account No:</strong> <%= customerRegister.getAccNo() %></p>
        <p><strong>First Name:</strong> <%= customerRegister.getFirstName() %></p>
        <p><strong>Last Name:</strong> <%= customerRegister.getLastName() %></p>
        <p><strong>Address:</strong> <%= customerRegister.getAddress() %></p>
        <p><strong>Mobile No:</strong> <%= customerRegister.getMobileNo() %></p>
    </div>
    <% } else if (message == null) { %>
    <p class="text-white mt-3">Please enter an account number to search.</p>
    <% } %>
</div>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: kaviruMendis
  Date: 8/10/2025
  Time: 9:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Help - Pahana Edu Billing System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 30px;
            background-color: #f9f9f9;
            color: #333;
        }
        .container {
            background: white;
            padding: 25px;
            border-radius: 8px;
            max-width: 700px;
            margin: auto;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }
        h1 {
            color: #2c3e50;
        }
        ul {
            margin-left: 20px;
        }
        button {
            background-color: #3498db;
            color: white;
            border: none;
            padding: 12px 25px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            margin-top: 20px;
        }
        button:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Help - Pahana Edu Billing System</h1>
    <p>
        <strong>Welcome to Pahana Edu!</strong> We are proud to be one of Colombo’s leading bookshops, serving hundreds of customers with quality educational materials and stationery.
    </p>
    <p>
        This web platform allows you to easily manage customer accounts and billing information from anywhere.
    </p>

    <h2>How to Use This System</h2>
    <ul>
        <li><strong>Login:</strong> Enter your username and password to securely access the system.</li>
        <li><strong>Add Customer:</strong> Register new customers by filling out their details including account number, name, address, and contact.</li>
        <li><strong>Edit Customer:</strong> Update existing customer information to keep data accurate.</li>
        <li><strong>View Customer:</strong> Look up customer accounts and their billing history.</li>
        <li><strong>Calculate & Print Bill:</strong> Add items and units consumed to generate a bill and print a receipt.</li>
        <li><strong>Help:</strong> Access this page anytime for guidance.</li>
        <li><strong>Exit:</strong> Log out safely after using the system.</li>
    </ul>

    <p>
        For further assistance, please contact our support at <b>070-0000000</b> or email <b>support@pahanaedu.lk</b>.
    </p>

    <form action="user.jsp">
        <button type="submit">Back to Home</button>
    </form>
</div>
</body>
</html>


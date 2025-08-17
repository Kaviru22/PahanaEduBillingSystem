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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background: linear-gradient(135deg,#74ebd5,#acb6e5);
        }

        .card {
            background-color: #2B0808; /* dark red */
            padding: 30px 25px;
            border-radius: 20px;
            box-shadow: 0 8px 25px rgba(0,0,0,0.2);
            max-width: 700px;
            width: 100%;
            color: #fff;
        }

        h1, h2 {
            text-align: center;
            font-family: 'Georgia', serif;
            text-shadow: 1px 1px 2px rgba(0,0,0,0.3);
        }

        h1 { margin-bottom: 20px; }
        h2 { margin-top: 20px; margin-bottom: 15px; }

        p {
            font-size: 1rem;
            line-height: 1.6;
        }

        ul {
            margin-left: 20px;
        }

        .btn-home {
            display: block;
            width: 50%;
            margin: 20px auto 0 auto;
            padding: 10px 0;
            font-weight: bold;
            font-size: 1rem;
            border-radius: 8px;
            background-color: #2980b9;
            color: #fff;
            border: none;
            transition: all 0.3s ease;
        }

        .btn-home:hover {
            background-color: #1f618d;
        }

        @media screen and (max-width: 768px) {
            .card { padding: 20px 15px; }
            .btn-home { width: 70%; }
        }

        @media screen and (max-width: 480px) {
            .card { padding: 15px 10px; }
            h1, h2 { font-size: 1.5rem; }
            p, ul { font-size: 0.9rem; }
        }
    </style>
</head>
<body>

<div class="card">
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
        For further assistance, please contact our support at <b>070-6582553</b> or email <b>support@pahanaedu.lk</b>.
    </p>

    <form action="user.jsp">
        <button type="submit" class="btn-home">Back to Home</button>
    </form>
</div>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: kaviruMendis
  Date: 8/1/2025
  Time: 8:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>New Customer - Pahana Edu Book Shop</title>
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
            max-width: 450px;
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

        .btn-warning { background-color: #f39c12; border: none; color: white; }
        .btn-warning:hover { background-color: #d68910; }

        .btn-primary { background-color: #2980b9; border: none; color: white; }
        .btn-primary:hover { background-color: #1f618d; }

        /* Alerts */
        .alert {
            border-radius: 10px;
            margin-top: 10px;
            font-weight: 500;
            text-align: center;
        }

        @media screen and (max-width: 450px) {
            .card { padding: 20px; margin: 10px; }
        }
    </style>

    <script>
        function clearForm() {
            if(confirm("Do you want to clear the entered details?")) {
                document.getElementById("customerForm").reset();
                alert("Form cleared successfully.");
            }
        }
    </script>
</head>
<body>

<div class="card">
    <h3>Create New Customer</h3>

    <!-- Message Display -->
    <% if (request.getAttribute("error") != null) { %>
    <div class="alert alert-danger">
        <%= request.getAttribute("error") %>
    </div>
    <% } else if (request.getAttribute("success") != null) { %>
    <div class="alert alert-success">
        <%= request.getAttribute("success") %>
    </div>
    <% } %>

    <!-- Form -->
    <form id="customerForm" action="newcustomer" method="post">
        <div class="mb-3">
            <label for="accno" class="form-label">Account No:</label>
            <input type="text" class="form-control" id="accno" name="accno" required>
        </div>
        <div class="mb-3">
            <label for="fname" class="form-label">First Name:</label>
            <input type="text" class="form-control" id="fname" name="fname" required>
        </div>
        <div class="mb-3">
            <label for="lname" class="form-label">Last Name:</label>
            <input type="text" class="form-control" id="lname" name="lname" required>
        </div>
        <div class="mb-3">
            <label for="address" class="form-label">Address:</label>
            <input type="text" class="form-control" id="address" name="address" required>
        </div>
        <div class="mb-3">
            <label for="mobileno" class="form-label">Mobile No:</label>
            <input type="text" class="form-control" id="mobileno" name="mobileno" required>
        </div>

        <button type="submit" class="btn btn-success">Create</button>
        <button type="button" class="btn btn-warning" onclick="clearForm()">Clear Form</button>
        <button type="button" class="btn btn-primary" onclick="window.location.href='user.jsp'">Back to Home</button>
    </form>
</div>

</body>
</html>

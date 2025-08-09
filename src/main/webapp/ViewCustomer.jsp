<%--
  Created by IntelliJ IDEA.
  User: kaviruMendis
  Date: 8/2/2025
  Time: 12:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.pahanaeduonlinebillingsys.customer.model.CustomerRegister" %>
<html>
<head>
    <title>View Customer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow p-4 mx-auto" style="max-width: 500px;">

        <h3 class="text-center mb-3">Search Customer</h3>

        <!-- Search form -->
        <form action="ViewCustomer" method="get">
            <div class="mb-3">
                <label for="accno" class="form-label">Enter Acc No:</label>
                <input type="text" class="form-control" id="accno" name="accno" required>
            </div>
            <button type="submit" class="btn btn-success w-100">Search</button>
        </form>

        <%
            CustomerRegister customerRegister = (CustomerRegister) request.getAttribute("customer");
            String message = (String) request.getAttribute("message");
        %>

        <% if (message != null) { %>
        <div class="alert alert-info mt-3"><%= message %></div>
        <% } %>

        <% if (customerRegister != null) { %>
        <div class="mt-4">
            <h5 class="mb-3">Customer Information</h5>
            <p><strong>Account No:</strong> <%= customerRegister.getAccNo() %></p>
            <p><strong>First Name:</strong> <%= customerRegister.getFirstName() %></p>
            <p><strong>Last Name:</strong> <%= customerRegister.getLastName() %></p>
            <p><strong>Address:</strong> <%= customerRegister.getAddress() %></p>
            <p><strong>Mobile No:</strong> <%= customerRegister.getMobileNo() %></p>
        </div>
        <% } else if (message == null) { %>
        <!-- Only show if no customer & no message (e.g., first page load) -->
        <p class="text-muted mt-3">Please enter an account number to search.</p>
        <% } %>

    </div>
</div>

</body>
</html>

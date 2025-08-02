<%--
  Created by IntelliJ IDEA.
  User: kaviruMendis
  Date: 8/2/2025
  Time: 11:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.pahanaeduonlinebillingsys.customer.model.CustomerRegister" %>
<%@ page import="com.example.pahanaeduonlinebillingsys.items.model.ItemAdd" %>
<html>
<head>
    <title>View Customer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow p-4 mx-auto" style="max-width: 500px;">

        <h3 class="text-center mb-3">Search Item</h3>

        <!-- Search form -->
        <form action="ViewItem" method="get">
            <div class="mb-3">
                <label for="itemno" class="form-label">Enter Item No:</label>
                <input type="text" class="form-control" id="itemno" name="itemno" required>
            </div>
            <button type="submit" class="btn btn-success w-100">Search</button>
        </form>

        <%
            ItemAdd itemAdd = (ItemAdd) request.getAttribute("item");
            String message = (String) request.getAttribute("message");
        %>

        <% if (message != null) { %>
        <div class="alert alert-info mt-3"><%= message %></div>
        <% } %>

        <% if (itemAdd != null) { %>
        <div class="mt-4">
            <h5 class="mb-3">Item Information</h5>
            <p><strong>Item No:</strong> <%= itemAdd.getItemno() %></p>
            <p><strong>Item Name:</strong> <%= itemAdd.getItemname() %></p>
            <p><strong>Quantity:</strong> <%= itemAdd.getQuantity() %></p>
            <p><strong>Unit of Price:</strong> <%= itemAdd.getUnitprice() %></p>
        </div>
        <% } else if (message == null) { %>
        <!-- Only show if no customer & no message (e.g., first page load) -->
        <p class="text-muted mt-3">Please enter an account number to search.</p>
        <% } %>

    </div>
</div>

</body>
</html>


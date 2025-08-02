<%--
  Created by IntelliJ IDEA.
  User: kaviruMendis
  Date: 8/2/2025
  Time: 10:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.pahanaeduonlinebillingsys.user.model.User" %>
<%@ page import="java.util.*" %>
<%@ page import="com.example.pahanaeduonlinebillingsys.customer.model.CustomerRegister" %>
<%@ page import="com.example.pahanaeduonlinebillingsys.items.model.ItemAdd" %>
<html>
<head>
    <title>Edit Items</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow p-4 mx-auto" style="max-width: 500px;">

        <h3 class="text-center mb-3">Update Item Details</h3>

        <!-- Search form -->
        <form action="UpdateItem" method="get">
            <div class="mb-3">
                <label for="itemno" class="form-label">Enter Item No:</label>
                <input type="text" class="form-control" id="itemno" name="itemno" required>
            </div>
            <button type="submit" class="btn btn-success w-100">Search</button>
        </form>

        <%
            ItemAdd itemAdd = (ItemAdd) request.getAttribute("item");
            String message = (String) request.getAttribute("message");
            if (message != null) {
        %>
        <div class="alert alert-info mt-3"><%= message %></div>
        <% } %>

        <% if (itemAdd != null) { %>
        <form action="UpdateItem" method="post" class="mt-4">
            <input type="hidden" name="originalItemno" value="<%= itemAdd.getItemno() %>">

            <div class="mb-3">
                <label class="form-label">Item No:</label>
                <input type="text" class="form-control" name="itemno" value="<%= itemAdd.getItemno() %>" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Item Name:</label>
                <input type="text" class="form-control" name="itemname" value="<%= itemAdd.getItemname() %>" required>
            </div>
            <div class="mb-3">
                <label class="form-label">No of Quantity:</label>
                <input type="text" class="form-control" name="quanty" value="<%= itemAdd.getQuantity() %>" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Price of a Unit:</label>
                <input type="text" class="form-control" name="unitprice" value="<%= itemAdd.getUnitprice() %>" required>
            </div>
            <button type="submit" class="btn btn-primary w-100">Update</button>
        </form>
        <% } %>

    </div>
</div>

</body>
</html>


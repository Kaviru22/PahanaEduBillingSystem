<%--
  Created by IntelliJ IDEA.
  User: kaviruMendis
  Date: 8/2/2025
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.pahanaeduonlinebillingsys.user.model.User" %>
<%@ page import="java.util.*" %>
<%@ page import="com.example.pahanaeduonlinebillingsys.customer.model.CustomerRegister" %>
<html>
<head>
    <title>Edit User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow p-4 mx-auto" style="max-width: 500px;">

        <h3 class="text-center mb-3">Update Customer Details</h3>

        <!-- Search form -->
        <form action="UpdateCustomer" method="get">
            <div class="mb-3">
                <label for="accnoSearch" class="form-label">Enter Account No:</label>
                <input type="text" class="form-control" id="accnoSearch" name="accno" required>
            </div>
            <button type="submit" class="btn btn-success w-100">Search</button>
        </form>

        <%
            CustomerRegister customer = (CustomerRegister) request.getAttribute("customer");
            String message = (String) request.getAttribute("message");
            if (message != null) {
        %>
        <div class="alert alert-info mt-3"><%= message %></div>
        <% } %>

        <% if (customer != null) { %>
        <form action="UpdateCustomer" method="post" class="mt-4">
            <input type="hidden" name="originalAccno" value="<%= customer.getAccNo() %>">

            <div class="mb-3">
                <label class="form-label">Acc No:</label>
                <input type="text" class="form-control" name="accno" value="<%= customer.getAccNo() %>" required>
            </div>
            <div class="mb-3">
                <label class="form-label">First Name:</label>
                <input type="text" class="form-control" name="fname" value="<%= customer.getFirstName() %>" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Last Name:</label>
                <input type="text" class="form-control" name="lname" value="<%= customer.getLastName() %>" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Address:</label>
                <input type="text" class="form-control" name="address" value="<%= customer.getAddress() %>" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Mobile No:</label>
                <input type="number" class="form-control" name="mobileno" value="<%= customer.getMobileNo() %>" required>
            </div>

            <button type="submit" class="btn btn-primary w-100">Update</button>
        </form>
        <% } %>

    </div>
</div>

</body>
</html>

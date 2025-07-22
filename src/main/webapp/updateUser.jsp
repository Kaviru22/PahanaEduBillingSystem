<%--
  Created by IntelliJ IDEA.
  User: kaviruMendis
  Date: 7/19/2025
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.pahanaeduonlinebillingsys.user.model.User" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>Edit User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow p-4 mx-auto" style="max-width: 500px;">

        <h3 class="text-center mb-3">Search for User</h3>

        <!-- Search form -->
        <form action="updateUser" method="get">
            <div class="mb-3">
                <label for="usernameSearch" class="form-label">Enter Username:</label>
                <input type="text" class="form-control" id="usernameSearch" name="username" required>
            </div>
            <button type="submit" class="btn btn-success w-100">Search</button>
        </form>

        <%
            User user = (User) request.getAttribute("user");
            String message = (String) request.getAttribute("message");
            if (message != null) {
        %>
        <div class="alert alert-info mt-3"><%= message %></div>
        <% } %>

        <% if (user != null) { %>
        <form action="updateUser" method="post" class="mt-4">
            <input type="hidden" name="originalUsername" value="<%= user.getUsername() %>">

            <div class="mb-3">
                <label class="form-label">Username:</label>
                <input type="text" class="form-control" name="username" value="<%= user.getUsername() %>" required>
            </div>
            <div class="mb-3">
                <label class="form-label">First Name:</label>
                <input type="text" class="form-control" name="firstname" value="<%= user.getFirstName() %>" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Last Name:</label>
                <input type="text" class="form-control" name="lastname" value="<%= user.getLastName() %>" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Email:</label>
                <input type="email" class="form-control" name="email" value="<%= user.getEmail() %>" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Password:</label>
                <input type="password" class="form-control" name="password" value="<%= user.getPassword() %>" required>
            </div>

            <button type="submit" class="btn btn-primary w-100">Update</button>
        </form>
        <% } %>

    </div>
</div>

</body>
</html>

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
    <!-- Bootstrap CDN for styling -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center mb-4">Welcome, Admin - Pahana Edu Book Shop</h2>

    <div class="list-group">
        <a href="newuser.jsp" class="list-group-item list-group-item-action">
            ➕ Add New User
        </a>
        <a href="updateUser.jsp" class="list-group-item list-group-item-action">
            ✏️ Edit Existing User
        </a>
        <a href="deleteUser.jsp" class="list-group-item list-group-item-action">
            ❌ Delete a User
        </a>
        <a href="login.jsp" class="list-group-item list-group-item-action text-danger">
            🔒 Logout
        </a>
    </div>
</div>

<!-- Optional Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>



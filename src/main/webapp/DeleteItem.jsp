<%--
  Created by IntelliJ IDEA.
  User: kaviruMendis
  Date: 8/3/2025
  Time: 12:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>Delete Item</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow p-4 mx-auto" style="max-width: 500px;">

        <h3 class="text-center mb-3">Delete an Item</h3>

        <!-- Message Display -->
        <% if (request.getAttribute("message") != null) { %>
        <div class="alert alert-info text-center mb-3">
            <%= request.getAttribute("message") %>
        </div>
        <% } %>

        <!-- Search form -->
        <form action="DeleteItem" method="post"  onsubmit="return confirm('Are you sure?');">
            <div class="mb-3">
                <label for="itemno" class="form-label">Enter Item No:</label>
                <input type="text" class="form-control" id="itemno" name="itemno" required>
            </div>
            <button type="submit" class="btn btn-success w-100">Delete</button>
        </form>

    </div>
</div>

</body>
</html>


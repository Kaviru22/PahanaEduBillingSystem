<%--
  Created by IntelliJ IDEA.
  User: kaviruMendis
  Date: 8/2/2025
  Time: 9:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>New Items</title>

    <!-- Bootstrap CSS CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Your external CSS -->
    <link rel="stylesheet" href="css/styles.css">
</head>
<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow p-4" style="width: 25rem;">
        <h3 class="text-center mb-4">Add New Items</h3>

        <%-- Show success or error messages --%>
        <% if (request.getAttribute("error") != null) { %>
        <div class="alert alert-danger" role="alert">
            <%= request.getAttribute("error") %>
        </div>
        <% } else if (request.getAttribute("success") != null) { %>
        <div class="alert alert-success" role="alert">
            <%= request.getAttribute("success") %>
        </div>
        <% } %>

        <form action="additems" method="post">
            <div class="mb-3">
                <label for="itemno" class="form-label">Item No:</label>
                <input type="text" class="form-control" id="itemno" name="itemno" required>
            </div>

            <div class="mb-3">
                <label for="itemname" class="form-label">Item Name:</label>
                <input type="text" class="form-control" id="itemname" name="itemname" required>
            </div>

            <div class="mb-3">
                <label for="quanty" class="form-label">No of Quantity:</label>
                <input type="text" class="form-control" id="quanty" name="quanty" required>
            </div>

            <div class="mb-3">
                <label for="unitprice" class="form-label">Price of a Unit:</label>
                <input type="text" class="form-control" id="unitprice" name="unitprice" required>
            </div>

            <button type="submit" class="btn btn-success w-100">Add</button>
        </form>
    </div>
</div>

</body>
</html>



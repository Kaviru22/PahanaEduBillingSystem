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
    <title>New Customer</title>

    <!-- Bootstrap CSS CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Your external CSS -->
    <link rel="stylesheet" href="css/styles.css">
</head>
<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow p-4" style="width: 25rem;">
        <h3 class="text-center mb-4">Create New Customer</h3>

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

        <form action="newcustomer" method="post">
            <div class="mb-3">
                <label for="accnumber" class="form-label">Account No:</label>
                <input type="number" class="form-control" id="accnumber" name="accnumber" required>
            </div>

            <div class="mb-3">
                <label for="firstname" class="form-label">First Name:</label>
                <input type="text" class="form-control" id="firstname" name="firstname" required>
            </div>

            <div class="mb-3">
                <label for="lastname" class="form-label">Last Name:</label>
                <input type="text" class="form-control" id="lastname" name="lastname" required>
            </div>

            <div class="mb-3">
                <label for="address" class="form-label">Address:</label>
                <input type="text" class="form-control" id="address" name="address" required>
            </div>

            <div class="mb-3">
                <label for="mobileno" class="form-label">Mobile No:</label>
                <input type="number" class="form-control" id="mobileno" name="mobileno" required>
            </div>

            <button type="submit" class="btn btn-success w-100">Create</button>
        </form>
    </div>
</div>

</body>
</html>


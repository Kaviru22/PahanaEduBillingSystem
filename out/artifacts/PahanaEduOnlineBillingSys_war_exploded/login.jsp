<%--
  Created by IntelliJ IDEA.
  User: kaviruMendis
  Date: 7/10/2025
  Time: 12:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>

    <!-- Bootstrap CSS (Online CDN) -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Your External CSS -->
    <link rel="stylesheet" href="css/styles.css">

</head>
<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow p-4" style="width: 22rem;">
        <h3 class="text-center mb-4">Login</h3>

        <form action="login" method="post">
            <div class="mb-3">
                <label for="username" class="form-label">Username:</label>
                <input type="text" class="form-control" name="username" id="username" required>
            </div>

            <div class="mb-3">
                <label for="password" class="form-label">Password:</label>
                <input type="password" class="form-control" name="password" id="password" required>
            </div>

            <button type="submit" class="btn btn-primary w-100">Login</button>

            <div class="mt-3 text-center">
                <small>Not a user? <a href="signup.jsp">Create New Account</a></small>
            </div>

            <%-- Optional error message display --%>
            <%
                String error = request.getParameter("error");
                if ("1".equals(error)) {
            %>
            <div class="alert alert-danger mt-3" role="alert">
                Invalid username or password!
            </div>
            <% } %>

        </form>
    </div>
</div>

</body>
</html>


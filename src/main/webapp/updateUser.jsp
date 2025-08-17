<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.pahanaeduonlinebillingsys.user.model.User" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>Edit User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #74ebd5, #acb6e5);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: flex-start;
            padding-top: 50px; /* ensures search form is visible at top */
            padding-bottom: 50px;
        }

        .card {
            background-color: #27ae60; /* green background */
            padding: 20px 25px;
            border-radius: 20px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.2);
            max-width: 420px;
            width: 100%;
        }

        h3 {
            text-align: center;
            font-weight: 700;
            color: white;
            margin-bottom: 20px;
        }

        .form-label {
            font-weight: 600;
            color: white;
            width: 100%;
            padding-left: 10%;
        }

        .form-group {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-bottom: 10px;
        }

        .form-control {
            border-radius: 8px;
            padding: 8px 10px;
            border: 1px solid #fff;
            font-size: 0.9rem;
            transition: all 0.3s ease;
            background-color: rgba(255,255,255,0.9);
            width: 90%;
            max-width: 300px;
        }

        .form-control:focus {
            border-color: #fff;
            box-shadow: 0 0 5px rgba(255,255,255,0.5);
            outline: none;
        }

        .btn {
            border-radius: 8px;
            padding: 8px 0;
            font-weight: bold;
            transition: all 0.3s ease;
            font-size: 0.9rem;
            display: block;
            margin: 10px auto;
            width: 80%;
        }

        .btn-danger { background-color: #c0392b; border: none; color: white; }
        .btn-danger:hover { background-color: #992d22; }

        .btn-warning { background-color: #f39c12; border: none; color: white; }
        .btn-warning:hover { background-color: #d68910; }

        .alert-info {
            background-color: #3498db;
            color: white;
            border: none;
            border-radius: 10px;
            font-weight: 500;
            text-align: center;
            max-width: 300px;
            margin: 10px auto;
            padding: 10px 15px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            font-size: 0.9rem;
        }

        @media screen and (max-width: 450px) {
            .card { padding: 15px 20px; margin: 10px; }
            .btn { width: 100%; }
            .form-control { max-width: 100%; }
        }
    </style>

    <script>
        function clearForm() {
            const confirmClear = confirm("Do you want to clear the editable details?");
            if (confirmClear) {
                const editableFields = document.querySelectorAll('form.mt-4 .form-control');
                editableFields.forEach(field => field.value = '');
            }
        }

        function backToHome() {
            const confirmPage = confirm("Do you want to go back to the main page?");
            if (confirmPage) {
                window.location.href = "admin.jsp";
            }
        }
    </script>
</head>
<body>

<div class="card">
    <h3>Edit User</h3>

    <!-- Search form -->
    <form id="updateUserForm" action="updateUser" method="get">
        <div class="form-group">
            <label for="usernameSearch" class="form-label">Enter Username:</label>
            <input type="text" class="form-control" id="usernameSearch" name="username" required>
        </div>
        <button type="submit" class="btn btn-danger">Search</button>
    </form>

    <%
        User user = (User) request.getAttribute("user");
        String message = (String) request.getAttribute("message");
        Boolean searched = (Boolean) request.getAttribute("searched"); // indicates search attempted
    %>

    <!-- Info / User not found messages -->
    <% if (message != null) { %>
    <div class="alert alert-info mt-3"><%= message %></div>
    <% } else if (searched != null && searched) { %>
    <div class="alert alert-info mt-3">User not found!</div>
    <% } %>

    <% if (user != null) { %>
    <form action="updateUser" method="post" class="mt-4">
        <input type="hidden" name="originalUsername" value="<%= user.getUsername() %>">

        <div class="form-group">
            <label class="form-label">Username:</label>
            <input type="text" class="form-control" name="username" value="<%= user.getUsername() %>" required>
        </div>
        <div class="form-group">
            <label class="form-label">First Name:</label>
            <input type="text" class="form-control" name="firstname" value="<%= user.getFirstName() %>" required>
        </div>
        <div class="form-group">
            <label class="form-label">Last Name:</label>
            <input type="text" class="form-control" name="lastname" value="<%= user.getLastName() %>" required>
        </div>
        <div class="form-group">
            <label class="form-label">Email:</label>
            <input type="email" class="form-control" name="email" value="<%= user.getEmail() %>" required>
        </div>
        <div class="form-group">
            <label class="form-label">Password:</label>
            <input type="password" class="form-control" name="password" value="<%= user.getPassword() %>" required>
        </div>

        <button type="submit" class="btn btn-danger">Update</button>
        <button type="button" class="btn btn-warning" onclick="clearForm()">Clear Form</button>
        <button type="button" class="btn btn-danger" onclick="backToHome()">Back to Home</button>
    </form>
    <% } %>

</div>

</body>
</html>

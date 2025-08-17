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
    <title>Login Page - Book Shop</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        /* Body */
        body {
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg,#74ebd5,#acb6e5);
            height: 100vh;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }

        /* Main heading */
        h2 {
            color: #ffffff; /* changed to dark blue */
            font-family: 'Georgia', serif;
            font-weight: 700;
            font-size: 2.5rem; /* increased size */
            text-align: center;
            margin-bottom: 40px;
            text-shadow: 1px 1px 2px rgba(0,0,0,0.2);
        }

        /* Card */
        .card {
            background-color: #2B0808; /* red background */
            padding: 25px 30px;
            border-radius: 20px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.2);
            max-width: 400px;
            width: 100%;
        }

        /* Headings inside card */
        h3 {
            text-align: center;
            color: white;
            font-weight: 700;
            margin-bottom: 15px;
        }

        /* Form labels */
        .form-label {
            color: white;
            font-weight: 600;
        }

        /* Inputs */
        .form-control {
            border-radius: 8px;
            padding: 8px 10px;
            border: 1px solid #fff;
            background-color: rgba(255,255,255,0.9);
            font-size: 0.9rem;
        }

        .form-control:focus {
            outline: none;
            border-color: #fff;
            box-shadow: 0 0 5px rgba(255,255,255,0.5);
        }

        /* Buttons */
        .btn {
            border-radius: 8px;
            font-weight: bold;
            margin-bottom: 10px;
            width: auto; /* changed to auto for smaller width */
            padding-left: 15%;
            padding-right: 15%;
        }

        .btn-primary { background-color: #2980b9; border: none; color: white; }
        .btn-primary:hover { background-color: #1f618d; }

        .btn-warning { background-color: #f39c12; border: none; color: white; }
        .btn-warning:hover { background-color: #d68910; }

        /* Alerts */
        .alert {
            border-radius: 10px;
            margin-top: 10px;
            font-weight: 500;
        }

        @media screen and (max-width: 420px) {
            .card { padding: 20px; margin: 10px; }
            h2 { font-size: 1.8rem; }
        }
    </style>

    <script>
        function clearForm() {
            if(confirm("Do you want to clear the entered details?")) {
                document.getElementById("loginFormId").reset();
                alert("Details cleared successfully.");
            }
        }
    </script>
</head>
<body>

<h2>Welcome to Pahana Edu Book Shop</h2>

<div class="card">
    <h3>Login Menu</h3>

    <form id="loginFormId" action="login" method="post">
        <div class="mb-3">
            <label for="username" class="form-label">Username:</label>
            <input type="text" class="form-control" name="username" id="username" required>
        </div>

        <div class="mb-3">
            <label for="password" class="form-label">Password:</label>
            <input type="password" class="form-control" name="password" id="password" required>
        </div>

        <button type="submit" class="btn btn-primary mb-2">Login</button>
        <button type="button" class="btn btn-warning" onclick="clearForm()">Clear Form</button>

        <%-- Optional error messages --%>
        <%
            String error = request.getParameter("error");
            if ("1".equals(error)) {
        %>
        <div class="alert alert-danger text-center" role="alert">
            Invalid username or password!
        </div>
        <% } %>

        <% if (request.getAttribute("error") != null) { %>
        <div class="alert alert-danger text-center">
            <%= request.getAttribute("error") %>
        </div>
        <% } %>
    </form>
</div>

</body>
</html>

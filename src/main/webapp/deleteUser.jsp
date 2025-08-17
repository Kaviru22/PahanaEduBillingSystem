<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.pahanaeduonlinebillingsys.user.model.User" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>Delete User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #f5f7fa, #c3cfe2);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: flex-start;
            padding-top: 50px;
        }

        .card {
            background-color: #27ae60; /* green card background */
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
        }

        .form-group, .mb-3 {
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

        .btn-brown { background-color: #8B4513; border: none; color: white; }
        .btn-brown:hover { background-color: #5C3317; }

        .btn-primary-custom { background-color: blue; border: none; color: white; }
        .btn-primary-custom:hover { background-color: darkblue; }

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
</head>
<body>

<div class="card">
    <h3>Delete User</h3>

    <!-- Message Display -->
    <% if (request.getAttribute("message") != null) { %>
    <div class="alert alert-info">
        <%= request.getAttribute("message") %>
    </div>
    <% } %>

    <!-- Search/Delete form -->
    <form action="deleteUser" method="post" onsubmit="return confirm('Are you sure you want to delete this user?');">
        <div class="mb-3">
            <label for="usernameSearch" class="form-label">Enter Username:</label>
            <input type="text" class="form-control" id="usernameSearch" name="username" required>
        </div>
        <button type="submit" class="btn btn-brown">Delete</button>
        <button type="button" class="btn btn-primary-custom" onclick="window.location.href='admin.jsp'">Back to Home</button>
    </form>
</div>

</body>
</html>

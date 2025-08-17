<%--
  Created by IntelliJ IDEA.
  User: kaviruMendis
  Date: 8/3/2025
  Time: 12:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Item</title>
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
            padding-top: 50px;
        }

        .card {
            background-color: #7f8c8d; /* gray form background */
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
        }

        .form-control {
            border-radius: 8px;
            padding: 8px 10px;
            border: 1px solid #fff;
            font-size: 0.9rem;
            transition: all 0.3s ease;
            background-color: rgba(255,255,255,0.9);
        }

        .form-control:focus {
            border-color: #fff;
            box-shadow: 0 0 5px rgba(255,255,255,0.5);
            outline: none;
        }

        .btn {
            border-radius: 8px;
            padding: 8px;
            font-weight: bold;
            transition: all 0.3s ease;
            font-size: 0.9rem;
            margin-bottom: 10px;
        }

        /* Delete button brown */
        .btn-danger-custom { background-color: #a0522d; border: none; color: white; }
        .btn-danger-custom:hover { background-color: #7f381e; }

        /* Back button blue */
        .btn-primary-custom { background-color: #2980b9; border: none; color: white; }
        .btn-primary-custom:hover { background-color: #1f618d; }

        .alert {
            border-radius: 10px;
            font-weight: 500;
            margin-bottom: 10px;
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
    <h3>Delete an Item</h3>

    <!-- Message Display -->
    <% if (request.getAttribute("message") != null) { %>
    <div class="alert alert-info text-center mb-3">
        <%= request.getAttribute("message") %>
    </div>
    <% } %>

    <!-- Delete form -->
    <form action="DeleteItem" method="post" onsubmit="return confirm('Are you sure you want to delete this item?');">
        <div class="mb-3">
            <label for="itemno" class="form-label">Enter Item No:</label>
            <input type="text" class="form-control" id="itemno" name="itemno" required>
        </div>
        <button type="submit" class="btn btn-danger-custom w-100">Delete</button>
        <button type="button" class="btn btn-primary-custom w-100" onclick="window.location.href='admin.jsp'">Back to Home</button>
    </form>
</div>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: kaviruMendis
  Date: 8/2/2025
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Delete Customer - Pahana Edu Book Shop</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

  <style>
    body {
      margin: 0;
      padding: 0;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background: linear-gradient(135deg,#74ebd5,#acb6e5);
      min-height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    .card {
      background-color: #9E0B0B; /* dark red */
      padding: 30px 25px;
      border-radius: 20px;
      box-shadow: 0 8px 25px rgba(0,0,0,0.2);
      max-width: 500px;
      width: 100%;
    }

    h3 {
      text-align: center;
      color: #ffffff;
      font-family: 'Georgia', serif;
      font-weight: 700;
      margin-bottom: 25px;
    }

    .form-label {
      color: #ffffff;
      font-weight: 600;
    }

    .form-control {
      border-radius: 8px;
      padding: 8px 10px;
      border: 1px solid #fff;
      background-color: rgba(255,255,255,0.9);
    }

    .form-control:focus {
      outline: none;
      border-color: #fff;
      box-shadow: 0 0 5px rgba(255,255,255,0.5);
    }

    .btn {
      border-radius: 8px;
      font-weight: bold;
      margin-bottom: 10px;
      padding: 8px 0;
      width: 100%;
      font-size: 0.95rem;
      transition: all 0.3s ease;
    }

    .btn-success { background-color: #27ae60; border: none; color: white; }
    .btn-success:hover { background-color: #1e8449; }

    .btn-primary { background-color: #2980b9; border: none; color: white; }
    .btn-primary:hover { background-color: #1f618d; }

    .alert {
      border-radius: 10px;
      margin-top: 10px;
      font-weight: 500;
      text-align: center;
    }

    @media screen and (max-width: 500px) {
      .card { padding: 20px; margin: 10px; }
    }
  </style>
</head>
<body>

<div class="card">
  <h3>Delete Customer</h3>

  <% if (request.getAttribute("message") != null) { %>
  <div class="alert alert-info"><%= request.getAttribute("message") %></div>
  <% } %>

  <!-- Delete Form -->
  <form action="DeleteCustomer" method="post" onsubmit="return confirm('Are you sure you want to delete this customer?');">
    <div class="mb-3">
      <label for="accnoSearch" class="form-label">Enter Account No:</label>
      <input type="text" class="form-control" id="accnoSearch" name="accno" required>
    </div>
    <button type="submit" class="btn btn-success">Delete Customer</button>
    <button type="button" class="btn btn-primary" onclick="window.location.href='user.jsp'">Back to Home</button>
  </form>
</div>

</body>
</html>

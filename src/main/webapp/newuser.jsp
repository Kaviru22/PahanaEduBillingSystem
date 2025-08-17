<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create New Account</title>

    <!-- Bootstrap CSS CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        /* Body background */
        body {
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #74ebd5, #acb6e5);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        /* Card container */
        .card {
            background-color: #c0392b; /* red form background */
            padding: 20px 25px;
            border-radius: 20px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.2);
            max-width: 500px; /* card width */
            width: 100%;
        }

        /* Heading */
        h3 {
            text-align: center;
            font-weight: 700;
            color: white;
            margin-bottom: 15px;
        }

        /* Form labels */
        .form-label {
            font-weight: 600;
            color: white;
        }

        /* Form inputs */
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

        /* Buttons */
        .btn {
            border-radius: 8px;
            padding: 8px 0;
            font-weight: bold;
            transition: all 0.3s ease;
            font-size: 0.9rem;
            display: block;
            margin: 0 auto 10px auto; /* center and margin bottom */
            width: 80%; /* makes left/right padding visually */
        }

        .mb-2{
            padding-left: 10%; padding-right: 10%;
        }

        .btn-success { background-color: #27ae60; border: none; color: white; }
        .btn-success:hover { background-color: #1e8449; }

        .btn-warning { background-color: #f39c12; border: none; color: white; }
        .btn-warning:hover { background-color: #d68910; }

        .btn-primary { background-color: #2980b9; border: none; color: white; }
        .btn-primary:hover { background-color: #1f618d; }

        /* Alerts */
        .alert {
            border-radius: 10px;
            font-weight: 500;
        }

        /* Smaller spacing between form fields */
        .mb-2 { margin-bottom: 10px !important; }

        /* Responsive */
        @media screen and (max-width: 400px) {
            .card { padding: 15px 20px; margin: 10px; }
            .btn { width: 100%; } /* full width on small screens */
        }
    </style>

    <script>
        function clearForm() {
            const confirmClear = confirm("Do you want to clear the entered details?");
            if (confirmClear) {
                document.getElementById("newUserForm").reset();
                alert("Details cleared successfully.");
            }
        }

        function backToHome() {
            const confirmPage = confirm("Do you want to go back to the main page?");
            if (confirmPage) {
                document.getElementById("newUserForm").reset();
                window.location.href = "admin.jsp";
            }
        }
    </script>
</head>
<body>

<div class="card">
    <h3>Create New Account</h3>

    <%-- Success/Error messages --%>
    <% if (request.getAttribute("error") != null) { %>
    <div class="alert alert-danger mb-2" role="alert">
        <%= request.getAttribute("error") %>
    </div>
    <% } else if (request.getAttribute("success") != null) { %>
    <div class="alert alert-success mb-2" role="alert">
        <%= request.getAttribute("success") %>
    </div>
    <% } %>

    <form id="newUserForm" action="newuser" method="post">
        <div class="mb-2">
            <label for="username" class="form-label">Username:</label>
            <input type="text" class="form-control" id="username" name="username" required>
        </div>

        <div class="mb-2">
            <label for="firstname" class="form-label">First Name:</label>
            <input type="text" class="form-control" id="firstname" name="firstname" required>
        </div>

        <div class="mb-2">
            <label for="lastname" class="form-label">Last Name:</label>
            <input type="text" class="form-control" id="lastname" name="lastname" required>
        </div>

        <div class="mb-2">
            <label for="email" class="form-label">Email:</label>
            <input type="email" class="form-control" id="email" name="email" required>
        </div>

        <div class="mb-2">
            <label for="password" class="form-label">Password:</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>

        <div class="mb-2">
            <label for="confirmPassword" class="form-label">Confirm Password:</label>
            <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
        </div>

        <button type="submit" class="btn btn-success">Sign Up</button>
        <button type="button" class="btn btn-warning" onclick="clearForm()">Clear Form</button>
        <button type="button" class="btn btn-primary" onclick="backToHome()">Back to Home</button>
    </form>
</div>

</body>
</html>

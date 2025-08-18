<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add New Items</title>
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
            align-items: center;
        }

        .card {
            background-color: #7f8c8d; /* gray background */
            padding: 20px 25px;
            border-radius: 20px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.2);
            max-width: 400px;
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

        .btn-success { background-color: #27ae60; border: none; color: white; }
        .btn-success:hover { background-color: #1e8449; }

        .btn-warning { background-color: #f39c12; border: none; color: white; }
        .btn-warning:hover { background-color: #d68910; }

        .btn-primary { background-color: #2980b9; border: none; color: white; }
        .btn-primary:hover { background-color: #1f618d; }

        .alert {
            border-radius: 10px;
            font-weight: 500;
        }

        @media screen and (max-width: 450px) {
            .card { padding: 15px 20px; margin: 10px; }
            .btn { width: 100%; }
        }
    </style>

    <script>
        function clearForm() {
            const confirmClear = confirm("Do you want to clear the entered details?");
            if (confirmClear) {
                document.getElementById("newItemForm").reset();
                alert("Details cleared successfully.");
            }
        }

        function backToHome() {
            const confirmPage = confirm("Do you want to go back to the main page?");
            if (confirmPage) {
                document.getElementById("newItemForm").reset();
                window.location.href = "user.jsp";
            }
        }
    </script>
</head>
<body>

<div class="card">
    <h3>Add New Items</h3>

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

    <form id="newItemForm" action="additems" method="post">
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
        <button type="button" class="btn btn-warning w-100" onclick="clearForm()">Clear Form</button>
        <button type="button" class="btn btn-primary w-100" onclick="backToHome()">Back to Home</button>
    </form>
</div>

</body>
</html>

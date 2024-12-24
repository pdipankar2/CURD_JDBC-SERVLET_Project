<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href="from.css">
</head>
<body>


    <div class="login-container">
        <h2>Login</h2>
        <form id="login-form" action="index.jsp">
            <div class="input-group">
                <label for="user-id">User ID:</label>
                <input type="text" id="user-id" name="user-id" placeholder="Enter your User ID" required>
            </div>
            <div class="input-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" placeholder="Enter your Password" required>
            </div>
           <a href="index.jsp"> <button type="submit">Login</button></a>
            <p id="error-message" style="color: red; display: none;">Invalid User ID or Password</p>
            <a href="addCustomer.jsp">Register here </a>
        </form>
    </div>

    <script src="script.js"></script>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    <form action="login" method="post">
        
        Username: <input type="text" id="username" name="username" required><br><br>
        
        Password: <input type="password" id="password" name="password" required><br><br>
        
        <button type="submit">Login</button>
    </form>
    <p style="color: red;">${errorMessage}</p>
</body>
</html>

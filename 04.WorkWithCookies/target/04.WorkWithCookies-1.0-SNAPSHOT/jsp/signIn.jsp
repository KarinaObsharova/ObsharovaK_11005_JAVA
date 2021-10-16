<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 16.10.2021
  Time: 4:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get">
    <%--@declare id="email"--%><%--@declare id="psw"--%><h1>Sign In</h1>
    <label><b>Login</b></label>
    <input type="text" placeholder="Enter Email" name="login" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" required>
<
    <button type="submit">
        <%--<a href="/accounts">--%>Sign in</button>

    <p>You don't have an account? <a href="/registration">Registration</a>.</p>
</form>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 16.10.2021
  Time: 2:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get">
<%--@declare id="email"--%><%--@declare id="psw"--%><%--@declare id="psw-repeat"--%><h1>Register</h1>
<p>Please fill in this form to create an account.</p>

<label><b>First name</b></label>
<input type="text" placeholder="Enter First Name" name="firstName" required>

<label><b>Last name</b></label>
<input type="text" placeholder="Enter Last Name" name="lastName" required>

<label><b>Login</b></label>
<input type="text" placeholder="Enter Email" name="login" required>

<label for="psw"><b>Password</b></label>
<input type="password" placeholder="Enter Password" name="psw" required>

<button type="submit" class="registerbtn">Register</button>

<p>Already have an account? <a href="/signin">Sign in</a>.</p>
</form>

</body>
</html>

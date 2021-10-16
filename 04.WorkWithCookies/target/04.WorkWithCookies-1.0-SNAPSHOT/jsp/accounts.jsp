<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>First Name</th>
        <th>Last Name</th>
    </tr>

<c:forEach items="${users}" var="users">
    <tr>
        <td>${users.id}</td>
        <td>${users.firstName}</td>
        <td>${users.lastName}</td>
    </tr>

</c:forEach>


</table>

</body>
</html>

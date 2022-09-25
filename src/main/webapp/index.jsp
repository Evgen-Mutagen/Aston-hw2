<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h2>Users</h2>

<c:forEach var="user" items="${requestScope.users}">
    <ul>
        <li>Name: <c:out value="${user.name}"/></li>

        <li>Email: <c:out value="${user.email}"/></li>
    </ul>
</c:forEach>

<h2>New user</h2>
<form method="post" action="">

    <label><input type="text" name="name"></label>name<br>

    <label><input type="text" name="name"></label>email<br>

    <input type="submit" value="Ok" name="Ok"><br>
</form>


</body>
</html>

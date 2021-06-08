<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<h1>List</h1>
<a href="/users?action=create">Create new user</a>
<form>
    <input type="text" placeholder="Search" name="search">
    <button>Search</button>
</form>
<button><a href="/users?sort=true">Sort</a></button>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Country</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.country}"/></td>
            <td><a href="/users?action=update&id=${user.id}">Update</a></td>
            <td><a href="/users?action=delete&id=${user.id}" id="delete">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<h1>Update</h1>
<a href="/users">User list</a>
<form method="post">
  <table>
    <tr>
      <td></td>
      <td><input type="hidden" name="id" value="${user.id}"></td>
    </tr>
    <tr>
      <td>Name</td>
      <td><input type="text" name="name" value="${user.name}"></td>
    </tr>
    <tr>
      <td>Email</td>
      <td><input type="text" name="email" value="${user.email}"></td>
    </tr>
    <tr>
      <td>Country</td>
      <td><input type="text" name="country" value="${user.country}"></td>
    </tr>
    <tr>
      <td></td>
      <td><button>Update</button></td>
    </tr>
  </table>
</form>
</body>
</html>

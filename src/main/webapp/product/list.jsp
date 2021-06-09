<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<h1>List</h1>
<a href="/products?action=create">Create new product</a>
<form>
    <input type="text" placeholder="Search" name="search">
    <button>Search</button>
</form>
<table>
    <tr>
        <th>#</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Amount</th>
        <th>Color</th>
        <th>Category</th>
    </tr>
    <c:forEach items="${productList}" var="product">
        <tr>
            <td><c:out value="${product.productId}"/></td>
            <td><c:out value="${product.productName}"/></td>
            <td><c:out value="${product.price}"/></td>
            <td><c:out value="${product.amount}"/></td>
            <td><c:out value="${product.color}"/></td>
            <td><a href="/products?action=update&id=${product.productId}">Update</a></td>
            <td><a href="/products?action=delete&id=${product.productId}" id="delete">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

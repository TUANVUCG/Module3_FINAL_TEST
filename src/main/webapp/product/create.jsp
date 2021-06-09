<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<h1>Create new Product</h1>
<a href="/products">Product List</a>
<form method="post">
    <table>
        <tr>
            <td>Product Name</td>
            <td><input type="text" name="productName"></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td>Amount</td>
            <td><input type="text" name="amount"></td>
        </tr>
        <tr>
            <td>Color</td>
            <td><input type="text" name="color"></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><input type="text" name="description"></td>
        </tr>
        <tr>
            <td>Category</td>
            <td>
            <select name="category">
                <c:forEach items="${categoryList}" var="category">
                <option value="${category.id}">
                    <c:out value="${category.category}"></c:out>
                </option>
                </c:forEach>
            </select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><button>Create</button></td>
        </tr>
    </table>
</form>
</body>
</html>

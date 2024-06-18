<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset>
    <legend>Customer Information</legend>
    <form action="/customers?id=${customer.id}" method="post">
    <table>
        <tr>
            <td>ID</td>
            <td>${customer.id}</td>
        </tr>
        <tr>
            <td>Name</td>
<%--            <td>${customer.name}</td>--%>
            <td><input type="text" value="${customer.name}" name="name"></td>
        </tr>
        <tr>
            <td>Email</td>
<%--            <td>${customer.email}</td>--%>
            <td><input type="text" value="${customer.email}" name="email"></td>
        </tr>
        <tr>
            <td>Address</td>
<%--            <td>${customer.address}</td>--%>
            <td><input type="text" value="${customer.address}" name="address"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Update"></td>
        </tr>
    </table>
    </form>
</fieldset>
<a href="/customers">Back to list</a>
</body>
</html>

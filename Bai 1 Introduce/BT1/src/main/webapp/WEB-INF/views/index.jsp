<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Change Money" %></h1>
<br/>
<form action="/change" method="post">
<label>USD: </label><input type="text" placeholder="nhập usd" name="a" value="${a}">
<label>tỉ giá: </label><input type="text" placeholder="nhập tỉ giá" name="b" value="${b}">
  <input type="submit" value="chuyển">
</form>
<c:if test="${message != null}">
<label>vnd: ${message}</label>
</c:if>
</body>
</html>
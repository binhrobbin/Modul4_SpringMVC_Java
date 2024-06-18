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
<label>tiếng anh: </label><input type="text" placeholder="nhập từ" name="a" value="${a}">
  <input type="submit" value="chuyển">
</form>
<c:if test="${message != null}">
<label>tiếng việt: ${message}</label>
</c:if>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Calculator</h1>
<form method="post" action="result">
    <input type="text" name="left" >
    <input type="text" name="right" ><br>
    <input type="submit" name="btn" value="Addition(+)">
    <input type="submit" name="btn" value="Subtraction(-)">
    <input type="submit" name="btn" value="Multiplication(x)">
    <input type="submit" name="btn" value="Division(/)">
</form>
<c:if test="${result != null}">
<label>Result ${btn} : ${result}</label>
</c:if>
<c:if test="${result == null}">
    <label>${btn}</label>
</c:if>
</body>
</html>
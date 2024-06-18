<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form method="post" action="save">
    <input type="checkbox" name="check" value="Lettuce">Lettuce
    <input type="checkbox" name="check" value="Tomato">Tomato
    <input type="checkbox" name="check" value="Mustard">Mustard
    <input type="checkbox" name="check" value="Sprouts">Sprouts<br>
    <input type="submit" value="Save">
</form>
<label>${Lettuce} ${Tomato} ${Mustard} ${Sprouts}</label>
</body>
</html>
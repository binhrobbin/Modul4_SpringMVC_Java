<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Create Student</h1>

    <form action="/update" method="post">
        <table>
            <tr>
                <th>Languages:</th>
                <td>
                    <select name="language">
                        <c:forEach items="${languageList}" var="lang">
                            <c:if test="${email.languages == lang}">
                            <option selected>${lang}</option>
                            </c:if>
                            <c:if test="${email.languages != lang}">
                                <option >${lang}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Page Size:</th>
                <td>
                    <select name="pageSize">
                        <c:forEach items="${sizeList}" var="size">
                            <c:if test="${email.pageSize == size}">
                                <option selected>${size}</option>
                            </c:if>
                            <c:if test="${email.pageSize != size}">
                                <option >${size}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Spams filter:</th>
                <td>
                    <c:if test="${email.spamsFilter == 'on'}">
                    <input type="checkbox" name="checkbox" checked/>Enable spams filter
                    </c:if>
                    <c:if test="${email.spamsFilter == 'off'}">
                        <input type="checkbox" name="checkbox"  />Enable spams filter
                    </c:if>
                </td>
            </tr>
            <tr>
                <th>Signature</th>
                <td>
                    <textarea name="textarea"  rows="4" >${email.signature}</textarea>
                </td>
            </tr>
            <tr>
                <th></th>
                <td >
                    <input type="submit" name="sub" value="Update">
                    <input type="submit" name="sub" value="Cancel">
                </td>
            </tr>
        </table>
    </form>
<p>${message}</p>
</body>
</html>

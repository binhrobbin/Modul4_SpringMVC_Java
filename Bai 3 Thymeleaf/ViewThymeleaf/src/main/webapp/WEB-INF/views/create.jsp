<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: TrungDC
  Date: 10/17/2022
  Time: 8:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form modelAttribute="student" action="/student/create" method="post">
        <table>
            <tr>
                <td>ID</td>
                <td>
                    <form:input path="id" />
                </td>
            </tr>
            <tr>
                <td>Name</td>
                <td>
                    <form:input path="name" />
                </td>
            </tr>
            <tr>
                <td>Gender</td>
                <td>
                   <form:radiobutton path="gender" value="1" label="Male" />
                   <form:radiobutton path="gender" value="0" label="Female" />
                   <form:radiobutton path="gender" value="2" label="LGBT" />
                </td>
            </tr>
            <tr>
                <td>Languages</td>
                <td>
                    <form:checkboxes path="languages" items="${languageList}" />
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit">Create</button>
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
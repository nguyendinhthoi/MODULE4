<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/14/2023
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        .result{
            color: green;
        }
        .message{
            color: red;
        }
    </style>
</head>
<body>
<form action="/dictionary/searchForm" method="post">
    <fieldset>
        <legend>
            Dictionary Search
        </legend>
        <label for="en">English</label>
        <input type="text" name="en" id="en" placeholder="home,love,boo">
        <input type="submit">
        <h3>Result :</h3>
        <span class="result">${vn}</span>
        <c:if test="${message !=null}">
            <span class="message">${message}</span>
        </c:if>
    </fieldset>
</form>
</body>
</html>

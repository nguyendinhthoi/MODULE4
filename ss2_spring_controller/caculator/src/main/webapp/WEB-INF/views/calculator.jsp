<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/15/2023
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <style>
        .result{
            color: green;
        }
        .result1{
            color: red;
        }
    </style>
</head>
<body>
<form action="calculator/calculate" method="post">
    <fieldset>
        <legend>Calculator</legend>
    <label for="n1">Number 1</label>
    <input type="number" name="num1" id="n1">
    <label for="n2">Number 2</label>
    <input type="number" name="num2" id="n2">
    <input type="submit" name="cal" value="Addition(+)">
    <input type="submit" name="cal" value="Subtraction(-)">
    <input type="submit" name="cal" value="Multiplication(X)">
    <input type="submit" name="cal" value="Division(/)">
        <hr>
        Result : <span class="result">${result}</span> <span class="result1">${result1}</span>
    </fieldset>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/15/2023
  Time: 10:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .mess{
            color: green;
        }
    </style>
</head>
<body>
<form method="post" action="/condiments/save">
    <fieldset>
        <legend>
            <h3>Sandwich Condiments</h3>
        </legend>
        <label for="lettuce">Lettuce</label>
        <input type="checkbox" name="condiment" id="lettuce" value="lettuce">
        <label for="tomato">Tomato</label>
        <input type="checkbox" name="condiment" id="tomato" value="tomato">
        <label for="mustard">Mustard</label>
        <input type="checkbox" name="condiment" id="mustard" value="mustard">
        <label for="sprouts">Sprouts</label>
        <input type="checkbox" name="condiment" id="sprouts" value="sprouts">
        <hr>
        <p class="mess">${mess}</p>
        <input type="submit" value="submit">
    </fieldset>
</form>
</body>
</html>

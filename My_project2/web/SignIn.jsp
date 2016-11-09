<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10.11.2016
  Time: 0:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@ include file="static/css/style.css" %>
        li {
            list-style-type: none;
        }
    </style>
</head>
<body>
<div class = "cloud">
    <a href = "/" class="My_button">Registration</a>
    <a href = "/Controller?command=SignIn" class="My_button">SignIn</a>
    <a href = "http://vk.com/pet1us">
        <img class = "Vk_photo" src="/static/media/vk.png" />
    </a>
</div>
<div class = "FormLocate">
    <form class = "SignIn" action="Controller?command=SignIn" method="POST">
        <td>
            <p>Enter login: <input type="text" name="login">
            <p>Enter first name: <input type="text" name="firstname"></p>
            <p>Enter second name: <input type="text" name="secondname"></p>
            <p>Enter mail <input type="text" name="mail"></p>
            <p>Password: <input type="text" name="password1"></p>
            <p>Confirm password <input type="text" name="password1"></p>
        </td>
            <input type="submit" value="Отправить" />
    </form>
</div>
</body>
</html>

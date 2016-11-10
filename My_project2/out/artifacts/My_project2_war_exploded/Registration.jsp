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
    <a href = "/Controller?command=Registration" class="My_button">Registration</a>
    <a href = "/Controller?command=SignIn" class="My_button">SignIn</a>
    <a href = "http://vk.com/pet1us">
        <img class = "Vk_photo" src="/static/media/vk.png" />
    </a>
</div>

<div class = "FormLocate">
    <form class = "Registration" action="Controller?command=Registration" method="POST">
        <div class =  "FormPosition">
            <div class = "FieldArea">
                <input class = "FormsLocate" type="text" name="login">
                <p class = "FieldLocate">Login:</p>
            </div>
            <div class = "FieldArea">
                <input  class = "FormsLocate" type="text" name="firstname">
                <p class = "FieldLocate">First name:</p>
            </div>
            <div class = "FieldArea">
                <input  class = "FormsLocate" type="text" name="secondname">
                <p class = "FieldLocate">Second name:</p>
            </div>

            <div class = "FieldArea">
                <input class = "FormsLocate" type="text" name="mail">
                <p class = "FieldLocate">Mail </p>
            </div>
            <div class = "FieldArea">
                <input class = "FormsLocate" type="text" name="password1">
                <p class = "FieldLocate">Password:</p>
            </div>

            <div class = "FieldArea">
                <input class = "FormsLocate" type="text" name="password1">
                <p class = "FieldLocate">Confirm password </p>
            </div>
        </div>
        <div class = "ButtonPosition">
            <input class = "SubmitButton" type="submit" value="Registration" />
        </div>
    </form>
</div>
</body>
</html>

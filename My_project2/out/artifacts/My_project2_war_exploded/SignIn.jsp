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
    <form class = "SignIn" action="Controller?command=SignIn" method="POST">
        <div class =  "FormPosition">
                <div class = "FieldArea">
                    <input  class = "FormsLocate" type="text" name="Login">
                    <p class = "FieldLocate">Login:</p>
                </div>

                <div class = "FieldArea">
                    <input class = "FormsLocate" type="text" name="password">
                    <p class = "FieldLocate">Password</p>
                </div>
        </div>
        <div class = "ButtonPosition2">
            <input class = "SubmitButton2" type="submit" value="Sign In" />
        </div>
    </form>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10.11.2016
  Time: 0:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@ include file="../css/style.css" %>
        li {
            list-style-type: none;
        }
    </style>
    <script type="text/javascript" src="../js/validations.js"></script>
</head>
<body>
<div class = "cloud">
    <a href = "/Controller?command=Registration&reg=false" class="My_button">Registration</a>
    <a href = "http://vk.com/pet1us">
        <img class = "Vk_photo" src="/static/media/vk.png" />
    </a>
</div>
<c:choose>
    <c:when test = "${message != null}">
        <script>alert('${message}')</script>
    </c:when>
</c:choose>
<div class = "FormLocate">
    <form class = "SignIn" action="Controller?command=SignIn&auto=true" method="POST" onsubmit="return validation_signIn();">
        <div class =  "FormPosition">
                <div class = "FieldArea">
                    <input  class = "FormsLocate" type="text" name="login" required/>
                    <p class = "FieldLocate">Login:</p>
                </div>

                <div class = "FieldArea">
                    <input class = "FormsLocate" type="password" name="password1" required/>
                    <p class = "FieldLocate">Password</p>
                </div>
        </div>
        <div class = "ButtonPosition2">
            <input class = "SubmitButton2" type="submit" value="SignIn" />
        </div>
    </form>
</div>
</body>
</html>

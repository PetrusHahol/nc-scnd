<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 06.11.2016
  Time: 3:33
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
</head>
<body>

<div class = "cloud">
    {%
        <a href = "/Controller?command=Registration&reg=false" class="My_button">Registration</a>
        <a href = "/Controller?command=SignIn&auto=false" class="My_button">SignIn</a>
    <a href = "http://vk.com/pet1us">
         <img class = "Vk_photo" src="/static/media/vk.png" />
    </a>
</div>
</body>
</html>
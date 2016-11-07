<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 06.11.2016
  Time: 3:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
    <%@ include file="static/css/style.css" %>

    </style>
</head>
<body>

<div class = "cloud">
    <a href = "/" class="My_button">SignOut</a>
    <a href = "/" class="My_button">SignIn</a>
    <a href = "http://vk.com/pet1us">
         <img class = "Vk_photo" src="/static/media/vk.png" />
    </a>
</div>
<div class = "data">
    <c:forEach  items= "${from}" var="num">
        {num}
    </c:forEach>

    <c:forEach var="num" items= "${to}" >
        <p>${num}</p>
    </c:forEach>

    <c:forEach var="num" items= "${date}" >
        <p>${num}</p>
    </c:forEach>
</div>
</body>
</html>

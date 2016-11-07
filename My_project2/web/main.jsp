<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 06.11.2016
  Time: 3:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <a href = "/" class="My_button">SignOut</a>
    <a href = "/" class="My_button">SignIn</a>
    <a href = "http://vk.com/pet1us">
         <img class = "Vk_photo" src="/static/media/vk.png" />
    </a>
</div>
<div class = "data">
    <ul>
        <li>
            <c:forEach  var="k" begin="0" end="${size}">
                <div class = "container">
                        <ul class = "table">
                            <li>
                                <p>
                                    <c:out value="${from[k]}"/>
                                </p>
                                <p>
                                    <c:out value="${to[k]}"/>
                                </p>
                                <p>
                                    <c:out value="${date[k]}"/>
                                </p>
                            </li>
                        </ul>
                </div>
            </c:forEach>
        </li>
    </ul>
</div>
</body>
</html>
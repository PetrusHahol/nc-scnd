<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 13.11.2016
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <script type="text/javascript">

        function clicker()
        {
           alert("You'r profile was deleted ");
           this.href = "Controller/command=delete";
        }

    </script>

</head>
<body>

<div class = "cloud">

    <a href = "/Controller?command=LogOut" class="My_button">LogOut</a>
    <a href = "http://vk.com/pet1us">
        <img class = "Vk_photo" src="/static/media/vk.png" />
    </a>
    <p  class="user">${login}</p>
    <p  class="name">${firstname}</p>
    <p  class="name">${secondname}</p>

</div>
<div class = "data">
    <a class = "TextData">FLIGHTS</a>
    <a class ="TextData">BRIGADES</a>
    <a class = "TextData">EMPLOYEES</a>
</div>
<div class = "footer">
    <p onclick="clicker()">
        <a href = "/Controller?command=deleteUser" class= "name"> DELETE ACCOUNT </a>
    </p>
</div>
</body>
</html>
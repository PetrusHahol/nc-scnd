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
        <%@ include file="../css/style.css" %>
        li {
            list-style-type: none;
        }
    </style>
</head>
<body>
<div class = "cloud">

    <a href = "/Controller?command=LogOut" class="My_button">LogOut</a>
    <a href = "http://vk.com/pet1us">
        <img class = "Vk_photo" src="/static/media/vk.png" />
    </a>
    <a href = "/Controller?command=main" class="user">${login}</a>
    <p  class="name">${firstname}</p>
    <p  class="name">${secondname}</p>

</div>

<div class = "FormLocate">
    <form class = "Registration" action="Controller?command=AddEmployee&role=${role}&reg=true" method="POST">
        <div class =  "FormPosition">
            <div class = "FieldArea">
                <input class = "FormsLocate" type="text" name="name">
                <p class = "FieldLocate">Name</p>
            </div>
            <div class = "FieldArea">
                <input  class = "FormsLocate" type="text" name="age">
                <p class = "FieldLocate">Age</p>
            </div>
            <div class = "FieldArea">
                <input  class = "FormsLocate" type="text" name="height">
                <p class = "FieldLocate">Height</p>
            </div>

            <div class = "FieldArea">
                <input class = "FormsLocate" type="text" name="experience">
                <p class = "FieldLocate">Experience </p>
            </div>

            <div class = "FieldArea">
                <input class = "FormsLocate" type="password" name="${info}">
                <p class = "FieldLocate">${info}</p>
            </div>

            <div class = "FieldArea">
                <input class = "FormsLocate" type="password" name="passportdata">
                <p class = "FieldLocate">Passport Data</p>
            </div>

        </div>
        <div class = "ButtonPosition">
            <input class = "SubmitButton" type="submit" value="Add employee" />
        </div>
    </form>
</div>
</body>
</html>

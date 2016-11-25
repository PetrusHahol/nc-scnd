<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10.11.2016
  Time: 0:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
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
    <form class = "Registration" action="Controller?command=AddBrigade&reg=true" method="POST" >
        <div class =  "FormPosition">
            <div class = "FieldArea">
                <input class = "FormsLocate" type="number" name="id_first_pilot" required/>
                <p class = "FieldLocate">Id first pilot</p>
            </div>
            <div class = "FieldArea">
                <input  class = "FormsLocate" type="number" name="id_second_pilot" required/>
                <p class = "FieldLocate">Id second pilot</p>
            </div>
            <div class = "FieldArea">
                <input  class = "FormsLocate" type="number" name="id_stewardess" required/>
                <p class = "FieldLocate">Id stewardess</p>
            </div>

            <div class = "FieldArea">
                <input class = "FormsLocate" type="number" name="id_navigator" required/>
                <p class = "FieldLocate">Id navigator </p>
            </div>

            <div class = "FieldArea">
                <input class = "FormsLocate" type="number" name="id_radioman" required/>
                <p class = "FieldLocate">Id radioman </p>
            </div>

            <div class = "FieldArea">
                <input class = "FormsLocate" type="text" name="id_flight" required/>
                <p class = "FieldLocate">Id flight</p>
            </div>

        </div>
        <div class = "ButtonPosition">
            <input class = "SubmitButton" type="submit" value="Add brigade" />
        </div>
    </form>
</div>
</body>
</html>

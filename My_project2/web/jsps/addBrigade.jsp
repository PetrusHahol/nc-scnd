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

<div class = "FormLocate2">
    <form class = "Registration_brigade" action="Controller?command=AddBrigade&reg=true" method="POST" >

                        <ul class="dropdown">
                            <div class = "FieldArea2">
                                    <li class="dropdown-top">
                                        <p class="dropdown-top">Enter first pilot</p>
                                        <ul class="dropdown-inside">
                                        <c:forEach  var="k" begin="0" end="${pilot.size()-1}">
                                                 <li><div class = "flight"> NAME: <c:out value="${pilot[k].getName()}"> </c:out>
                                                 AGE: <c:out value="${pilot[k].getAge()}"></c:out>
                                                 EXPERIENCE: <c:out value="${pilot[k].getExperience()}"></c:out>
                                                 HEIGHT: <c:out value="${pilot[k].getHeight()}"></c:out>
                                                 PASSPORTDATA: <c:out value="${pilot[k].getPassportData()}"></c:out>
                                                 MILEAGE: <c:out value="${pilot[k].getMileage()}"></c:out>
                                                 <input type="checkbox" id = "id_first_pilot" name="id_first_pilot" required/>
                                                 </div>
                                                 </li>

                                        </c:forEach>
                                        </ul>
                                    </li>
                                    <li class="dropdown-top">
                                        <p class="dropdown-top">Enter second pilot</p>
                                        <ul class="dropdown-inside">
                                            <c:forEach  var="k" begin="0" end="${pilot.size()-1}">
                                                <li><div class = "flight"> NAME: <c:out value="${pilot[k].getName()}"> </c:out>
                                                    AGE: <c:out value="${pilot[k].getAge()}"></c:out>
                                                    EXPERIENCE: <c:out value="${pilot[k].getExperience()}"></c:out>
                                                    HEIGHT: <c:out value="${pilot[k].getHeight()}"></c:out>
                                                    PASSPORTDATA: <c:out value="${pilot[k].getPassportData()}"></c:out>
                                                    MILEAGE: <c:out value="${pilot[k].getMileage()}"></c:out>
                                                    <input type="checkbox" id = "id_second_pilot" name="id_second_pilot" required/>
                                                </div>
                                                </li>

                                            </c:forEach>
                                        </ul>
                                    </li>
                                <li class="dropdown-top">
                                    <p class="dropdown-top">Enter stewardess</p>
                                    <ul class="dropdown-inside">
                                        <c:forEach  var="k" begin="0" end="${stewardess.size()-1}">
                                            <li><div class = "flight"> NAME: <c:out value="${stewardess[k].getName()}"> </c:out>
                                                AGE: <c:out value="${stewardess[k].getAge()}"></c:out>
                                                EXPERIENCE: <c:out value="${stewardess[k].getExperience()}"></c:out>
                                                HEIGHT: <c:out value="${stewardess[k].getHeight()}"></c:out>
                                                PASSPORTDATA: <c:out value="${stewardess[k].getPassportData()}"></c:out>
                                                LENGTH WAIST: <c:out value="${stewardess[k].getLengthWaist()}"></c:out>
                                                <input type="checkbox" id = "id_stewardess" name="id_stewardess" required/>
                                            </div>
                                            </li>

                                        </c:forEach>
                                    </ul>
                                </li>
                                <li class="dropdown-top">
                                    <p class="dropdown-top">Enter navigator</p>
                                    <ul class="dropdown-inside">
                                        <c:forEach  var="k" begin="0" end="${navigator.size()-1}">
                                            <li><div class = "flight"> NAME: <c:out value="${navigator[k].getName()}"> </c:out>
                                                AGE: <c:out value="${navigator[k].getAge()}"></c:out>
                                                EXPERIENCE: <c:out value="${navigator[k].getExperience()}"></c:out>
                                                HEIGHT: <c:out value="${navigator[k].getHeight()}"></c:out>
                                                PASSPORTDATA: <c:out value="${navigator[k].getPassportData()}"></c:out>
                                                CATEGORY: <c:out value="${navigator[k].getCategory()}"></c:out>
                                                <input type="checkbox" id = "id_navigator" name="id_navigator" required/>
                                            </div>
                                            </li>

                                        </c:forEach>
                                    </ul>
                                </li>
                                <li class="dropdown-top">
                                    <p class="dropdown-top">Enter radioman</p>
                                    <ul class="dropdown-inside">
                                        <c:forEach  var="k" begin="0" end="${radioman.size()-1}">
                                            <li><div class = "flight"> NAME: <c:out value="${radioman[k].getName()}"> </c:out>
                                                AGE: <c:out value="${radioman[k].getAge()}"></c:out>
                                                EXPERIENCE: <c:out value="${radioman[k].getExperience()}"></c:out>
                                                HEIGHT: <c:out value="${radioman[k].getHeight()}"></c:out>
                                                PASSPORTDATA: <c:out value="${radioman[k].getPassportData()}"></c:out>
                                                COUNT FOREIGN LANGUAGE: <c:out value="${radioman[k].getCountForeignLanguage()}"></c:out>
                                                <input type="checkbox" id = "id_radioman" name="id_radioman" required/>
                                            </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </li>
                                <li class="dropdown-top">
                                    <p class="dropdown-top">Enter flight</p>
                                    <ul class="dropdown-inside">
                                        <c:forEach  var="k" begin="0" end="${radioman.size()-1}">
                                            <li><div class = "flight"> NAME: <c:out value="${radioman[k].getName()}"> </c:out>
                                                AGE: <c:out value="${radioman[k].getAge()}"></c:out>
                                                EXPERIENCE: <c:out value="${radioman[k].getExperience()}"></c:out>
                                                HEIGHT: <c:out value="${radioman[k].getHeight()}"></c:out>
                                                PASSPORTDATA: <c:out value="${radioman[k].getPassportData()}"></c:out>
                                                COUNT FOREIGN LANGUAGE: <c:out value="${radioman[k].getCountForeignLanguage()}"></c:out>
                                                <input type="checkbox" id = "id_radioman" name="id_radioman" required/>
                                            </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </li>
                            </div>
                        </ul>


        <div class = "ButtonPosition">
            <input class = "SubmitButton" type="submit" value="Add brigade" />
        </div>
    </form>
</div>
</body>
</html>

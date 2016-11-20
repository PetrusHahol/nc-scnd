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
    <title>Title
    </title>
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
<body link="black"
      alink="#00008b"
      vlink ="black">
<div class = "cloud">
    <a href = "/Controller?command=LogOut" class="My_button">LogOut
    </a>
    <a href = "http://vk.com/pet1us">
        <img class = "Vk_photo" src="/static/media/vk.png" />
    </a>
    <p  class="user">${login}
    </p>
    <p  class="name">${firstname}
    </p>
    <p  class="name">${secondname}
    </p>
</div>
<div class = "data">
    <a href = "/Controller?command=main&group=flights" class = "TextData">FLIGHTS
    </a>
    <a href = "/Controller?command=main&group=brigades" class ="TextData">BRIGADES
    </a>
    <a href = "/Controller?command=main&group=employees" class = "TextData">EMPLOYEES
    </a>
</div>
<c:choose>
    <c:when test="${group == 'flights'}">
        <c:choose>
            <c:when test = "${priority == 'admin'}">
                <a href = "/Controller?command=addflight&reg=false">
                    <img class = "Vk_photo" src="/static/media/add_data.png" />
                </a>
            </c:when>
        </c:choose>
        <div class = "data2">
            <td>
                <div class = "container">
                    <div class = "missing">
                        <tl class = main_table>
                        </tl>
                    </div>
                    <div class = "missing">
                        <tl class = main_table>
                            <h1>From
                            </h1>
                        </tl>
                    </div>
                    <div class = "missing">
                        <tl class = main_table>
                            <h1>To
                            </h1>
                        </tl>
                    </div>
                    <div class = "missing">
                        <tl class = main_table>
                            <h1>Date
                            </h1>
                        </tl>
                    </div>
                </div>
                <c:forEach  var="k" begin="0" end="${size}">
                    <div class = "container">
                        <div class = "missing">
                            <tl class = flight>
                                <c:choose>
                                    <c:when test = "${priority == 'admin'}">
                                        <a href ="/Controller?command=DeleteFlight&from=${from[k]}&to=${to[k]}&flight_date=${flight_date[k]}">
                                            <img class = "Vk_photo" src="/static/media/Delete.png"/>
                                        </a>
                                    </c:when>
                                </c:choose>
                                <h1>Flight №
                                    <c:out value = "${k+1}"/>
                                </h1>
                            </tl>
                        </div>
                        <div class = "missing">
                            <tl class = "table">
                                <p>
                                    <c:out value="${from[k]}"/>
                                </p>
                            </tl>
                        </div>
                        <div class = "missing">
                            <tl  class = table>
                                <p>
                                    <c:out value="${to[k]}"/>
                                </p>
                            </tl>
                        </div>
                        <div class = "missing">
                            <tl  class = table>
                                <p>
                                    <c:out value="${flight_date[k]}"/>
                                </p>
                            </tl>
                        </div>
                    </div>
                </c:forEach>
            </td>
        </div>
    </c:when>
    <c:when test="${group == 'employees'}">
        <div class = "data2">
            <td>
                <div class = "container">
                    <div class = "missing">
                        <tl class = main_table>
                            <h1>STEWARDESS
                            </h1>
                        </tl>
                    </div>
                    <div class = "missing">
                        <tl class = main_table>
                            <h1>PILOT
                            </h1>
                        </tl>
                    </div>
                    <div class = "missing">
                        <tl class = main_table>
                            <h1>RADIOMAN
                            </h1>
                        </tl>
                    </div>
                    <div class = "missing">
                        <tl class = main_table>
                            <h1>NAVIGATOR
                            </h1>
                        </tl>
                    </div>
                </div>

                <div class = "column_data">
                    <c:forEach  var="k" begin="0" end="${stewardess_size}">
                        <div class = "missing_employee">
                            <tl class = "main_table_employee">
                                <p>INDEX: <c:out value="${k+1}"/></p>
                                <p>AGE: <c:out value="${stewardess[k].getAge()}"/> years old</p>
                                <p>HEIGHT:<c:out value="${stewardess[k].getHeight()}"/> sm</p>
                                <p>EXPERIENCE:<c:out value="${stewardess[k].getExperience()}"/> years</p>
                                <p>LENGTH WAIST:<c:out value="${stewardess[k].getLengthWaist()}"/> sm</>
                                <p>PASSPORT DATA:<c:out value="${stewardess[k].getPassportData()}"/></p>
                            </tl>
                        </div>
                    </c:forEach>
                </div>

                <div class = "column_data">
                    <c:forEach  var="k" begin="0" end="${pilots_size}">
                        <div class = "missing_employee">
                            <tl class = "main_table_employee">
                                <p>INDEX: <c:out value="${k+1}"/></p>
                                <p>AGE: <c:out value="${pilots[k].getAge()}"/> years old</p>
                                <p>HEIGHT:<c:out value="${pilots[k].getHeight()}"/> sm</p>
                                <p>EXPERIENCE:<c:out value="${pilots[k].getExperience()}"/> years</p>
                                <p>MILEAGE:<c:out value="${pilots[k].getMileage()}"/> km</>
                                <p>PASSPORT DATA:<c:out value="${pilots[k].getPassportData()}"/></p>
                            </tl>
                        </div>
                    </c:forEach>
                </div>
                <div class = "column_data">
                    <c:forEach  var="k" begin="0" end="${radiomans_size}">
                        <div class = "missing_employee">
                            <tl class = "main_table_employee">
                                <p>INDEX: <c:out value="${k+1}"/></p>
                                <p>AGE: <c:out value="${radiomans[k].getAge()}"/> years old</p>
                                <p>HEIGHT:<c:out value="${radiomans[k].getHeight()}"/> sm</p>
                                <p>EXPERIENCE:<c:out value="${radiomans[k].getExperience()}"/> years</p>
                                <p>COUNT LANGUAGES:<c:out value="${radiomans[k].getCountForeignLanguage()}"/> </p>
                                <p>PASSPORT DATA:<c:out value="${radiomans[k].getPassportData()}"/></p>
                            </tl>
                        </div>
                    </c:forEach>
                </div>
                <div class = "column_data">
                    <c:forEach  var="k" begin="0" end="${navigators_size}">
                        <div class = "missing_employee">
                            <tl class = "main_table_employee">
                                <p>INDEX: <c:out value="${k+1}"/></p>
                                <p>AGE: <c:out value="${navigators[k].getAge()}"/> years old</p>
                                <p>HEIGHT:<c:out value="${navigators[k].getHeight()}"/> sm</p>
                                <p>EXPERIENCE:<c:out value="${navigators[k].getExperience()}"/> years</p>
                                <p>CATEGORY:<c:out value="${navigators[k].getCategory()}"/></p>
                                <p>PASSPORT DATA:<c:out value="${navigators[k].getPassportData()}"/></p>
                            </tl>
                        </div>
                    </c:forEach>
                </div>

            </td>
        </div>
    </c:when>
</c:choose>

<div class = "footer">
    <p onclick="clicker()">
        <a href = "/Controller?command=deleteUser" class= "name"> DELETE ACCOUNT
        </a>
    </p>
</div>
</body>

</html>

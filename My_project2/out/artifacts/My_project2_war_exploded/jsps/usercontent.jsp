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
                                        <a href ="/Controller?command=DeleteFlight&id=${id[k]}">
                                            <img class = "Vk_photo" src="/static/media/Delete.png"/>
                                        </a>
                                    </c:when>
                                </c:choose>
                                <h1>Flight №
                                    <c:out value = "${k+1}"/>
                                    (id=<c:out value = "${id[k]}"/>)
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
                            <c:choose>
                                <c:when test = "${priority == 'dispatcher'}">
                                    <a href = "/Controller?command=addEmployee&role=stewardess&reg=false">
                                        <img class = "Vk_photo" src="/static/media/add_data.png" />
                                    </a>
                                </c:when>
                            </c:choose>
                            <h1>STEWARDESS
                            </h1>
                        </tl>
                    </div>
                    <div class = "missing">
                        <tl class = main_table>
                            <c:choose>
                                <c:when test = "${priority == 'dispatcher'}">
                                    <a href = "/Controller?command=addEmployee&role=pilot&reg=false">
                                        <img class = "Vk_photo" src="/static/media/add_data.png" />
                                    </a>
                                </c:when>
                            </c:choose>
                            <h1>PILOT
                            </h1>
                        </tl>
                    </div>
                    <div class = "missing">
                        <tl class = main_table>
                            <c:choose>
                                <c:when test = "${priority == 'dispatcher'}">
                                    <a href = "/Controller?command=addEmployee&role=radioman&reg=false">
                                        <img class = "Vk_photo" src="/static/media/add_data.png" />
                                    </a>
                                </c:when>
                            </c:choose>
                            <h1>RADIOMAN
                            </h1>
                        </tl>
                    </div>
                    <div class = "missing">
                        <tl class = main_table>
                            <c:choose>
                                <c:when test = "${priority == 'dispatcher'}">
                                    <a href = "/Controller?command=addEmployee&role=navigator&reg=false">
                                        <img class = "Vk_photo" src="/static/media/add_data.png" />
                                    </a>
                                </c:when>
                            </c:choose>
                            <h1>NAVIGATOR
                            </h1>
                        </tl>
                    </div>
                </div>

                <div class = "column_data">
                    <c:forEach  var="k" begin="0" end="${stewardess.size()-1}">
                        <div class = "missing_employee">

                            <tl class = "main_table_employee">
                                <c:choose>
                                    <c:when test = "${priority == 'dispatcher'}">
                                        <a href = "/Controller?command=deleteEmployee&role=stewardess&id=${stewardess[k].getId()}">
                                            <img class = "delete_style" src="/static/media/Delete.png" />
                                        </a>
                                    </c:when>
                                </c:choose>
                                <p>INDEX: <c:out value="${k+1}"/>(id=<c:out value="${stewardess[k].getId()}"/> )</p>
                                <p>NAME  <c:out value="${stewardess[k].getName()}"/></p>
                                <p>AGE: <c:out value="${stewardess[k].getAge()}"/> years old</p>
                                <p>HEIGHT:<c:out value="${stewardess[k].getHeight()}"/> sm</p>
                                <p>EXPERIENCE:<c:out value="${stewardess[k].getExperience()}"/> years</p>
                                <p>LENGTH WAIST:<c:out value="${stewardess[k].getLengthWaist()}"/> sm</>
                                <c:choose>
                                <c:when test = "${priority == 'dispatcher'}">
                                <p>PASSPORT DATA:<c:out value="${stewardess[k].getPassportData()}"/></p>
                                </c:when>
                                </c:choose>

                            </tl>
                        </div>
                    </c:forEach>
                </div>

                <div class = "column_data">
                    <c:forEach  var="k" begin="0" end="${pilot.size()-1}">
                        <div class = "missing_employee">
                            <tl class = "main_table_employee">
                                <c:choose>
                                    <c:when test = "${priority == 'dispatcher'}">
                                        <a href = "/Controller?command=deleteEmployee&role=pilot&id=${pilot[k].getId()}">
                                            <img class = "delete_style" src="/static/media/Delete.png" />
                                        </a>
                                    </c:when>
                                </c:choose>
                                <p>INDEX: <c:out value="${k+1}"/>(id=<c:out value="${pilot[k].getId()}"/> )</p>
                                <p>NAME  <c:out value="${pilot[k].getName()}"/></p>
                                <p>AGE: <c:out value="${pilots[k].getAge()}"/> years old</p>
                                <p>HEIGHT:<c:out value="${pilot[k].getHeight()}"/> sm</p>
                                <p>EXPERIENCE:<c:out value="${pilot[k].getExperience()}"/> years</p>
                                <p>MILEAGE:<c:out value="${pilot[k].getMileage()}"/> km</>
                                <c:choose>
                                <c:when test = "${priority == 'dispatcher'}">
                                <p>PASSPORT DATA:<c:out value="${pilot[k].getPassportData()}"/></p>
                                </c:when>
                                </c:choose>
                            </tl>
                        </div>
                    </c:forEach>
                </div>
                <div class = "column_data">
                    <c:forEach  var="k" begin="0" end="${radioman.size()-1}">
                        <div class = "missing_employee">
                            <tl class = "main_table_employee">
                                <c:choose>
                                    <c:when test = "${priority == 'dispatcher'}">
                                        <a href = "/Controller?command=deleteEmployee&role=radioman&id=${radioman[k].getId()}">
                                            <img class = "delete_style" src="/static/media/Delete.png" />
                                        </a>
                                    </c:when>
                                </c:choose>
                                <p>INDEX: <c:out value="${k+1}"/>(id=<c:out value="${radioman[k].getId()}"/> )</p>
                                <p>NAME  <c:out value="${radioman[k].getName()}"/></p>
                                <p>AGE: <c:out value="${radioman[k].getAge()}"/> years old</p>
                                <p>HEIGHT:<c:out value="${radioman[k].getHeight()}"/> sm</p>
                                <p>EXPERIENCE:<c:out value="${radioman[k].getExperience()}"/> years</p>
                                <p>COUNT LANGUAGES:<c:out value="${radioman[k].getCountForeignLanguage()}"/> </p>
                                <c:choose>
                                <c:when test = "${priority == 'dispatcher'}">
                                <p>PASSPORT DATA:<c:out value="${radioman[k].getPassportData()}"/></p>
                                </c:when>
                                </c:choose>
                            </tl>
                        </div>
                    </c:forEach>
                </div>
                <div class = "column_data">
                    <c:forEach  var="k" begin="0" end="${navigator.size()-1}">
                        <div class = "missing_employee">
                            <tl class = "main_table_employee">
                                <c:choose>
                                    <c:when test = "${priority == 'dispatcher'}">

                                        <a href = "/Controller?command=deleteEmployee&role=navigator&id=${navigator[k].getId()}">
                                            <img class = "delete_style" src="/static/media/Delete.png" />
                                        </a>

                                    </c:when>
                                </c:choose>
                                <p>INDEX: <c:out value="${k+1}"/>(id=<c:out value="${navigator[k].getId()}"/> )</p>
                                <p>NAME  <c:out value="${navigator[k].getName()}"/></p>
                                <p>AGE: <c:out value="${navigator[k].getAge()}"/> years old</p>
                                <p>HEIGHT:<c:out value="${navigator[k].getHeight()}"/> sm</p>
                                <p>EXPERIENCE:<c:out value="${navigator[k].getExperience()}"/> years</p>
                                <p>CATEGORY:<c:out value="${navigator[k].getCategory()}"/></p>
                                <c:choose>
                                <c:when test = "${priority == 'dispatcher'}">
                                <p>PASSPORT DATA:<c:out value="${navigator[k].getPassportData()}"/></p>
                                </c:when>
                                </c:choose>
                            </tl>
                        </div>
                    </c:forEach>
                </div>

            </td>
        </div>
    </c:when>
    <c:when test="${group == 'brigades'}">
        <c:choose>
            <c:when test = "${priority == 'dispatcher'}">
                <a href = "/Controller?command=addBrigade&reg=false">
                    <img class = "Vk_photo" src="/static/media/add_data.png" />
                </a>
            </c:when>
        </c:choose>
        <div class = "data2">
            <tr>

                <div class = "container">

                    <c:forEach  var="k" begin="0" end="${brigades.size()-1}">
                        <div class = "missing_employee">
                                <tl class = "main_table_employee">
                                    <c:choose>
                                        <c:when test = "${priority == 'dispatcher'}">
                                            <a href = "/Controller?command=deleteBrigade&id=${brigades[k].getId()}">
                                                <img class = "VK_photo" src="/static/media/Delete.png" />
                                            </a>

                                        </c:when>
                                    </c:choose>
                                    <div class = "six_parts">
                                        <p>NAVIGATOR</p>
                                        <p>NAME  <c:out value="${brigades[k].getNavigator().getName()}"/></p>
                                        <p>AGE: <c:out value="${brigades[k].getNavigator().getAge()}"/> years old</p>
                                        <p>HEIGHT:<c:out value="${brigades[k].getNavigator().getHeight()}"/> sm</p>
                                        <p>EXPERIENCE:<c:out value="${brigades[k].getNavigator().getExperience()}"/> years</p>
                                        <p>CATEGORY:<c:out value="${brigades[k].getNavigator().getCategory()}"/></p>
                                        <c:choose>
                                            <c:when test = "${priority == 'dispatcher'}">
                                                <p>PASSPORT DATA:<c:out value="${brigades[k].getNavigator().getPassportData()}"/></p>
                                            </c:when>
                                        </c:choose>
                                    </div>
                                    <div class = "six_parts">
                                        <p>FIRST PILOT</p>
                                        <p>NAME  <c:out value="${brigades[k].getFirstPilot().getName()}"/></p>
                                        <p>AGE: <c:out value="${brigades[k].getFirstPilot().getAge()}"/> years old</p>
                                        <p>HEIGHT:<c:out value="${brigades[k].getFirstPilot().getHeight()}"/> sm</p>
                                        <p>EXPERIENCE:<c:out value="${brigades[k].getFirstPilot().getExperience()}"/> years</p>
                                        <p>MILEAGE:<c:out value="${brigades[k].getFirstPilot().getMileage()}"/> km</>
                                        <c:choose>
                                            <c:when test = "${priority == 'dispatcher'}">
                                                <p>PASSPORT DATA:<c:out value="${brigades[k].getFirstPilot().getPassportData()}"/></p>
                                            </c:when>
                                        </c:choose>
                                    </div>
                                    <div class = "six_parts">
                                        <p>SECOND PILOT</p>
                                        <p>NAME  <c:out value="${brigades[k].getSecondPilot().getName()}"/></p>
                                        <p>AGE: <c:out value="${brigades[k].getSecondPilot().getAge()}"/> years old</p>
                                        <p>HEIGHT:<c:out value="${brigades[k].getSecondPilot().getHeight()}"/> sm</p>
                                        <p>EXPERIENCE:<c:out value="${brigades[k].getSecondPilot().getExperience()}"/> years</p>
                                        <p>MILEAGE:<c:out value="${brigades[k].getSecondPilot().getMileage()}"/> km</>
                                        <c:choose>
                                            <c:when test = "${priority == 'dispatcher'}">
                                                <p>PASSPORT DATA:<c:out value="${brigades[k].getSecondPilot().getPassportData()}"/></p>
                                            </c:when>
                                        </c:choose>
                                    </div>
                                    <div class = "six_parts">
                                        <p>RADIOMAN</p>
                                        <p>NAME  <c:out value="${brigades[k].getRadioman().getName()}"/></p>
                                        <p>AGE: <c:out value="${brigades[k].getRadioman().getAge()}"/> years old</p>
                                        <p>HEIGHT:<c:out value="${brigades[k].getRadioman().getHeight()}"/> sm</p>
                                        <p>EXPERIENCE:<c:out value="${brigades[k].getRadioman().getExperience()}"/> years</p>
                                        <p>COUNT LANGUAGES:<c:out value="${brigades[k].getRadioman().getCountForeignLanguage()}"/> </p>
                                        <c:choose>
                                            <c:when test = "${priority == 'dispatcher'}">
                                                <p>PASSPORT DATA:<c:out value="${brigades[k].getRadioman().getPassportData()}"/></p>
                                            </c:when>
                                        </c:choose>
                                    </div>
                                    <div class = "six_parts">
                                        <p>STEWARDESS</p>
                                        <p>NAME  <c:out value="${brigades[k].getStewardess().getName()}"/></p>
                                        <p>AGE: <c:out value="${brigades[k].getStewardess().getAge()}"/> years old</p>
                                        <p>HEIGHT:<c:out value="${brigades[k].getStewardess().getHeight()}"/> sm</p>
                                        <p>EXPERIENCE:<c:out value="${brigades[k].getStewardess().getExperience()}"/> years</p>
                                        <p>LENGTH WAIST:<c:out value="${brigades[k].getStewardess().getLengthWaist()}"/> sm</>
                                        <c:choose>
                                            <c:when test = "${priority == 'dispatcher'}">
                                                <p>PASSPORT DATA:<c:out value="${brigades[k].getStewardess().getPassportData()}"/></p>
                                            </c:when>
                                        </c:choose>
                                    </div>

                                    <div class = "six_parts">
                                        <p>FLIGHT</p>
                                        <p>FROM  <c:out value="${brigades[k].getFlight().getFrom()}"/></p>
                                        <p>TO: <c:out value="${brigades[k].getFlight().getTo()}"/></p>
                                        <p>DATE: <c:out value="${brigades[k].getFlight().getDate().getTime()}"/></p>
                                    </div>

                                </tl>

                            </div>
                        </div>
                    </c:forEach>
                </div>
            </tr>
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

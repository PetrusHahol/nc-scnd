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
    <%@ include file="../css/style.css" %>
    li {
        list-style-type: none;
    }
    </style>
</head>
<body>

<div class = "cloud">
        <a href = "/Controller?command=Registration&reg=false" class="My_button">Registration</a>
        <a href = "/Controller?command=SignIn" class="My_button">SignIn</a>
    <a href = "http://vk.com/pet1us">
         <img class = "Vk_photo" src="/static/media/vk.png" />
    </a>
</div>
<div class = "data">
    <td>
        <div class = "container">
            <div class = "missing">
                <tl class = main_table>

                </tl>
            </div>
            <div class = "missing">
                <tl class = main_table>
                    <h1>From</h1>
                </tl>
            </div>
            <div class = "missing">
                <tl class = main_table>
                    <h1>To</h1>
                </tl>
            </div>
            <div class = "missing">
                <tl class = main_table>
                    <h1>Date</h1>
                </tl>
            </div>
        </div>


            <c:forEach  var="k" begin="0" end="${size}">
                <div class = "container">
                    <div class = "missing">
                        <tl class = flight>
                            <h1>Flight №<c:out value = "${k+1}"/> </h1>
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
                                    <c:out value="${date[k]}"/>
                                </p>
                        </tl>
                    </div>
                </div>
            </c:forEach>
    </td>
</div>
</body>
</html>
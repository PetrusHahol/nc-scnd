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
<body link="black"
      alink="#00008b"
      vlink ="black">

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
    <a href = "/Controller?command=main&group=flights" class = "TextData">FLIGHTS</a>
    <a href = "/Controller?command=main&group=brigade" class ="TextData">BRIGADES</a>
    <a href = "/Controller?command=main&group=employee" class = "TextData">EMPLOYEES</a>
</div>
<c:choose>
<c:when test="${group == 'flights'}">
    <div class = "data2">
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
</c:when>
</c:choose>
<div class = "footer">
    <p onclick="clicker()">
        <a href = "/Controller?command=deleteUser" class= "name"> DELETE ACCOUNT </a>
    </p>
</div>
</body>
</html>
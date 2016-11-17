<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 06.11.2016
  Time: 3:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:forward page="/Controller?command=main" ></jsp:forward>
<html>
  <head>
    <title>Indeex</title>
  </head>
  <body>
  </body>
</html>

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
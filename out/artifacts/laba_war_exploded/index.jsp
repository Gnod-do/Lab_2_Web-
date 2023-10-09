<%--
  Created by IntelliJ IDEA.
  User: anhdo
  Date: 10/5/2023
  Time: 12:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="lab2.models.TableMaker" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>web_laba_2</title>
    <link rel="stylesheet" href="main.css">
    <link rel="icon" href="images/favicon.ico" type="image/x-icon">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
  </head>
  <body onload="drawCanvas()">
  <script src="canvas.js"></script>
  <script src="main.js"></script>
  <table class="main-table" align="center">
    <th colspan="2">
      <p title="Gnod here!" class="main-table">
        Do Van Dong, P3225, v 861205
      </p>
    </th>
    <tr>
      <td>
        <div id="masloo">
          <canvas id="canvas"></canvas></div>
      </td>
      <td>
        <p class="main-table" id="enter-text">Enter values.</p>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <div class="main-table">
          <p class="variable">X=
            <input type="button" name="x11" id="x_11" value="-2" autocomplete="off" onclick="setX(x_11.value, `x_11`)">
            <input type="button" name="x11" id="x_12" value="-1.5" autocomplete="off" onclick="setX(x_12.value, `x_12`)">
            <input type="button" name="x11" id="x_13" value="-1" autocomplete="off" onclick="setX(x_13.value, `x_13`)">
            <input type="button" name="x11" id="x_14" value="-0.5" autocomplete="off" onclick="setX(x_14.value, `x_14`)">
            <input type="button" name="x11" id="x_15" value="-0" autocomplete="off" onclick="setX(x_15.value, `x_15`)">
            <input type="button" name="x11" id="x_16" value="-0.5" autocomplete="off" onclick="setX(x_16.value, `x_16`)">
            <input type="button" name="x11" id="x_17" value="-1" autocomplete="off" onclick="setX(x_17.value, `x_17`)">
            <input type="button" name="x11" id="x_18" value="-1.5" autocomplete="off" onclick="setX(x_18.value, `x_18`)">
            <input type="button" name="x11" id="x_19" value="-2" autocomplete="off" onclick="setX(x_19.value, `x_19`)">
            <br></p>
          <form id="theform" method="post" action="controllerServlet">
            <input type="hidden" autocomplete="off" name="X_f" id="x" value="0">
            <p class="variable">Y=<input type="text" placeholder=" " id="y" name="Y_f"><br></p>
            <p class="variable">R=<select id="select" name="R_f">
              <option>1</option>
              <option>1.5</option>
              <option>2</option>
              <option>2.5</option>
              <option>3</option>
            </select></p>
            <div class="check-error"></div>
            <button id="button" type="submit">✔️</button>
          </form>
        </div>
      </td>
    </tr>
    <div class="error-message">
      <% String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) {
          out.println("<p class='error'>" + errorMessage + "</p>");
        } %>
    </div>
    <tr>
      <td colspan="2">
        <%=TableMaker.createTable(getServletConfig().getServletContext().getAttribute("answerList"))%>
      </td>
    </tr>
  </table>
  </body>
</html>

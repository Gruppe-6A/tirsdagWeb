<%--
  Created by IntelliJ IDEA.
  User: nbh
  Date: 06/04/2021
  Time: 10.52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1> velkommen du er nu logget ind !</h1>

${requestScope.msg}

Dit navn er: ${sessionScope.brugernavn}
<br>
Dit session id er: ${sessionScope.sessionid}

<h1>Her kan du tilføje emner til din huskeseddel</h1>

Du har nu tilføjet ${sessionScope.emneListeSize} emner

<form action="TilfoejEmne" method="post">
    <label for="emne">Emne:</label><br>
    <input type="text" id="emne" name="emne" value=""><br>
    <input type="submit" value="Tilføj emne">
</form>

<br>

<form action="SletEmne" method="post">
    <label for="SletEmne">Emne:</label><br>
    <input type="text" id="SletEmne" name="emne" value=""><br>
    <input type="submit" value="Slet emne">
</form>

<%--<%=request.getAttribute("brugernavn")%>   // scriptlets  nogo--%>

<c:forEach items="${sessionScope.emneListe}" var="element">
    ${element}
    <br>
</c:forEach>

<form action="TilfoejEmne" method="get">
    <input type="submit" value="Gå til oversigt">
</form>

</body>
</html>

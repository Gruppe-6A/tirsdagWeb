<%--
  Created by IntelliJ IDEA.
  User: nicolaimartini
  Date: 07/04/2021
  Time: 11.55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    Her kan du se alle emnerne folk har tilføjet:

    <c:forEach items="${applicationScope.emneListeContext}" var="element">
        <br>
        ${element}
    </c:forEach>
</head>
<body>

</body>
</html>

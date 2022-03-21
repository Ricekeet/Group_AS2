<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/21/2022
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<head>
    <title>Query Part 2, 3, 4</title>
</head>
<body>
<h1>Query Part 2</h1>
<br>
<form action="Part2Controller" method="POST">
    <input type="text" hidden name="pageName" value="part2">
    <input type="submit" name="btnSubmit" id="btnSubmit" value="Get Information">
</form>

<h2>Part 2</h2>
<p>Select ID 10 from Geographic Area</p>
<table>
    <tr>
        <th>Code</th>
        <th>Level</th>
        <th>Name</th>
    </tr>

    <%--Display ID 10--%>
    <c:forEach var="item" items="${requestScope.id10}">
        <tr>
            <td>${item.code}</td>
            <td>${item.level}</td>
            <td>${item.name}</td>
        </tr>
    </c:forEach>
</table>

<h2>Part 3</h2>
<p>Select All Level 2 area</p>
<table>
    <tr>
        <th>Code</th>
        <th>Level</th>
        <th>Name</th>
    </tr>

    <%--Display ID 10--%>
    <c:forEach var="item" items="${requestScope.level2}">
        <tr>
            <td>${item.code}</td>
            <td>${item.level}</td>
            <td>${item.name}</td>
        </tr>
    </c:forEach>
</table>

<h2>Part 4</h2>
<p>Find All income Create Query</p>
<table>
    <tr>
        <th>ID</th>
        <th>Description</th>
    </tr>

    <%--FindAllIncome--%>
    <c:forEach var="item" items="${requestScope.findAllIncome}">
        <tr>
            <td>${item.id}</td>
            <td>${item.description}</td>
        </tr>
    </c:forEach>
</table>
<footer>
    Page created by: Allen wu, Keith Sialana, Chinar Shakari
</footer>
</body>
</html>

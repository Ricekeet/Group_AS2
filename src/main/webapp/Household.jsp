<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 3/21/2022
  Time: 7:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<head>
    <title>Household - Q5</title>
</head>
<body>
<h5>Total number of records on the 2016 census that meet the following requirements:
  <br>
  • One couple census family without other persons in the household
  • 2 or more members in the household
  • At least 1 earner in the household
  • Total income between $80,000 and $89,999
</h5>
<br>
<form action="HouseholdController" method="POST">
  <input type="text" hidden name="pageName" value="household">
  <input type="submit" name="btnSubmit" id="btnSubmit" value="Get Query Result">
</form>
<h1>${requestScope.household}</h1>
</body>
</html>

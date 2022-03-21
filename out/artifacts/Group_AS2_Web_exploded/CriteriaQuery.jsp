<%--
  Created by IntelliJ IDEA.
  User: Keith
  Date: 3/20/2022
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Criteria Query</title>
</head>
<body>
    <h1>Criteria Query</h1>
    <br>
    <form action="CriteriaController" method="post">
        <input type="text" hidden name="pageName" value="criteria">
        <input type="submit" name="btnSubmit" id="btnSubmit" value="Get Information">
    </form>

    <h2>Multiselect</h2>
    <p>This Multiselect gets the top 10 records with the code, level, and name from Geographic Areas Table.</p>
    <table>
        <tr>
            <th>Code</th>
            <th>Level</th>
            <th>Name</th>
        </tr>

<%--        Loops through items from the multiselect query--%>
        <c:forEach var="item" items="${requestScope.multiselect}">
            <tr>
                <td>${item.code}</td>
                <td>${item.level}</td>
                <td>${item.name}</td>
            </tr>
        </c:forEach>
    </table>

    <h2>Combined Aged Information</h2>
    <table>
        <tr>
            <th>Age ID</th>
            <th>Combined</th>
        </tr>

<%--        Loops through items from the top 20 combined age query--%>
        <c:forEach var="item" items="${requestScope.combined}">
            <tr>
                <td>${item.ageID}</td>
                <td>${item.combined}</td>
            </tr>
        </c:forEach>
    </table>

    <h2>Geographic Area named Peterborough</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>code</th>
            <th>Level</th>
            <th>Name</th>
            <th>Alternative Code</th>
        </tr>

<%--        Gets the single item from the Peterborough query--%>
        <c:forEach var="item" items="${requestScope.peterborough}">
            <tr>
                <td>${item.geographicAreaID}</td>
                <td>${item.code}</td>
                <td>${item.level}</td>
                <td>${item.name}</td>
                <td>${item.alternativeCode}</td>
            </tr>
        </c:forEach>
    </table>

    <h2>Total Income between id 10 to 20</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Description</th>
        </tr>

        <%--        Gets all the Total Incomes between id 10 to 20--%>
        <c:forEach var="item" items="${requestScope.totalIncomes}">
            <tr>
                <td>${item.id}</td>
                <td></td>

            </tr>
        </c:forEach>
    </table>

    <h2>Group by Clause</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Description</th>
        </tr>

        <%--        Displays all Geographic Ares grouped by Level--%>
        <c:forEach var="item" items="${requestScope.geographicAreasByLevel}">
            <tr>
                <td>${item.geographicAreaID}</td>
                <td>${item.code}</td>
                <td>${item.level}</td>
                <td>${item.name}</td>
                <td>${item.alternativeCode}</td>
                <td></td>

            </tr>
        </c:forEach>
    </table>

</body>
</html>

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
    <form action="GeographicalAreaController" method="post">
        <input type="text" hidden name="pageName" value="criteria">
        <input type="submit" name="btnSubmit" id="btnSubmit" value="Get Information">
    </form>
    <h2>Multiselect</h2>
    <p>This Multiselect gets the top 10 records with the code, level, and name from Geographic Areas Table.</p>
<%--    TODO: Display Multiselect--%>

    <h2>Combined Aged Information</h2>
<%--    TODO: Get top 20 Age Information order by Desc--%>

    <h2>Geographic Area named Peterborough</h2>
<%--    TODO: Get Geographic Area named Peterborough--%>

    <h2>Total Income between id 10 to 20</h2>
<%--    TODO: Get Total Incomes between id 10 and 20--%>

    <h2>Group by Clause</h2>
<%--    TODO: Display Geographic Area group by Level--%>

</body>
</html>

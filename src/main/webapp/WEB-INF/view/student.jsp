<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>

<h1>The table element</h1>

<table>
    <tr>
        <th>Month</th>
        <th>Savings</th>
    </tr>

    <c:forEach var="o" items = "${a}">
        <tr>
            <td>${o.id}</td>
            <td>${o.fullName}</td>
        </tr>
    </c:forEach>



</table>

</body>
</html>
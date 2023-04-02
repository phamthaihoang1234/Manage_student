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

<h1>Student List</h1>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
    </tr>

    <c:forEach var="o" items = "${a}">
        <tr>
            <td>${o.id}</td>
            <td><a href="/studentdetail?sid=${o.id}">${o.fullName}</a></td>
        </tr>
    </c:forEach>



</table>

</body>
</html>
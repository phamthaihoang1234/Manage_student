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

<h1>Student Detail</h1>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>gender</th>
        <th>email</th>
        <th>phone number</th>
        <th>person id</th>
    </tr>

    <tr>
        <th>${s.id}</th>
        <th>${s.fullName}</th>

        <c:if test="${gender =true}">
            <th>nam</th>
        </c:if>
        <c:if test="${gender =false}">
            <th>nữ</th>
        </c:if>

        <th>${i.email}</th>
        <th>${i.phoneNumber}</th>
        <th>${i.personId}</th>
    </tr>>




</table>



</body>
</html>
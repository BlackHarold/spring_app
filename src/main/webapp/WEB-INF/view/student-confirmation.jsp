<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<!DOCTYPE>
<html>
<head>
    <title>Student Confirmation</title></head>
<body>
The student is confirmed: ${student.firstName} ${student.lastName}
<br>
<br>
Form country: ${student.country}
<br>
<br>
Favorite language: ${student.favoriteLanguage}
<br>
<br>
Operation Systems:
<ul>
    <c:forEach var="temp" items="${student.checkBox}">
        <li>${temp}</li>
    </c:forEach>
</ul>

</body>
</html>
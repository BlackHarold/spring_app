<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>

<!DOCTYPE>
<html>
<head><title>Student Form</title></head>
<body>
<%--@elvariable id="student" type="home.blackharold.entity.Student"--%>
<form:form action="processForm" modelAttribute="student">

    First name:
    <form:input path="firstName"/>

    <br>
    <br>
    Last name:
    <form:input path="lastName"/>

    <br>
    <br>
    Country:
    <form:select path="country">
        <form:options items="${student.countries}"/>
    </form:select>

    <br>
    <br>
    Favorite programming language:
    <br>
<%--    Java <form:radiobutton path="favoriteLanguage" value="Java"/>--%>
<%--    C# <form:radiobutton path="favoriteLanguage" value="C#"/>--%>
<%--    Python <form:radiobutton path="favoriteLanguage" value="Python"/>--%>
<%--    PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>--%>
    <form:radiobuttons path="favoriteLanguage" items="${student.buttonsList}"/>

    <br>
    <br>
    Operating Systems:
    <br>
    <form:checkboxes path="checkBox" items="${student.checkBoxes}"/>
    <br>
    <br>
    <input type="submit" value="Отправить">

</form:form>
</body>
</html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>

<!DOCTYPE>
<HTML>
<head>
    <title>Customer Registration Form</title>
    <style>.error {
        color: red
    }

    .err {
        color: rebeccapurple;
    }
    </style>
</head>
<body>
<i>Fill out the form.</i>
<br>
<%--@elvariable id="customer" type="home.blackharold.entity.Customer"--%>
<form:form action="processForm" modelAttribute="customer">
    First name: <form:input path="firstName"/>
    <br>
    <br>
    Last name: <form:input path="lastName"/>
    <form:errors path="lastName" cssClass="error"/>
    <br>
    <br>
    Free passes: <form:input path="freePasses"/>
    <form:errors path="freePasses" cssClass="err"/>
    <br>
    <br>
    Post code: <form:input path="postalCode"/>
    <form:errors path="postalCode" cssClass="err"/>
    <br>
    <br>
    Course code: <form:input path="courseCode"/>
    <form:errors path="courseCode" cssClass="error"/>
    <br>
    <br>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</HTML>
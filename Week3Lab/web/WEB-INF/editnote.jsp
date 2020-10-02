<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note - Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <form method="post" name = "form" action="note">
            <h3>Title: <input type="text" name="title" value="${note.title}"></h3>
            <h3>Contents: <textarea name="contents">${note.contents}</textarea></h3>
            <input type="submit" value="Save">
        </form>
    </body>
</html>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Note - Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <h3>Title: ${note.title} </h3> 
        <h3> Contents:</h3> 
        <h3>
            ${note.contents}
        </h3>    
        <br>       
            <a href="note?modify">Edit</a>
    </body>
</html>
<%-- 
    Document   : add
    Created on : 13 abr. 2023, 15:02:58
    Author     : joas2
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar marca</title>
</head>
<body>
    <h1>Agregar marca</h1>
    <form method="post" action="AddServlet">
        <label>ID:</label>
        <input type="text" name="id" required><br>
        <label>Nombre:</label>
        <input type="text" name="nombre" required><br>
        <input type="submit" value="Agregar">
    </form>
</body>
</html>

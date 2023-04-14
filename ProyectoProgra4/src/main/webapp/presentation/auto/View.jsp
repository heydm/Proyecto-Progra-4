<%-- 
    Document   : View
    Created on : 14 abr. 2023, 16:55:00
    Author     : Diana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Agregar marca</title>
</head>
<body>
    <h1>Agregar Auto</h1>
    <form action="presentation/administrador/modelo/ add" method="post" enctype="multipart/form-data">
        
        <label>Placa:</label>
        <input type="text" name="id" required><br>
        <label>Marca:</label>
        
        <select name="example">
            <option value="A">A</option>
            <! –– Aqui va un for––>
        </select>
            </form>

</body>
</html>

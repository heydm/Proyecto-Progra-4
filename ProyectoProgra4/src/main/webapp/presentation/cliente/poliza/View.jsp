
<%@page import="com.progra.guia.logic.Poliza"%>
<%@page import="com.progra.guia.presentation.cliente.poliza.Model"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
    Model model = (Model) request.getAttribute("model");

    Poliza poliza = model.getCurrent();

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <%@ include file="/presentation/Head.jsp" %>
 <title>Agregar Poliza</title> 
</head>
<body >
<%@ include file="/presentation/Header.jsp" %>

     <h1>Agregar Auto</h1>
    <form action="presentation/administrador/modelo/ add" method="post" enctype="multipart/form-data">
        
        <label>Placa:</label>
        <input type="text" name="id" required><br>
        <label>Marca:</label>
        
        <select name="example">
            <%
                 if ($result->num_rows > 0) {
          while($row = $result->fetch_assoc()) {
            echo '<option value="' . $row["id"] . '">' . $row["marca"] . '</option>';
          }
        }
            %>
        </select>
            </form>
  
     <%@ include file="/presentation/Footer.jsp" %>
</body>
</html>









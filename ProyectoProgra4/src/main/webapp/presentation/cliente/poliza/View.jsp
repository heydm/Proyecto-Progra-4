
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
 <title>Poliza</title> 
</head>
<body >
<%@ include file="/presentation/Header.jsp" %>

    <div class="panel" style="width:50%;">
        <div class="fila encabezado">Poliza</div>
        <div class="fila">
               <div class="etiqueta">Número</div>
              <div class="campo"><%=poliza.getNumero()%></div>
        </div>
        <div class="fila">

          <div class="etiqueta">Placa</div>
          <div class="campo"><%=poliza.getPlaca()%></div>
        </div>
        <div class="fila">
          <div class="etiqueta">Fecha</div>
          <div class="campo"><%=poliza.getFecha()%></div>
        </div>

    </div>     
     <%@ include file="/presentation/Footer.jsp" %>
</body>
</html>









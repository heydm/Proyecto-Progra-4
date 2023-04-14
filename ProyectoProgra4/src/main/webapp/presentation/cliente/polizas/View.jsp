
<%@page import="com.progra.guia.logic.Poliza"%>
<%@page import="com.progra.guia.presentation.cliente.polizas.Model"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
    Model model = (Model) request.getAttribute("model");
    List<Poliza> polizas = model.getPolizas();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <%@ include file="/presentation/Head.jsp" %>
 <title>Cuentas</title> 
</head>
<body >
    <%@ include file="/presentation/Header.jsp" %>

    <div style="width:50%;margin:auto;">
        <h1>Listado de Polizas del Cliente</h1>     
    
        <table>
            <thead>
                <tr> <td>Numero</td> <td>Placa</td>  <td>Fecha</td> </tr>
            </thead>
            <tbody>
                        <% for(Poliza polizas){%>
                <tr> <td><a href="presentation/cliente/poliza/show?numeroFld=<%=c.getNumero()%>"><%=c.getNumero()%> </td>  
                        <td><%=c.getPlaca()%></td><td><%=c.getFecha()%></td></tr> 
<!--                         <tr> <td><form action="/Guia/presentation/cliente/poliza/show">
                                    <input type="hidden" name="numeroFld" value="<%=c.getNumero()%>"> 
                                    <button class="link-button"> <%=c.getNumero()%> </button> </form> </td>  
                            <td><%=c.getPlaca()%></td><td><%=c.getFecha()%></td></tr>  -->              
                        <%}%>
            </tbody>
        </table>          
    </div> 
     <%@ include file="/presentation/Footer.jsp" %>
</body>
</html>









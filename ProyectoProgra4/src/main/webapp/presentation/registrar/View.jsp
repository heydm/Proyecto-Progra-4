<%-- 
    Document   : View
    Created on : 23 abr. 2023, 16:14:57
    Author     : Usuario
--%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.progra.guia.presentation.registrar.Model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
        <title>JSP Page</title>
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>
         <% Model model= (Model) request.getAttribute("model"); %>
    <% Map<String,String> errores = (Map<String,String>) request.getAttribute("errores"); %>
    <% Map<String,String[]> form = (errores==null)?this.getForm(model):request.getParameterMap();%>
        
         <form name="form" action="presentation/registrar/registrar" method="post" > 
            <div class="panel" style="width:30%;">
                <div class="fila encabezado">Ingrese sus Datos Personales</div>
                <div class="fila">
                       <div class="etiqueta">Cedula</div>
                      <div class="campo"><input class="<%=erroneo("cedulaFld",errores)%>" placeholder="cedula del usuario" type="text" name="cedulaFld" value="<%=form.get("cedulaFld")[0]%>" title="<%=title("cedulaFld",errores)%>"></div></div>
                
                <div class="fila">
                  <div class="etiqueta">Nombre</div>
                  <div class="campo"><input class="<%=erroneo("nombreFld",errores)%>" placeholder="nombre del usuario" type="text" name="nombreFld" value="<%=form.get("nombreFld")[0]%>" title="<%=title("nombreFld",errores)%>"></div>
                </div>
                <div class="fila">
                  <div class="etiqueta">telefono</div>
                  <div class="campo"><input class="<%=erroneo("telefonoFld",errores)%>" placeholder="telefono del usuario" type="text" name="telefonoFld" value="<%=form.get("telefonoFld")[0]%>" title="<%=title("telefonoFld",errores)%>"></div>
                </div>
                 <div class="fila">
                  <div class="etiqueta">correo</div>
                  <div class="campo"><input class="<%=erroneo("correoFld",errores)%>" placeholder="correo del usuario" type="text" name="correoFld" value="<%=form.get("correoFld")[0]%>" title="<%=title("correoFld",errores)%>"></div>
                </div>
                
               
                
                <div class="fila encabezado"><button  style="margin-bottom: 15px">Ingresar</button> </div>
            </div>
            
        </form>
    
    
        
        <%@ include file="/presentation/Footer.jsp" %> 
    </body>
</html>
<%!
    private String erroneo(String campo, Map<String,String> errores){
      if ( (errores!=null) && (errores.get(campo)!=null) )
        return "is-invalid";
      else
        return "";
    }

    private String title(String campo, Map<String,String> errores){
      if ( (errores!=null) && (errores.get(campo)!=null) )
        return errores.get(campo);
      else
        return "";
    }

    private Map<String,String[]> getForm(Model model){
       Map<String,String[]> values = new HashMap<>();
       values.put("cedulaFld", new String[]{model.getCurrent().getCedula()});
       values.put("nombreFld", new String[]{model.getCurrent().getNombre()});
        values.put("telefonoFld", new String[]{model.getCurrent().getTelefono()});
        values.put("correoFld", new String[]{model.getCurrent().getCorreo()});
       
       return values;
    }
    
%> 
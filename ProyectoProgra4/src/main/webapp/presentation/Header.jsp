<%@page import="com.progra.guia.logic.Usuario"%>
<% Usuario usuario=  (Usuario) session.getAttribute("usuario");  %>

<header>
    <div class="logo">
         <img src="images/carroLogo.png" style=" height: 100px;">
        <span>Seguros DEJ</span>
       
    </div> 
    <div class="menu">
        <ul> 
              <li>
                <a href="presentation/Index.jsp">Inicio</a>
              </li>
                        <% if (usuario!=null){ %>
                <li>
                  <a href="presentation/cliente/cuentas/show">Polizas</a>
                  <ul>  <!--submenu --> </ul>
                </li>                        
                <li >
                  <a  href="presentation/cliente/datos/show">Usuario:  <%=usuario.getCedula()%></a>
                  <ul>  <!--submenu --> </ul>
                </li> 
                <li >
                  <a  href="presentation/login/logout">Cerrar sesión</a>
                  <ul>  <!--submenu --> </ul>
                </li>                
                        <% } %>
                        <% if (usuario==null){%>
                <li>
                  <a href="presentation/login/show">Iniciar sesión</a>
                </li>
                
                        <% }%>             
            </ul>
    </div>
  </header>          


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.progra.guia.presentation.registrar;

import com.progra.guia.logic.Service;
import com.progra.guia.logic.Tarjeta;
import com.progra.guia.logic.Usuario;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/presentation/registrar/show", "/presentation/register/registrar", "/presentation/registrar/logout"})
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       request.setAttribute("model", new Model()); 
        
        String viewUrl="";
        switch(request.getServletPath()){
            case "/presentation/registrar/show":
                viewUrl=this.show(request);
                break;              
            case "/presentation/registrar/registrar":
                viewUrl=this.registrar(request);
                break;            
            case "/presentation/registrar/logout":
                viewUrl=this.logout(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward( request, response); 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
 private String registrar(HttpServletRequest request) { 
        try{
            Map<String,String> errores =  this.validar(request);
            if(errores.isEmpty()){
                this.updateModel(request);          
                return this.registrarAction(request);
            }
            else{
                request.setAttribute("errores", errores);
                return "/presentation/login/View.jsp"; 
            }            
        }
        catch(Exception e){
            return "/presentation/Error.jsp";             
        }         
    }
    
    Map<String,String> validar(HttpServletRequest request){
        Map<String,String> errores = new HashMap<>();
        
        if (request.getParameter("nombreFld").isEmpty()){
            errores.put("nombreFld","Nombre requerido");
        }
        if (request.getParameter("telefonoFld").isEmpty()){
            errores.put("telefonoFld","telefono requerido");
        }
         if (request.getParameter("correoFld").isEmpty()){
            errores.put("correoFld","correo requerido");
        }
        if (request.getParameter("correoFld").isEmpty()){
            errores.put("correoFld","correo requerido");
        }
           
        if (request.getParameter("numTarjetaFld").isEmpty()){
            errores.put("numTarjetaFld","correo requerido");
        }
        return errores;
    }
        public String registrarAction(HttpServletRequest request) throws SQLException, Exception {
        Model model= (Model) request.getAttribute("model");
        Service  service = Service.instance();
        HttpSession session = request.getSession(true);
        try {
            String viewUrl="";
            if(service.UsuarioExistente(model.getCurrent().getCedula(),model.getCurrent().getUsuario().getClave()) == false){
                service.agregarCliente(model.getCurrent());
                service.agregarUsuario(model.getCurrent().getUsuario());
                viewUrl="/presentation/login/show";
            }
            else{
                viewUrl="";
            }
            return viewUrl;
        } catch (Exception ex) {
            Map<String,String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("id","Existe un Cliente Registrado con ese Usuario");
            return "/presentation/registrar/View.jsp"; 
        }        
    }
    void updateModel(HttpServletRequest request){
       Model model= (Model) request.getAttribute("model");
       
        model.getCurrent().setCedula(request.getParameter("cedulaFld"));
        model.getCurrent().setNombre(request.getParameter("nombreFld"));
        model.getCurrent().setTelefono(request.getParameter("telefonoFld"));
        model.getCurrent().setCorreo(request.getParameter("correoFld"));
       Tarjeta tarjeta = new Tarjeta(request.getParameter("tarjetaFld"), request.getParameter("fechaVencimiento"));
        model.getCurrent().setTarjeta(tarjeta);
        Usuario usuario = new Usuario (request.getParameter("cedulaFld"),request.getParameter("claveFld"), 1);
        model.getCurrent().setUsuario(usuario);
        model.getCurrent().setPolizas(null);

   }
   

    public String logout(HttpServletRequest request){
        return this.logoutAction(request);
    }
    
    public String logoutAction(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        session.removeAttribute("usuario");
        session.invalidate();
        return "/presentation/index.jsp"; 
        
    }

    public String show(HttpServletRequest request){
        return this.showAction(request);
    }
        
    public String showAction(HttpServletRequest request){
        Model model= (Model) request.getAttribute("model");
        model.getCurrent().setCedula("");
        model.getCurrent().setNombre("");
        model.getCurrent().setTelefono("");
        model.getCurrent().setCorreo("");
        model.getCurrent().setTarjeta(null);
        model.getCurrent().setUsuario(null);
        model.getCurrent().setPolizas(null);
        
        return "/presentation/registrar/View.jsp"; 
    }   
}

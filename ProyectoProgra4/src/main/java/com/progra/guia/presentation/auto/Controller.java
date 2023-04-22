/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.guia.presentation.auto;

import com.progra.guia.logic.Cliente;
import com.progra.guia.logic.Service;
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


@WebServlet(name = "ClienteAutoController", urlPatterns = {"/presentation/auto/show","/presentation/auto/update"})
public class Controller extends HttpServlet {
    



    
    
    
    private String update(HttpServletRequest request) { 
        try{
            Model model = (Model) request.getAttribute("model");
            HttpSession session = request.getSession(true);
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            model.getCurrent().setCedula(usuario.getCedula());
            Map<String,String> errores =  this.validar(request);
            if(errores.isEmpty()){
                this.updateModel(request);          
                return this.updateAction(request);
            }
            else{
                request.setAttribute("errores", errores);
                return "/presentation/cliente/datos/View.jsp"; 
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
        return errores;
    }
    
    void updateModel(HttpServletRequest request){
       Model model= (Model) request.getAttribute("model");
       
        model.getCurrent().setNombre(request.getParameter("nombreFld"));
   }

        
    public String updateAction(HttpServletRequest request) {
        Model model= (Model) request.getAttribute("model");
        Service  service = Service.instance();
        HttpSession session = request.getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        model.getCurrent().setCedula(usuario.getCedula());
        model.getCurrent().setUsuario(usuario);
        try {
            service.clienteUpdate(model.getCurrent());
            return "/presentation/Index.jsp";
        } catch (Exception ex) {
            Map<String,String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("nombreFld","cedula o nombreincorrectos");
            return "/presentation/cliente/datos/View.jsp"; 
        }        
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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
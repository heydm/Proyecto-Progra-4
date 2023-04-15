package com.progra.guia.presentation.marca;


import com.progra.guia.logic.Marca;
import com.progra.guia.logic.Service;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



@WebServlet("/presentation/marca/add")
public class AddServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
    throws ServletException, IOException {  
        Service service = Service.instance();

        String nombre = request.getParameter("nombre");
        String id = request.getParameter("id");
        
        var marca = new Marca(Integer.parseInt(id), nombre);
        
        try {
            service.marcaCreate(marca);
        } catch (Exception ex) {
            response.sendRedirect("/index.jsp");
        } 
    }
    
    @Override
    protected void doGet(HttpServletRequest request, 
                                HttpServletResponse response)
         throws ServletException, IOException {
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/presentation/marca/add.jsp");
        dispatcher.forward(request, response); 
    }
}
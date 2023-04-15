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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



@WebServlet("/presentation/marca/index")
public class IndexServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
    throws ServletException, IOException {
    }
    
    @Override
    protected void doGet(HttpServletRequest request, 
                                HttpServletResponse response)
         throws ServletException, IOException {
        
        Service service = Service.instance();
        
        List<Marca> marca = null;
        
        try {
            marca = service.marcaIndex();
        } catch (Exception ex) {
            Logger.getLogger(IndexServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("marcaLista", marca);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/presentation/marca/index.jsp");
        dispatcher.forward(request, response);
    }
}

package Servlets;

import Entidades.EntidadInventario;
import Logica.BLInventario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CrearModificarInventario extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
     
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
        try
        {
            BLInventario logica = new BLInventario();
            EntidadInventario inventario = new EntidadInventario();
            int resultado;
            inventario.setIdInventario(Integer.parseInt(request.getParameter("txtIdInventario")));
            inventario.setIdProducto(Integer.parseInt(request.getParameter("txtIdProducto")));
            inventario.setDescripcion(new String(request.getParameter("txtDescripcion").getBytes("ISO-8859-1"),"UTF-8"));                
            inventario.setCantidadIngresada(Integer.parseInt(request.getParameter("txtCantidadIngresada")));
            inventario.setExistencia(Integer.parseInt(request.getParameter("txtExistencia")));          
          
           
            if(inventario.getIdInventario() > 0){  
                 resultado = logica.insertarInventario(inventario);
            }else{                   
                 resultado = logica.insertarInventario(inventario);  
            }
            response.sendRedirect("FrmInventario.jsp");            
        } catch (Exception ex)
        {
            out.print(ex.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

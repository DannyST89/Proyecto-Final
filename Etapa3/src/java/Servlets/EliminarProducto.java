/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Entidades.EntidadProducto;
import Logica.BLProducto;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DSdev
 */
public class EliminarProducto extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter msjSalida = response.getWriter();
       
       
        try
        {
            //instanciamos la entidad producto
            EntidadProducto producto = new EntidadProducto();
            //creamos un objeto de la capa logica
            BLProducto logica = new BLProducto();
             //recibimos el id de la tabla en el jsp
            String codigo = request.getParameter("codigoProducto");
            //al recibirlo en string necesitamos pasarlo a entero
            int cod = Integer.parseInt(codigo);
            //agregamos a la entidad el id de producto
            producto.setIdProducto(cod);
            //llamamos al método eliminar de la capa lógica
            int resultado = logica.eliminarProducto(producto);
            //Creamos la variable mensaje de tipo string donde guadaremos el mensaje de 
            //eliminado que viene desde el procedimiento almacenado
            String msj = logica.getMensaje();
            //Redireccionamos la página al jsp proveedor
            msj = URLEncoder.encode(msj, "UTF-8");
            response.sendRedirect("FrmProducto.jsp?darClic="+msj+"&resultado"+resultado);
            
        } catch (Exception ex)
        {
            msjSalida.print(ex.getMessage());
        }
       
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

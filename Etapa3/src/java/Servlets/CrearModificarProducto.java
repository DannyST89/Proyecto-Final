
package Servlets;

import Entidades.EntidadProducto;
import Logica.BLProducto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CrearModificarProducto extends HttpServlet {


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
        PrintWriter pintar = response.getWriter();
         
        try
        {
            BLProducto logica = new BLProducto();
            EntidadProducto producto = new EntidadProducto();
            int resultado;
            producto.setIdProducto(Integer.parseInt(request.getParameter("txtIdProducto")));
            producto.setIdProveedor(Integer.parseInt(request.getParameter("txtIdProveedor")));
            producto.setNombreProveedor(new String(request.getParameter("txtNombreProveedor").getBytes("ISO-8859-1"),"UTF-8"));
            producto.setDescripcion(new String(request.getParameter("txtDescripcion").getBytes("ISO-8859-1"),"UTF-8"));   
            producto.setPrecioUnidad(Double.parseDouble(request.getParameter("txtPrecioUnidad")));
            
            if(producto.getIdProducto() > 0){
                resultado = logica.insertarProducto(producto);
            }else{
                resultado = logica.insertarProducto(producto);
            }
            response.sendRedirect("FrmProducto.jsp");
        } catch (Exception ex)
        {
            pintar.print(ex.getMessage());
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

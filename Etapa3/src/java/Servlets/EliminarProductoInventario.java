
package Servlets;

import Entidades.EntidadInventario;
import Logica.BLInventario;
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
public class EliminarProductoInventario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            BLInventario logica = new BLInventario();
            EntidadInventario inventario = new EntidadInventario();
            //recibimos el id que vamos a eliminar
            String codigo = request.getParameter("idEliminar");
            //al recibirlo en string necesitamos pasarlo a entero
            int cod = Integer.parseInt(codigo);
            //agregamos a la entidad el id de producto
            inventario.setIdInventario(cod);
            //lo pasamos a entero
            int resultado = logica.eliminarInventario(inventario);
            //eliminado que viene desde el procedimiento almacenado
            String msj = logica.getMensaje();
            //Redireccionamos la página al jsp proveedor
            msj = URLEncoder.encode(msj, "UTF-8");
            response.sendRedirect("FrmInventario.jsp?darClic="+msj+"&resultado"+resultado);
            
        } catch (Exception ex)
        {
            out.print(ex.getMessage());
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

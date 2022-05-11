
package Servlets;

import Entidades.EntidadProveedor;
import Logica.BLProveedor;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EliminarProveedor extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //para poder escribir en el html
        PrintWriter out = response.getWriter();
        try
        {
            BLProveedor logica = new BLProveedor();
            EntidadProveedor proveedor = new EntidadProveedor();
            //parametro que se envia desde la tabla, traémos el id del proveedor
            //que tomaremos como referencia para poder eliminarlo de la base de datos
            String id = request.getParameter("idEliminar");
            //como viene como String necesitamos convertirlo a entero
            //porque en el método se recibe una entidad con el id del proveedor
            int codigo = Integer.parseInt(id);
            //enviamos el id del proveedor
            proveedor.setId_proveedor(codigo);
            //el método recibe ese id
            int resultado = logica.eliminarProveedor(proveedor);
            //Mensaje del procedimiento almacenado que enviaremos a jsp
            String mensaje = logica.getMensaje();
            mensaje = URLEncoder.encode(mensaje, "UTF-8");
            response.sendRedirect("FrmProveedor.jsp?meCli=" + mensaje + "&resultado=" + resultado);
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

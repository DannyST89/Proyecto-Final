
package Servlets;

import Entidades.EntidadProveedor;
import Logica.BLProveedor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DSdev
 */
public class CrearModificarProveedor extends HttpServlet {


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
        //Especificamos el formato de respuesta
        PrintWriter out = response.getWriter();
        //Generar respuesta de la petición
        try
        {
            BLProveedor logica = new BLProveedor();
            EntidadProveedor proveedor = new EntidadProveedor();
            int resultado;
            proveedor.setId_proveedor(Integer.parseInt(request.getParameter("txtIdProveedor")));
            proveedor.setNombreProveedor(new String(request.getParameter("txtNombreProveedor").getBytes("ISO-8859-1"),"UTF-8")); 
            proveedor.setDireccion(new String(request.getParameter("txtDireccion").getBytes("ISO-8859-1"),"UTF-8"));                
            proveedor.setTelefono(new String(request.getParameter("txtTelefono").getBytes("ISO-8859-1"),"UTF-8")); 
            proveedor.setExtension(Integer.parseInt(request.getParameter("txtExtension")));
            proveedor.setCorreo(new String(request.getParameter("txtCorreo").getBytes("ISO-8859-1"),"UTF-8"));
            proveedor.setNumeroCuenta(new String(request.getParameter("txtNumeroCuenta").getBytes("ISO-8859-1"),"UTF-8")); 
            
            if(proveedor.getId_proveedor() > 0){  
                resultado = logica.modificarProveedor(proveedor);
            }else{                   
                resultado = logica.insertarProveedor(proveedor);  
            }
            response.sendRedirect("FrmProveedor.jsp");
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

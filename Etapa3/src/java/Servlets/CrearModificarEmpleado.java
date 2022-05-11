/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Entidades.EntidadEmpleado;
import Logica.BLEmpleado;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DSdev
 */
public class CrearModificarEmpleado extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Especificamos el formato de respuesta
        PrintWriter out = response.getWriter();
        try
        {
            BLEmpleado logica = new BLEmpleado();
            EntidadEmpleado empleado = new EntidadEmpleado();
            int resultado;
            empleado.setIdEmpleado(Integer.parseInt(request.getParameter("txtIdEmpleado")));
            empleado.setNombre(new String(request.getParameter("txtNombreEmpleado").getBytes("ISO-8859-1"),"UTF-8")); 
            empleado.setPrimerApellido(new String(request.getParameter("txtPrimerApellido").getBytes("ISO-8859-1"),"UTF-8"));    
            empleado.setSegundoApellido(new String(request.getParameter("txtSegundoApellido").getBytes("ISO-8859-1"),"UTF-8")); 
            empleado.setTelefono(new String(request.getParameter("txtTelefono").getBytes("ISO-8859-1"),"UTF-8")); 
            empleado.setCorreo(new String(request.getParameter("txtCorreo").getBytes("ISO-8859-1"),"UTF-8"));
            empleado.setDireccion(new String(request.getParameter("txtDireccion").getBytes("ISO-8859-1"),"UTF-8")); 
            empleado.setCargo(new String(request.getParameter("cboCargo").getBytes("ISO-8859-1"),"UTF-8"));    
            //handling dates              
                        
            String fecha = new String(request.getParameter("txtFechaIngreso").getBytes("ISO-8859-1"),"UTF-8");
            java.util.Date dt= new SimpleDateFormat("dd-MM-yy").parse(fecha);
            java.sql.Date fechaInicio = new java.sql.Date(dt.getTime());
            
            empleado.setFechaIngreso(fechaInicio);  
            empleado.setNombreUsuario(new String(request.getParameter("txtNombreUsuario").getBytes("ISO-8859-1"),"UTF-8"));       
            empleado.setConstrasenia(new String(request.getParameter("txtContrasenia").getBytes("ISO-8859-1"),"UTF-8"));  

            if(empleado.getIdEmpleado() > 0){
                resultado = logica.modificarEmpleado(empleado);            
            }else{
                resultado = logica.insertarEmpleado(empleado);
            }
            response.sendRedirect("FrmEmpleado.jsp");
        } catch (Exception ex)
        {
            //throw ex;
            
            out.print(ex.getMessage());
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

}

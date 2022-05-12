<%-- 
    Document   : FrmEmpleado
    Created on : 04/05/2022, 09:46:33 AM
    Author     : DSdev
--%>
<%@page import="com.sun.glass.events.ViewEvent"%>
<%@page import="Entidades.*"%>
<%@page import="Logica.*"%>
<%@page import="java.util.List" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrar Empleados</title>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
              rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
              crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" 
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" 
                crossorigin="anonymous"></script>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
        <link href="lib/fontawesome-free-5.14.0-web/css/all.min.css" rel="stylesheet" type="text/css"/> 
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!-- llamamos al componente navbar -->
         <jsp:include page="FrmNavBar.jsp"/>
        <div class="container">
            <div class="card-header">
                <h1 class="text-center">Administrar Empleados</h1>
            </div>                      
            <br>
           
            <!-- El formulario se va a cargar a si mismo -->    
            <form action="FrmEmpleado.jsp" method="post">
                <div class="form-group row">
                    <div class="input-group col-sm-2">
                        <input type="submit" id="btnbuscar" 
                               name="btnbuscar" 
                               value="Buscar" 
                               class="btn btn-primary"/>                       
                        <input 
                            type="text" 
                            id="txtnombre" 
                            name="txtnombre" 
                            value="" 
                            placeholder="Buscar por Nombre" class="form-control "
                        />               
                    </div> 
                    &nbsp;
                    
                </div> 
            </form>
            <div class="form-group float-right">              
                <a href="FrmAdminEmpleados.jsp?idCrearModificar=-1" class="btn btn-outline-primary"> Agregar un nuevo empleado </a> 
            </div>
            <table class="table ">
                <thead>
                    <tr id="titulos">
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>1° Apellido</th>
                        <th>2° Apellido</th>
                        <th>Teléfono</th>  
                        <th>Correo</th>       
                        <th>Dirección</th>  
                        <th>Cargo</th> 
                        <th>Fecha Ingreso</th>
                        <th>Usuario</th>          
                        <th>Contraseña</th>      
                        <th>Opciones</th>


                    </tr>
                </thead>
                <tbody>

                    <!--Hacer una consulta a la bd para obtener la lista de clientes
                        mediante código JAVA--> 
                    <% 
                        String nombre = "";
                        String condicion = "";
                        //si el txtnombre no está vacio
                        if(request.getParameter("txtnombre")!=null){
                            nombre = request.getParameter("txtnombre");
                            condicion = "NOMBRE LIKE '%" + nombre + "%'";
                        }else{
                            
                        }
                        
                        BLEmpleado logica = new BLEmpleado();
                        List<EntidadEmpleado> datos;
                        datos = logica.ListarEmpleados(condicion);
            
                        //for para llenar la tabla
                        for (EntidadEmpleado registro:datos){
                    %>
                    <tr>
                        <% int codigo = registro.getIdEmpleado();%>
                        <td><%=codigo %></td>
                        <td><%=registro.getNombre()%></td>
                        <td><%=registro.getPrimerApellido()%></td>
                        <td><%=registro.getSegundoApellido()%></td>   
                        <td><%=registro.getTelefono()%></td>       
                        <td><%=registro.getCorreo()%></td>    
                        <td><%=registro.getDireccion()%></td>    
                        <td><%=registro.getCargo()%></td>       
                        <td><%=registro.getFechaIngreso()%></td>       
                        <td><%=registro.getNombreUsuario()%></td>          
                        <td><%=registro.getConstrasenia()%></td>                      
                        <!--Columna para los botones -->
                        <td>
                            <!--Botón para modificar -->
                            <a href="FrmAdminEmpleados.jsp?idCrearModificar=<%=codigo%>"><i class="bi bi-pencil-square" style="color:#ffca2c;"></i></a> |
                            <!--Botón para Eliminar -->
                            <a href="EliminarEmpleado?idEliminar=<%=codigo%>"><i class="bi bi-trash3-fill" style="color:#FF2000;"></i></a> 
                        </td>
                    </tr>
                    <%}%><!--Para cerrar el for --> 
                </tbody> 
            </table>
            <div class="form-group float-right">
                <a href="index.jsp.html" class="btn btn-success"> Regresar al Inicio </a> 
            </div>
                 <%
                    if(request.getParameter("meCli") != null){
                        out.print("<h2 class='text-danger'>" + new String(request.getParameter("meCli").getBytes("ISO-8859-1"),"UTF-8")+"</h2>");
                    }    
                    
                %>
        </div><!--Fin Container --> <!-- Page content -->       
  

        <script src="lib/jquery/dist/jquery.min.js" type="text/javascript"></script>
        <script src="lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    </body>
</html>

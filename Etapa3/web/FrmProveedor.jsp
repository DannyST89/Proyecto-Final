<%-- 
    Document   : FrmProveedor
    Created on : 04/05/2022, 05:03:36 PM
    Author     : DSdev
--%>

<%@page import="Entidades.*"%>
<%@page import="Logica.*"%>
<%@page import="java.util.List" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>     
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrar Proveedores</title>
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
        <header>
           <!-- llamamos al componente navbar -->
            <jsp:include page="FrmNavBar.jsp"/>
        </header>
        <div class="container">
            <div class="card-header">
                <h1 class="text-center">Administrar Proveedores</h1>
            </div>                      
            <br>
            
            <!-- El formulario se va a cargar a si mismo -->    
            <form action="FrmProveedor.jsp" method="post">
                <div class="form-group row">
                    <div class="input-group col-xs-2">
                        <input type="submit" id="btnbuscar" name="btnbuscar" value="Buscar" 
                               class="btn text-white "  style="background-color: #008788;"/>                       
                        <input type="text" id="txtnombre" name="txtnombre" value="" 
                               placeholder="Buscar por Nombre" class="form-control "/>               
                    </div> 
                    &nbsp;
                    
                </div> 
                 <div class="form-group">              
                <a href="FrmAdminProveedores.jsp?idCrearModificar=-1" class="btn btn-outline-primary"> Agregar un nuevo empleado </a> 
            </div>
            </form>
            <hr>
            <table class="table">
                <thead>
                    <tr id="titulos">
                        <th>ID</th>
                        <th>Nombre Proveedor</th>
                        <th>Direcci??n</th>
                        <th>Tel??fono</th>
                        <th>Extensi??n</th>  
                        <th>Correo Electr??nico</th>       
                        <th>N??mero de Cuenta</th>  
                    </tr>
                </thead>
                <tbody>

                    <!--Hacer una consulta a la bd para obtener la lista de clientes
                        mediante c??digo JAVA--> 
                    <% 
                        String nombre = "";
                        String condicion = "";
                        //si el txtnombre no est?? vacio
                        if(request.getParameter("txtNombreProveedor")!=null){
                            nombre = request.getParameter("txtNombreProveedor");
                            condicion = "NOMBRE_PROVEEDOR LIKE '%" + nombre + "%'";
                        }else{
                            
                        }
                        
                        BLProveedor logica = new BLProveedor();
                        List<EntidadProveedor> datos;
                        datos = logica.ListarProveedor(condicion);
            
                        //for para llenar la tabla
                        for (EntidadProveedor registro:datos){
                    %>
                    <tr>
                        <% int codigo = registro.getId_proveedor();%>
                        <td><%=codigo%></td>
                        <td><%=registro.getNombreProveedor()%></td>
                        <td><%=registro.getDireccion()%></td>
                        <td><%=registro.getTelefono()%></td>   
                        <td><%=registro.getExtension()%></td>       
                        <td><%=registro.getCorreo()%></td>    
                        <td><%=registro.getNumeroCuenta()%></td>                      
                        <!--Columna para los botones -->
                        <td>
                            <!--Bot??n para modificar -->
                            <a href="FrmAdminProveedores.jsp?idCrearModificar=<%=codigo%>"> <i class="bi bi-pencil-square" style="color:#ffca2c;"></i></a> |
                            <!--Bot??n para Eliminar -->
                            <a href="EliminarProveedor?idEliminar=<%=codigo%>"> <i class="bi bi-trash3-fill" style="color:#FF2000;"></i></a> 
                        </td>
                    </tr>
                    <%}%><!--Para cerrar el for --> 
                </tbody
            </table>
                <%
                    if(request.getParameter("meCli") != null){
                        out.print("<h2 class='text-danger'>" + new String(request.getParameter("meCli").getBytes("ISO-8859-1"),"UTF-8")+"</h2>");
                    }    
                    
                %>
                <br> 
                <!--               
                
                <a href="#"> Agregar un nuevo Cliente </a> |
             <a href="frmListarClientes.jsp"> Actualizar </a> |
             <a href="index.html"> Regresar al Inicio </a> 
             
                
                -->      
        </div><!--Fin Container --> 
            

<!-- Page content -->
<div class="main">
  
</div>

        <script src="lib/jquery/dist/jquery.min.js" type="text/javascript"></script>
        <script src="lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    
    </body>
    
</html>

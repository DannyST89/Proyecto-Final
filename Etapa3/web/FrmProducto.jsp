<%-- 
    Document   : FrmProducto
    Created on : 05/05/2022, 05:53:30 PM
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
        <title>Administrar Productos</title>
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
                <h1 class="text-center">Administrar Productos</h1>
            </div>                      
            <br>

            <!-- El formulario se va a cargar a si mismo -->    
            <form action="FrmProducto.jsp" method="post">
                <div class="form-group row">
                    <div class="input-group col-xs-2">
                        <input type="submit" id="btnbuscar" name="btnbuscar" value="Buscar" 
                               class="btn text-white "  style="background-color: #008788;"/>                       
                        <input type="text" id="txtnombre" name="txtnombre" value="" 
                               placeholder="Buscar por Nombre" class="form-control "/>               
                    </div> 
                    &nbsp;
                    
                </div> 
            </form>
            <div>
                <a href="FrmAdminProductos.jsp?idCrearModificar=-1" class="btn btn-primary" value="">Agregar Nuevo Producto</a>
            </div>

            <hr>
            <table class="table">
                <thead>
                    <tr id="titulos">
                        <th>ID</th>
                        <th>ID Proveedor</th>
                        <th>Nombre Proveedor</th>
                        <th>Descripción</th>  
                        <th>Precio Unidad</th>       
                    </tr>
                </thead>
                <tbody>

                    <!--Hacer una consulta a la bd para obtener la lista de clientes
                        mediante código JAVA--> 
                    <% 
                        String nombre = "";
                        String condicion = "";
                        //si el txtnombre no está vacio
                        if(request.getParameter("txtDescripcion")!=null){
                            nombre = request.getParameter("txtDescripcion");
                            condicion = "DESCRIPCION LIKE '%" + nombre + "%'";
                        }else{
                            
                        }
                        
                        BLProducto logica = new BLProducto();
                        List<EntidadProducto> datos;
                        datos = logica.ListarProducto(condicion);
            
                        //for para llenar la tabla
                        for (EntidadProducto registro:datos){
                    %>
                    <tr>
                        <% int codigo = registro.getIdProducto();%>
                        <td><%=codigo%></td>                      
                        <td><%=registro.getIdProveedor()%></td> 
                        <td><%=registro.getNombreProveedor()%></td>       
                        <td><%=registro.getDescripcion()%></td>    
                        <td><%=registro.getPrecioUnidad()%></td>                      
                        <!--Columna para los botones -->
                        <td>
                            <!--Botón para modificar -->
                            <a href="FrmAdminProductos.jsp?idCrearModificar=<%=codigo%>"> <i class="bi bi-pencil-square" style="color:#ffca2c;"></i></a> |
                            <!--Botón para Eliminar -->
                            <a href="EliminarProducto?codigoProducto=<%=codigo%>"> <i class="bi bi-trash3-fill" style="color:#FF2000;"></i></a> 
                        </td>
                    </tr>
                    <%}%><!--Para cerrar el for --> 
                </tbody
            </table>
                <%
                    if(request.getParameter("darClic") != null){
                        out.print("<h2 class='text-danger'>" + new String(request.getParameter("darClic").getBytes("ISO-8859-1"),"UTF-8")+"</h2>");
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
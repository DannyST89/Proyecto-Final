<%-- 
    Document   : FrmInventario
    Created on : 05/05/2022, 06:33:27 PM
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
        <title>Administrar Inventario</title>
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
        <link href="css/estilosInventario.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
       <header>
           <nav class="navbar navbar-expand-sm navbar-toggleable-sm navbar-light border-bottom box-shadow mb-3" style="background-color: #212A32;">
                <div class="container">
                    <a class="navbar-brand text-white" href="index.html">EasyMarket <i class="fas fa-tasks"></i></a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".navbar-collapse" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="navbar-collapse collapse d-sm-inline-flex flex-sm-row-reverse">
                        <ul class="navbar-nav ms-auto mb-2 mb-log-0">
                            <li class="nav-item">
                                <a class="nav-link text-white" href="index.html">Inicio</a>
                            </li>                            
                            <li class="nav-item">
                                <a class="nav-link text-white" href="frmListarClientes.jsp">Sobre Nosotros</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-white" href="FrmListarFacturas.jsp">Contactenos</a>
                            </li>       
                             <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle text-white" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">Administrativo</a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="FrmEmpleado.jsp">Empleados</a></li>
                                    <li><a class="dropdown-item" href="FrmProveedor.jsp">Proveedores</a></li>
                                    <li><a class="dropdown-item" href="FrmProducto.jsp">Productos</a></li>
                                    <li><a class="dropdown-item" href="FrmInventario.jsp">Inventario</a></li>
                                    <li><a class="dropdown-item" href="FrmVentas.jsp">Ventas</a></li>
                                    <li><a class="dropdown-item" href="FrmCliente.jsp">Clientes</a></li>
                                    <li><a  class="dropdown-item" href="FrmFactura.jsp">Facturación</a></li> 
                                    <li><hr class="dropdown-divider"></li>
                                </ul>
                             </li> 
                              <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle text-white" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">DSoto</a>
                                <ul class="dropdown-menu">                                   
                                    <li><a class="dropdown-item" href="FrmInventario.jsp"></a></li>
                                    <li><a class="dropdown-item" href="FrmVentas.jsp">Ventas</a></li>
                                    <li><a class="dropdown-item" href="FrmCliente.jsp">Clientes</a></li>
                                    <li><a  class="dropdown-item" href="FrmFactura.jsp">Facturación</a></li> 
                                    <li><hr class="dropdown-divider"></li>
                                    <li><a class="dropdown-item" href="FrmLogin.jsp">Cerrar Cesión</a></li> 
                                    <li><a class="dropdown-item" href="FrmRegistro.jsp">Registrarse</a></li>

                                </ul>
                             </li>
                             
                        </ul>
                    </div>
                </div>
               
            </nav>
        </header>
        <div class="container" >
            <div class="card-header">
                <h1 class="text-center">Administrar Inventario</h1>
            </div>                      
            <br>

            <!-- El formulario se va a cargar a si mismo -->    
            <form action="FrmInventario.jsp" method="post">
                <div class="form-group mt-3">
                    <div class="input-group col-xs-2">
                        <input type="submit" id="btnbuscar" name="btnbuscar" value="Buscar" 
                               class="btn text-white "  style="background-color: #008788;"/>                       
                        <input type="text" id="txtnombre" name="txtnombre" value="" 
                               placeholder="Buscar por Nombre" class="form-control "/>               
                    </div> 
                    &nbsp;
                    
                </div> 
            </form>
            <hr>
            <table class="table table-bordered">
                <thead>
                    <tr id="titulos">
                        <th>ID</th>
                        <th>ID Producto</th>
                        <th>Descripción</th>
                        <th>Cantidad Ingresada</th>
                        <th>Existencia</th>  
                        <th>Cantidad Vendida</th>   
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
                        
                        BLInventario logica = new BLInventario();
                        List<EntidadInventario> datos;
                        datos = logica.ListarInventario(condicion);
            
                        //for para llenar la tabla
                        for (EntidadInventario registro:datos){
                    %>
                    <tr>
                        <% int codigo = registro.getIdInventario();%>
                        <td><%=codigo%></td>                      
                        <td><%=registro.getIdProducto()%></td>
                        <td><%=registro.getDescripcion()%></td>   
                        <td><%=registro.getCantidadIngresada()%></td>       
                        <td><%=registro.getExistencia()%></td>    
                        <td><%=registro.getCantidadVendida()%></td> 
                        <!--Columna para los botones -->
                        <td>
                            <!--Botón para modificar -->
                            <a href="#"> <i class="bi bi-pencil-square" style="color:#ffca2c;" data-bs-toggle="modal" data-bs-target="#staticBackdrop"></i></a> |
                            <!--Botón para Eliminar -->
                            <a href="#"> <i class="bi bi-trash3-fill" style="color:#FF2000;"></i></a> 
                        </td>
                    </tr>
                    <%}%><!--Para cerrar el for --> 
                </tbody
            </table>
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
<!-- Button trigger modal -->
<!-- Modal -->
        <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Administrar Inventario</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                    <div class="form-floating mb-3">
                        <input  class="form-control" id="floatingInput" placeholder="ID Inventario" name="txtIdInventario" readonly >
                        <label for="floatingInput">ID Inventario</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input  class="form-control" id="floatingPassword" placeholder="ID Producto" name="txtIdProducto" >
                        <label for="floatingPassword">ID Producto</label>
                    </div>
                    <div class="form-floating mb-3">
                       <input  class="form-control" id="floatingInput" placeholder="Descripción" name="txtDescripcion" >
                       <label for="floatingInput">Descripción</label>
                    </div>                    
                    <div class="form-floating mb-3">
                       <input  class="form-control" id="floatingInput" placeholder="Cantidad Ingresada" name="txtCantidadIngresada" >
                       <label for="floatingInput">Cantidad Ingresada</label>
                    </div>
                    <div class="form-floating">
                        <input  class="form-control" id="floatingInput" placeholder="Existencia" name="txtExistencia" >
                        <label for="floatingInput">Existencia</label>
                    </div>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn text-white" data-bs-dismiss="modal" style="background-color:#008788;">Guardar</button>
                <button type="button" class="btn text-white" style="background-color: #212A32;">Cancelar</button>
              </div>
            </div>
          </div>
        </div>
        <script src="lib/jquery/dist/jquery.min.js" type="text/javascript"></script>
        <script src="lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    </body>
</html>
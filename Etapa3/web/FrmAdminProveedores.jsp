<%-- 
    Document   : FrmAdminProveedores
    Created on : 10/05/2022, 09:03:39 PM
    Author     : DSdev
--%>

<%@page import="Logica.*"%>
<%@page import="Entidades.*"%>
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
        <header>
           <nav class="navbar navbar-expand-sm navbar-toggleable-sm navbar-light border-bottom box-shadow mb-3" style="background-color: #6358DC;">
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
        <div class="container">
            <div class="row">
                <div class="col-md-6 mx-auto">
                    <div class="card-header">            
                        <h1>Administrar Proveedores</h1>
                    </div><br>
                     <%
                     
                        String id = request.getParameter("idCrearModificar");
                        int codigo = Integer.parseInt(id);
                        EntidadProveedor proveedor;
                        BLProveedor logica = new BLProveedor();
                        if(codigo > 0){
                            //cliente exite
                            proveedor = logica.ObtenerUnProveedor("ID_PROVEEDOR="+id);                         
                        }else{
                            proveedor = new EntidadProveedor();
                            
                        }
                     %> <!-- al no tener jsp quiere decir que es un servlet -->
                     <form action="CrearModificarProveedor" method="post" id="FrmProveedor">
                            <div class="form-group  float-left">
                             <%if(codigo > 0){%> 
                               <label for="">ID Proveedor</label>
                                <input 
                                    type="number"
                                    class="form-control" 
                                    id="txtIdProveedor" 
                                    placeholder="ID Proveedor" 
                                    name="txtIdProveedor" 
                                    readonly 
                                    value="<%=proveedor.getId_proveedor()%>"
                                >    
                            <%}else{%>
                             <input 
                                 class="form-control" 
                                 type="hidden"  
                                 id="txtIdProveedor" 
                                 name="txtIdProveedor" 
                                 readonly 
                                 value="-1">                               
                            <%}%>                        
                                </div>
                                <div class="form-group">
                                     <label for="">Nombre Proveedor</label>
                                    <input  
                                        class="form-control"
                                        id="txtNombreProveedor" 
                                        placeholder="Nombre" 
                                        name="txtNombreProveedor" 
                                        value="<%=proveedor.getNombreProveedor()%>"
                                    >                                   
                                </div>
                                <div class="form-group">
                                    <label for="">Dirección</label>
                                   <input  
                                       class="form-control" 
                                       id="txtDireccion" 
                                       placeholder="Dirección" 
                                       name="txtDireccion" 
                                       value="<%=proveedor.getDireccion() %>"
                                     >
                                  
                                </div>  
                                <div class="form-group">
                                    <label for="">Teléfono</label>
                                   <input  
                                       class="form-control" 
                                       id="txtTelefono" 
                                       placeholder="Teléfono" 
                                       name="txtTelefono" 
                                       value="<%=proveedor.getTelefono()%>"
                                    >
                                </div>   
                                    <div class="form-group">
                                    <label for="">Extensión</label>
                                   <input  
                                       class="form-control" 
                                       id="txtExtension" 
                                       placeholder="Extensión" 
                                       name="txtExtension" 
                                       value="<%=proveedor.getExtension()%>"
                                    >
                                </div>  
                                <div class="form-group">
                                      <label for="floatingInput">Correo Electrónico</label>
                                   <input  
                                       class="form-control" 
                                       id="txtCorreo" 
                                       placeholder="Correo Electrónico" 
                                       name="txtCorreo" 
                                       value="<%=proveedor.getCorreo()%>"
                                    >
                                 
                                </div>  
                                <div class="form-group">
                                    <label for="">Número de Cuenta</label>
                                   <input  
                                       class="form-control" 
                                       id="txtNumeroCuenta" 
                                       placeholder="Número de Cuenta" 
                                       name="txtNumeroCuenta" 
                                       value="<%=proveedor.getNumeroCuenta()%>"
                                    >
                                   
                                </div>                                     
                                <div class="form-group">
                                    <div class="input-group">
                                        <input 
                                            type="submit" 
                                            id="btnGuardar" 
                                            value="Guardar"
                                            class="btn btn-primary"&nbsp;&nbsp
                                        />
                                        <input 
                                            type="button" 
                                            id="btnRegresar" 
                                            value="Regresar"
                                            class="btn btn-secondary"
                                            onclick="location.href='FrmProveedor.jsp'"
                                        />
                                    </div> 
                                </div> 
                     </form>
                </div>            
            </div>            
        </div><!-- container -->
        <script src="lib/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="lib/jquery/dist/jquery.min.js" type="text/javascript"></script>
        <script src="lib/jquery-validation/dist/jquery.validate.min.js" type="text/javascript"></script>
        <!-- Creamos la validación -->
        <script>
            //cuando el documento este listo
            $(document).ready(function(){
                
                $("#FrmProveedor").validate({                    
                    rules:{
                        txtNombreProveedor:{required:true,maxlength:20},                                              
                        txtTelefono:{required:true,minlength:8,maxlength:20},
                        txtExtension:{required:true,maxlength:20},
                        txtCorreo:{required:true,maxlength:30},
                        txtDireccion:{required:true,maxlength:100, 
                        txtNumeroCuenta:{required:true,minlength:17,maxlength:30}
}
                    },
                    messages:{
                        txtNombreProveedor:"El campo 'Nombre Proveedor' es requerido, máximo 20 carácteres", 
                        txtTelefono:"El campo 'Teléfono' es requerido, mínimo 8 carácteres,máximo 20",
                        txtExtension:"El campo 'Extensión' es requerido, máximo 20",                        
                        txtCorreo:"El campo 'Correo Electrónico' es requerido, máximo 30 carácteres",
                        txtDireccion:"El campo 'Dirección' es requerido, máximo 100",                        
                        txtNumeroCuenta:"El campo 'Número de Cuenta' es requerido, mínimo 17 carácteres,máximo 30"
                    },
                    errorElement:'span'
                });
            });
            
        </script>
    </body>
</html>

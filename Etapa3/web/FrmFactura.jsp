<%-- 
    Document   : FrmFactura
    Created on : 05/05/2022, 09:05:56 PM
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
        <title>Facturación</title>
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
        <div class="container">
            <div class="d-flex">
                <div class="col-sm-4">            
                    <div class="card">
                        <form action="action">
                            <div class="card-body">
                                <div class="form-group">
                                    <label> Datos del Cliente <label>
                                </div> 
                                <div class="form-group d-flex">
                                    <div class="col-sm-6 d-flex">
                                         <input type="text" name="idCliente" class="form-control" placeholder="ID Cliente">
                                         <input type="submit" name="accion" value="Buscar" class="btn btn-success" style="margin-left: 5px"> 
                                    </div>  
                                    <div class="col-sm-6">
                                        <input type="text" name="nombreCliente" class="form-control col-sm-4">
                                    </div>    
                                </div>  
                                <div class="form-group">
                                    <label>Datos Producto</label>
                                </div>   
                                <div class="form-group d-flex">
                                    <div class="col-sm-6 d-flex">
                                         <input type="text" name="idCliente" class="form-control" placeholder="ID Cliente">
                                         <input type="submit" name="accion" value="Buscar" class="btn btn-success" style="margin-left: 5px"> 
                                    </div>  
                                    <div class="col-sm-6">
                                        <input type="text" name="nombreCliente" class="form-control col-sm-4">
                                    </div>    
                                </div> 
                                <div class="form-group d-flex">
                                    <div class="col-sm-4 d-flex">
                                         <input type="text" name="idCliente" class="form-control" placeholder="ID Cliente">
                                         <input type="submit" name="accion" value="Buscar" class="btn btn-success" style="margin-left: 5px"> 
                                    </div>  
                                    <div class="col-sm-3">
                                        <input type="text" name="nombreCliente" class="form-control col-sm-4" style="margin-left: 5px">
                                    </div>   
                                     <div class="col-sm-3">
                                        <input type="text" name="nombreCliente" class="form-control col-sm-4" style="margin-left: 5px">
                                    </div>   
                                </div>   
                                <div class="form-group">
                                    <i class="bi bi-cart-check" style="color: green;"></i>
                                    <input type="submit" name="accion" value="Agregar" class="btn btn-success" style="margin-left: 5px"> 
                                </div>  
                                  
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-sm-7">
                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex col-sm-5 ml-auto">
                                <label>Código de Factura</label>
                                <input type="text" name="nombreCliente" class="form-control">
                            </div>  
                            <br>                            
                            <table border="1" class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>columna 1</th>      
                                        <th>columna 2</th>       
                                        <th>columna 3</th>      
                                        <th>columna 4</th>     
                                        <th>columna 5</th>    
                                        <th>columna 6</th>         
                                        <th>
                                            <a href="" class="btn btn-warning"> <i class="bi bi-pencil-square"></i> </a>
                                            <a href="" class="btn btn-danger"><i class="bi bi-trash3-fill"></i></a>
                                        </th> 

                                        
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div class="card-footer d-flex">
                            <div class="col-sm-6">
                                <input type="submit" name="txtTotal" value="Generar Venta" class="btn btn-success">
                                <input type="submit" name="accion" value="Cancelar" class="btn btn-warning">
                            </div>
                            <div class="col-sm-4 ml-auto">
                                <div class="form-floating">
                                    <input  class="form-control" id="floatingInput" placeholder="Existencia" name="txtExistencia" >
                                    <label for="floatingInput">Subtotal</label>
                                </div>
                                <div class="form-floating">
                                    <input  class="form-control" id="floatingInput" placeholder="Existencia" name="txtExistencia" >
                                    <label for="floatingInput">IVA</label>
                                </div>
                                <div class="form-floating">
                                    <input  class="form-control" id="floatingInput" placeholder="Existencia" name="txtExistencia" >
                                    <label for="floatingInput">Descuento</label>
                                </div>
                                <div class="form-floating">
                                    <input  class="form-control" id="floatingInput" placeholder="Existencia" name="txtExistencia" >
                                    <label for="floatingInput">Total a Pagar</label>
                                </div>
                            </div>
                        </div>
                        
                        
                </div><!-- fin card-body -->
           
        <div>
    </body>
</html>
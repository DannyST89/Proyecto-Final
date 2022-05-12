<%-- 
    Document   : FrmAdminProductos
    Created on : 11/05/2022, 01:13:10 PM
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
        <link href="lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="lib/DataTables/datatables.min.css" rel="stylesheet" type="text/css"/>
        <link href="lib/fontawesome-free-5.14.0-web/css/all.min.css" rel="stylesheet" type="text/css"/>        
    </head>
    <body>
        <header>
            <!-- llamamos al componente navbar -->
            <jsp:include page="FrmNavBar.jsp"/>
        </header>
        <div class="container">
            <div class="row">
                <div class="col-md-6 mx-auto">
                    <div class="card-header">            
                        <h1>Administrar Productos</h1>
                    </div><br>
                     <%
                         //obtenemos el codigo que hemos mandado de FrmProducto
                        String id = request.getParameter("idCrearModificar");
                        //Lo convertimos a int
                        int codigo = Integer.parseInt(id);
                        EntidadProducto producto;
                        BLProducto logica = new BLProducto();
                        if(codigo > 0){
                            //cliente exite
                            producto = logica.ObtenerUnProducto("ID_PRODUCTO="+id);                         
                        }else{
                            producto = new EntidadProducto();
                            
                        }
                     %> <!-- al no tener jsp quiere decir que es un servlet -->
                     <form action="CrearModificarProducto" method="post" id="FrmProducto">
                            <div class="form-group  float-left">
                             <%if(codigo > 0){%> 
                               <label for="">ID Producto</label>
                                <input 
                                    type="number"
                                    class="form-control" 
                                    id="txtIdProducto" 
                                    placeholder="ID Empleado" 
                                    name="txtIdProducto" 
                                    readonly 
                                    value="<%=producto.getIdProducto()%>"
                                >    
                                <label for="">ID Producto</label>
                            <%}else{%>
                             <input 
                                 class="form-control" 
                                 type="hidden"  
                                 id="txtIdProducto" 
                                 name="txtIdProducto" 
                                 readonly 
                                 value="-1">                               
                            <%}%>                        
                                </div>                                
                                <div class="form-group">
                                     <a 
                                        id="btnBuscar" 
                                        class="btn btn-success text-white" 
                                        data-toggle="modal" 
                                        data-target="#buscarProveedor"> Agregar Proveedor 
                                        <i class="fas fa-search text-white"> </i>
                                       
                                    </a>
                                    <input  
                                        class="form-control"
                                        id="txtIdProveedor" 
                                        placeholder="Id Proveedor" 
                                        name="txtIdProveedor" 
                                        readonly
                                        value="<%=producto.getIdProveedor()%>"
                                    >                                     
                                </div>
                                    <div class="form-group">
                                    <label for="">Nombre Proveedor</label>
                                   <input  
                                       class="form-control" 
                                       id="txtNombreProveedor" 
                                       placeholder="Nombre Proveedor" 
                                       readonly
                                       name="txtNombreProveedor" 
                                       value="<%=producto.getNombreProveedor()%>"
                                     >
                                  
                                </div> 
                                <div class="form-group">
                                    <label for="">Descripción</label>
                                   <input  
                                       class="form-control" 
                                       id="txtDescripcion" 
                                       placeholder="Descripción" 
                                       name="txtDescripcion" 
                                       value="<%=producto.getDescripcion()%>"
                                     >
                                  
                                </div>  
                                <div class="form-group">
                                    <label for="floatingInput">Precio Unidad</label>
                                   <input  
                                       class="form-control" 
                                       id="txtPrecioUnidad" 
                                       placeholder="Precio Unidad" 
                                       name="txtPrecioUnidad" 
                                       value="<%=producto.getPrecioUnidad()%>"
                                    >
                                </div>                                 
                               
                                <div class="form-group">           
                                  
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
                                            onclick="location.href='FrmProducto.jsp'"
                                        />
                                    </div> 
                                </div> 
                     </form>
                </div>            
            </div>            
            
        </div>
           <!-- Fin formulario-->    
         <!-- ************************************************************************************** -->  
        <!-- Inicia Modal para mostrar y seleccionar proveedores -->
         <div class="modal" id="buscarProveedor" tabindex="1" role="dialog" aria-labelledby="tituloVentana">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 id="tituloVentaja">Buscar Proveedor</h5>
                        <button 
                            class="close" 
                            data-dismiss="modal" 
                            aria-label="Cerrar" 
                            aria-hidden="true" 
                            onclick="LimpiarProveedor()"
                        >
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                    <!-- tabla Proveedores -->
                        <table id="tablaProveedores">
                            <thead> 
                                <tr> 
                                    <th>ID</th> 
                                    <th>Nombre Proveedor</th>  
                                    <th>Dirección</th> 
                                    <th>Teléfono</th>
                                    <th>Opción</th> 
                                </tr> 
                            </thead>
                             <tbody>
                                <%
                                    BLProveedor logicaProveedor = new BLProveedor();
                                    List<EntidadProveedor> datosProveedor;
                                    datosProveedor = logicaProveedor.ListarProveedor("");
                                    for(EntidadProveedor registroP : datosProveedor){                    

                                %>
                                <tr>
                                   <%
                                       int codigoProveedor = registroP.getId_proveedor();
                                       String nombreProveedor = registroP.getNombreProveedor();
                                       String direccion = registroP.getDireccion(); 
                                       String telefono = registroP.getTelefono();
                                   %>
                                    <td><%= codigoProveedor %></td>
                                    <td><%= nombreProveedor%></td>
                                    <td><%= direccion%></td>
                                    <td><%= telefono%></td> 
                                    <td>
                                        <a 
                                            href="#" 
                                            data-dismiss="modal"
                                            onclick="SeleccionarProveedor('<%=codigoProveedor%>',
                                                                          '<%=nombreProveedor%>');"
                                        >
                                        Seleccionar
                                        </a>                                        
                                    </td>
                                </tr>
                                    <%
                                        }//cierre del for                                       
                                    %> 
                            </tbody>   

                        </table>
                        
                    </div> <!-- fin cuerpo modal -->
                    <div class="modal-footer"> 
                        <button class="btn btn-warning" type="button" data-dismiss="modal" onclick="LimpiarProveedor()">
                            Cancelar
                        </button>                  
                    
                    </div>
                </div>
            </div>
        </div> <!-- Fin Modal para mostrar y seleccionar Productos -->
        <!--Scripts-->
        <script src="lib/jquery/dist/jquery.min.js" type="text/javascript"></script>
        <script src="lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
        <script src="lib/DataTables/datatables.min.js" type="text/javascript"></script>
        <script src="lib/DataTables/DataTables-1.10.21/js/dataTables.bootstrap4.min.js" type="text/javascript"></script>
        <script src="lib/jquery-validation/dist/jquery.validate.min.js" type="text/javascript"></script>
        <script>
            //cuando el documento esté listo
            //se deben de cargar las siguientes funciones
            $(document).ready(function (){
             
               $('#tablaProveedores').dataTable({
                   "lengthMenu":[[5,15,15,-1],[5,10,15,"All"]],
                   "language":{
                       "info":"Página_PAGE_de_PAGES",
                        "infoEmpty": "No existen registros disponibles",
                        "zeroRecords": "No se encuentran registros",
                        "search": "Buscar",
                        "infoFiltered": "",
                        "lengthMenu": "Mostrar _MENU_ Registros",
                        "paginate":{
                            "first":"Primero",
                            "last":"Último",
                            "next":"Siguiente",
                            "previous":"Anterior"
                        }
                    }
               });
               
            });
            
                function SeleccionarProveedor(codigoProveedor, nombreProveedor){
                    $("#txtIdProveedor").val(codigoProveedor);  
                    $("#txtNombreProveedor").val(nombreProveedor);
                    $("#txtDescripcion").focus();
                }
                function LimpiarProveedor(){
                    $("#txtIdProveedor").val("");
                    $("#txtNombreProveedor").val("");
                    $("#txtNumeroCuenta").val("");
                    $("#txtDireccion").val("");
                }  
                function validarFormulario() {
                    
    
                }
            
        </script>
    </body>
</html>

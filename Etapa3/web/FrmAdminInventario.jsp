<%-- 
    Document   : FrmAdminInventario
    Created on : 11/05/2022, 07:54:32 PM
    Author     : DSdev
--%>

<%@page import="Entidades.*"%>
<%@page import="java.util.List"%>
<%@page import="Logica.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrar Inventario</title>       
        
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
                        <h1>Administrar Inventario</h1>
                    </div><br>
                     <%
                         //obtenemos el codigo que hemos mandado de FrmInventario
                        String id = request.getParameter("idModificar");
                        //Lo convertimos a int
                        int codigo = Integer.parseInt(id);
                        //Intanciamos un objeto de la clase EntidadInventario
                        EntidadInventario inventario;
                        BLInventario logica = new BLInventario();
                        if(codigo > 0){
                            //si el id existe 
                            inventario = logica.ObtenerUnInventario("ID_INVENTARIO="+id);                         
                        }else{
                            inventario = new EntidadInventario();
                            
                        }
                     %> <!-- al no tener jsp quiere decir que es un servlet -->
                     <form action="CrearModificarInventario" method="post" id="FrmInventario">
                            <div class="form-group">
                             <%if(codigo > 0){%> 
                               <label for="">ID Inventario</label>
                                <input 
                                    type="number"
                                    class="form-control" 
                                    id="txtIdInventario" 
                                    name="txtIdInventario" 
                                    readonly 
                                    value="<%=inventario.getIdInventario()%>"
                                >    
                            <%}else{%>
                             <input 
                                 class="form-control" 
                                 type="hidden"  
                                 id="txtIdInventario" 
                                 name="txtIdInventario" 
                                 readonly 
                                 value="-1">                               
                            <%}%>                        
                                </div>                                
                                <div class="form-group">
                                     <a 
                                        id="btnBuscar" 
                                        class="btn btn-success text-white" 
                                        data-toggle="modal" 
                                        data-target="#buscarProducto"> Agregar Producto 
                                        <i class="fas fa-search text-white"> </i>
                                       
                                    </a>
                                    <input  
                                        class="form-control"
                                        id="txtIdProducto" 
                                        placeholder="Id Producto" 
                                        name="txtIdProducto" 
                                        readonly
                                        value="<%=inventario.getIdProducto()%>"
                                    >                                     
                                </div>
                                    <div class="form-group">
                                    <label for="">Descripción</label>
                                   <input  
                                       class="form-control" 
                                       id="txtDescripcion" 
                                       placeholder="Descripción" 
                                       readonly
                                       name="txtDescripcion" 
                                       value="<%=inventario.getDescripcion()%>"
                                     >                                  
                                </div> 
                                <div class="form-group">
                                    <label for="">Cantidad Ingresada</label>
                                   <input  
                                       class="form-control" 
                                       id="txtCantidadIngresada" 
                                       placeholder="Descripción" 
                                       name="txtCantidadIngresada" 
                                       value="<%=inventario.getCantidadIngresada()%>"
                                     >
                                  
                                </div>  
                                <div class="form-group">
                                    <label for="">Existencia</label>
                                   <input  
                                       class="form-control" 
                                       id="txtExistencia" 
                                       placeholder="Precio Unidad" 
                                       name="txtExistencia" 
                                       value="<%=inventario.getExistencia()%>"
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
                                            onclick="location.href='FrmInventario.jsp'"
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
         <div class="modal" id="buscarProducto" tabindex="1" role="dialog" aria-labelledby="tituloVentana">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 id="tituloVentaja">Buscar Producto</h5>
                        <button 
                            class="close" 
                            data-dismiss="modal" 
                            aria-label="Cerrar" 
                            aria-hidden="true" 
                            onclick="LimpiarProducto()"
                        >
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                    <!-- tabla Proveedores -->
                        <table id="tablaProductos">
                            <thead> 
                                <tr> 
                                    <th>Id Producto</th> 
                                    <th>Nombre Proveedor</th> 
                                    <th>Descripción</th> 
                                    <th>Opciones</th>

                                </tr> 
                            </thead>
                             <tbody>
                                <%
                                    BLProducto logicaProducto = new BLProducto();
                                    List<EntidadProducto> datosProducto;
                                    datosProducto = logicaProducto.ListarProducto("");
                                    for(EntidadProducto registroP : datosProducto){                    

                                %>
                                <tr>
                                   <%
                                       int codigoProducto = registroP.getIdProducto();                                       
                                       String nombreProveedor = registroP.getNombreProveedor();
                                       String descripcion = registroP.getDescripcion(); 
                                      
                                   %>
                                    <td><%=  codigoProducto%></td> 
                                    <td><%= nombreProveedor%></td>
                                    <td><%= descripcion%></td>
                                    <td>
                                        <a 
                                            href="#" 
                                            data-dismiss="modal"
                                            onclick="SeleccionarProducto('<%=codigoProducto%>',
                                                                          '<%=descripcion%>');"
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
                        <button class="btn btn-warning" type="button" data-dismiss="modal" onclick="LimpiarProducto()">
                            Cancelar
                        </button>                  
                    
                    </div>
                </div>
            </div>
        </div> <!-- Fin Modal para mostrar y seleccionar Productos -->
        <!--Scripts-->    
        <script src="lib/jquery-validation/dist/jquery.validate.min.js" type="text/javascript"></script>        
        <script src="lib/jquery/dist/jquery.min.js" type="text/javascript"></script>
        <script src="lib/bootstrap/dist/js/bootstrap.bundle.js" type="text/javascript"></script>
        <script src="lib/DataTables/datatables.min.js" type="text/javascript"></script>
        <script src="lib/DataTables/DataTables-1.10.21/js/dataTables.bootstrap4.min.js" type="text/javascript"></script>
        <script>
            //cuando el documento esté listo
            //se deben de cargar las siguientes funciones
            $(document).ready(function (){
             
               $('#tablaProductos').dataTable({
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
            
                function SeleccionarProducto(codigoProducto, descripcion){
                    $("#txtIdProducto").val(codigoProducto);  
                    $("#txtDescripcion").val(descripcion);
                    $("#txtCantidadIngresada").focus();
                }
                function LimpiarProducto(){
                     $("#txtIdProducto").val("");  
                    $("#txtDescripcion").val("");
                }  
              
            
        </script>
    </body>
</html>

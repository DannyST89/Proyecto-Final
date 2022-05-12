<%-- 
    Document   : FrmAdminEmpleados
    Created on : 08/05/2022, 10:44:00 AM
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
            <div class="row">
                <div class="col-md-6 mx-auto">
                    <div class="card-header">            
                        <h1>Administrar Empleados</h1>
                    </div><br>
                     <%
                     
                        String id = request.getParameter("idCrearModificar");
                        int codigo = Integer.parseInt(id);
                        EntidadEmpleado empleado;
                        BLEmpleado logica = new BLEmpleado();
                        if(codigo > 0){
                            //cliente exite
                            empleado = logica.ObtenerUnEmpleado("ID_EMPLEADO="+id);                         
                        }else{
                            empleado = new EntidadEmpleado();
                            
                        }
                     %> <!-- al no tener jsp quiere decir que es un servlet -->
                     <form action="CrearModificarEmpleado" method="post" id="FrmEmpleado">
                            <div class="form-group  float-left">
                             <%if(codigo > 0){%> 
                               <label for="">ID Empleado</label>
                                <input 
                                    type="number"
                                    class="form-control" 
                                    id="txtIdEmpleado" 
                                    placeholder="ID Empleado" 
                                    name="txtIdEmpleado" 
                                    readonly 
                                    value="<%=empleado.getIdEmpleado()%>"
                                >    
                                <label for="">ID Empleado</label>
                            <%}else{%>
                             <input 
                                 class="form-control" 
                                 type="hidden"  
                                 id="txtIdEmpleado" 
                                 name="txtIdEmpleado" 
                                 readonly 
                                 value="-1">                               
                            <%}%>                        
                                </div>
                                <div class="form-group">
                                     <label for="floatingPassword">Nombre</label>
                                    <input  
                                        class="form-control"
                                        id="txtNombreEmpleado" 
                                        placeholder="Nombre" 
                                        name="txtNombreEmpleado" 
                                        value="<%=empleado.getNombre()%>"
                                    >                                   
                                </div>
                                <div class="form-group">
                                    <label for="floatingInput">Primer Apellido</label>
                                   <input  
                                       class="form-control" 
                                       id="Primer Apelldio" 
                                       placeholder="Primer Apelldio" 
                                       name="txtPrimerApellido" 
                                       value="<%=empleado.getPrimerApellido()%>"
                                     >
                                  
                                </div>  
                                <div class="form-group">
                                    <label for="floatingInput">Segundo Apellido</label>
                                   <input  
                                       class="form-control" 
                                       id="Segundo Apellido" 
                                       placeholder="Segundo Apellido" 
                                       name="txtSegundoApellido" 
                                       value="<%=empleado.getSegundoApellido()%>"
                                    >
                                </div>   
                                <div class="form-group">
                                    <label for="">Teléfono</label>
                                   <input  
                                       class="form-control" 
                                       id="txtTelefono" 
                                       placeholder="Teléfono" 
                                       name="txtTelefono" 
                                       value="<%=empleado.getTelefono()%>"
                                    >
                                   
                                </div> 
                                <div class="form-group">
                                      <label for="floatingInput">Correo Electrónico</label>
                                   <input  
                                       class="form-control" 
                                       id="txtCorreo" 
                                       placeholder="Correo Electrónico" 
                                       name="txtCorreo" 
                                       value="<%=empleado.getCorreo()%>"
                                    >
                                 
                                </div>  
                                <div class="form-group">
                                    <label for="">Dirección</label>
                                   <input  
                                       class="form-control" 
                                       id="txtDireccion" 
                                       placeholder="Dirección" 
                                       name="txtDireccion" 
                                       value="<%=empleado.getDireccion()%>"
                                    >
                                   
                                </div>  
                                <div class="form-group">
                                    <label>Cargo del Empleado </label>
                                    <select name="cboCargo" value="<%=empleado.getCargo()%>">
                                        <option>Administrador</option> 
                                        <option>Cajero</option>
                                        <option>Bodeguero</option>
                                    </select>
                                </div>
                                 
                                <div class="form-group">
                                    <label for="">Fecha de Ingreso</label>
                                   <input  
                                       type="date" 
                                       class="form-control" 
                                       id="txtFechaIngreso" 
                                       placeholder="Fecha de Ingreso" 
                                       name="txtFechaIngreso" 
                                       value="<%=empleado.getFechaIngreso()%>"
                                    >
                                   
                                </div>
                                <div class="form-group">
                                     <label for="">Nombre Usuario</label>
                                    <input  
                                        class="form-control" 
                                        id="txtNombreUsuario" 
                                        placeholder="Usuario" 
                                        name="txtNombreUsuario" 
                                        value="<%=empleado.getNombreUsuario()%>"
                                    >
                                   
                                </div>
                                <div class="form-group">
                                    <label for="">Contraseña</label>
                                    <input  
                                        class="form-control" 
                                        id="txtContrasenia" 
                                        placeholder="Contraseña" 
                                        name="txtContrasenia" 
                                        value="<%=empleado.getConstrasenia()%>"
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
                                            onclick="location.href='FrmEmpleado.jsp'"
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
                
                $("#FrmEmpleado").validate({                    
                    rules:{
                        txtNombreEmpleado:{required:true,maxlength:20},
                        txtPrimerApellido:{required:true,maxlength:20},
                        txtSegundoApellido:{required:true,maxlength:20},
                        
                        txtTelefono:{required:true,minlength:8,maxlength:20},
                        txtCorreo:{required:true,maxlength:30},
                        txtDireccion:{required:true,maxlength:100,
                        txtCargo:{required:true,maxlength:15},
                        txtFechaIngreso:{required:true},
                        txtContrasenia:{required:true,minlength:6,maxlength:15}
}
                    },
                    messages:{
                        txtNombreEmpleado:"El campo 'Nombre Empleado' es requerido, máximo 20 carácteres",
                        txtPrimerApellido:"El campo 'Primer Apellido' es requerido, máximo 20 carácteres",
                        txtSegundoApellido:"El campo 'Segundo Apellido' es requerido, máximo 20 carácteres",
                        txtTelefono:"El campo 'Teléfono' es requerido, mínimo 8 carácteres,máximo 20",
                        txtCorreo:"El campo 'Correo Electrónico' es requerido, máximo 30 carácteres"
                        txtDireccion:"El campo 'Dirección' es requerido, mínimo 8 carácteres,máximo 20",
                        txtCargo:"El campo 'Teléfono' es requerido, máximo 100",
                        txtFechaIngreso:"El campo 'Fecha de Ingreso' es requerido",
                        txtContrasenia:"El campo 'Contraseña' es requerido, mínimo 6 carácteres,máximo 15",
                    },
                    errorElement:'span'
                });
            });
            
        </script>
    </body>
</html>

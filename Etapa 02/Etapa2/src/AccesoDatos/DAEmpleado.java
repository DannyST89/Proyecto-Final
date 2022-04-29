
package AccesoDatos;

import Config.Config;
import Entidades.EntidadEmpleado;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class DAEmpleado {
    //Atributos
    private Connection _cnn;
    private String mensaje;
    
    //Propiedades
    public String getMensaje(){
        return mensaje;
    }
    //constructor que inicializa la la conexión
    public DAEmpleado() throws Exception{
        try
        {
            String url = Config.getConnectionString();
            _cnn = DriverManager.getConnection(url);
            mensaje = "";
        } catch (Exception ex)
        {
            throw ex;
        }
    }//Fin constructor
        //****************************************************************************
    //Método para insertar un empleado
    //recibimos como paramétro un objeto de tipo EntidadEmpleado que trae todos los miembros de la clase
    public int insertarEmpleado(EntidadEmpleado empleado) throws Exception{
        int idEmpleado = -1;
        String sentencia = "INSERT INTO EMPLEADOS(NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,TELEFONO,"
                         + "CORREO,DIRECCION,CARGO,FECHA_INGRESO,NOMBRE_USUARIO,CONTRASENIA) VALUES(?,?,?,?,?,?,?,?,?,?)";
   
        try
        {
            //Me permite enviar parámetros
            PreparedStatement sm = _cnn.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
            sm.setString(1, empleado.getNombre());
            sm.setString(2, empleado.getPrimerApellido());  
            sm.setString(3, empleado.getSegundoApellido());     
            sm.setString(4, empleado.getTelefono());   
            sm.setString(5, empleado.getCorreo());   
            sm.setString(6, empleado.getDireccion());    
            sm.setString(7, empleado.getCargo());    
            sm.setDate(8, (Date)empleado.getFechaIngreso());   
            sm.setString(9, empleado.getNombreUsuario()); 
            sm.setString(10, empleado.getConstrasenia());            
            sm.execute();
            ResultSet rs = sm.getGeneratedKeys();
            if(rs != null && rs.next()){
                idEmpleado = rs.getInt(1);
                mensaje = "Empleado ingresado satisfactoriamente ";
            }   
        } catch (Exception e)
        {
           throw e;
        } finally
        {   
             _cnn = null;
        }
        return idEmpleado;
    }//Fin método insertarEmpleado
    //****************************************************************************   
    //Método para modificar
    public int modificarEmpleado(EntidadEmpleado empleado) throws SQLException{
        int resultado = 0;
        String sentencia = "UPDATE EMPLEADOS SET NOMBRE=?,PRIMER_APELLIDO=?,SEGUNDO_APELLIDO=?,TELEFONO=?,"
                         + "CORREO=?,DIRECCION=?,CARGO=?,FECHA_INGRESO=?,NOMBRE_USUARIO=?,CONTRASENIA=? WHERE ID_EMPLEADO=?";
        
        try
        {
            java.util.Date date = Calendar.getInstance().getTime();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            ps.setString(1, empleado.getNombre()); 
            ps.setString(2, empleado.getPrimerApellido());    
            ps.setString(3, empleado.getSegundoApellido());    
            ps.setString(4, empleado.getTelefono());   
            ps.setString(5, empleado.getCorreo());  
            ps.setString(6, empleado.getDireccion());   
            ps.setString(7, empleado.getCargo());    
            ps.setDate(8, sqlDate);    
            ps.setString(9, empleado.getNombreUsuario());     
            ps.setString(10, empleado.getConstrasenia());   
            ps.setInt(11, empleado.getIdEmpleado());

            resultado = ps.executeUpdate();
            if(resultado > 0){
                mensaje = "Actualizado Correctamente";
            }                
        } catch (SQLException ex)
        {
            throw ex;
        } finally
        {
            _cnn = null;
        }
        return resultado;
    }//Fin void modificarEmpleado

    //****************************************************************************  
    //EliminarEmpleado
    public int eliminarEmpleado(EntidadEmpleado empleado) throws SQLException{
        int resultado = 0;
        String sentencia = "DELETE FROM EMPLEADOS WHERE ID_EMPLEADO = ?";
        try
        {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            ps.setInt(1, empleado.getIdEmpleado());
            if(resultado > 0){
                mensaje = "Empleado eliminado";
            }
            //SP_ELIMINAR_EMPLEADO
        } catch (SQLException ex)
        {
            throw ex;
        } finally
        {
            _cnn = null;
        }
        return resultado;
        
    }//Fin eliminarEmpleado
    //****************************************************************************   
    //Eliminar con procedimiento almacenado
    
    //**************************************************************************** 

    

    public List<EntidadEmpleado> listarEmpleados(String condicion) throws SQLException{
        ResultSet rs = null;
        List<EntidadEmpleado> lista = new ArrayList();
        
        try
        {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID_EMPLEADO,NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,TELEFONO,CORREO,"
                             + "DIRECCION,CARGO,FECHA_INGRESO,NOMBRE_USUARIO,CONTRASENIA,ESTADO FROM EMPLEADOS";
            if(!condicion.equals("")){
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new EntidadEmpleado(rs.getInt("ID_EMPLEADO"),
                                              rs.getString("NOMBRE"),
                                              rs.getString("PRIMER_APELLIDO"),
                                              rs.getString("SEGUNDO_APELLIDO"),
                                              rs.getString("TELEFONO"),
                                              rs.getString("CORREO"),
                                              rs.getString("DIRECCION"),
                                              rs.getString("CARGO"),
                                              rs.getDate("FECHA_INGRESO"),
                                              rs.getString("NOMBRE_USUARIO"),   
                                              rs.getString("CONTRASENIA"),
                                              rs.getString("ESTADO")
                ));
            }
        } catch (SQLException ex)
        {
            throw ex;
        }finally{
            _cnn = null;
        }
        return lista;
    }//Fin método listarEmpleados
    //**************************************************************************** 
    //Método para modificar un empleado
    public EntidadEmpleado ObtenerUnEmpleado(String condicion) throws SQLException{
           ResultSet rs = null;
           EntidadEmpleado empleado = new EntidadEmpleado();
           try {
               Statement stm = _cnn.createStatement();
               String sentencia = "SELECT ID_EMPLEADO,NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,TELEFONO,CORREO,"
                             + "DIRECCION,CARGO,FECHA_INGRESO,NOMBRE_USUARIO,CONTRASENIA,ESTADO FROM EMPLEADOS";
               if (!condicion.equals("")) {
                   sentencia = String.format("%s WHERE %s", sentencia, condicion);
               }
               rs = stm.executeQuery(sentencia);
               if (rs.next()) {
                   empleado.setIdEmpleado(rs.getInt(1));
                   empleado.setNombre(rs.getString(2));
                   empleado.setPrimerApellido(rs.getString(3));
                   empleado.setSegundoApellido(rs.getString(4));
                   empleado.setTelefono(rs.getString(5));   
                   empleado.setCorreo(rs.getString(6));                   
                   empleado.setDireccion(rs.getString(7));   
                   empleado.setCargo(rs.getString(8));    
                   empleado.setFechaIngreso(rs.getDate(9));
                   empleado.setNombreUsuario(rs.getString(10));    
                   empleado.setConstrasenia(rs.getString(11));
                   empleado.setExiste(true);
               }

           } catch (SQLException ex) {
               throw ex;
           } finally {
               _cnn = null;
           }
           return empleado;
    }
}//Fin DAEmpleado

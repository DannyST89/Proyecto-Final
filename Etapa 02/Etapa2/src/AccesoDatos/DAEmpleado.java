
package AccesoDatos;

import Config.Config;
import Entidades.EntidadEmpleado;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class DAEmpleado {
    //Atributos
    private Connection _cnn;
    private String mensaje;
    
    //Propiedades
    public String getMensaje(){
        return mensaje;
    }
    //constructor
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
                mensaje = "Cliente ingresado satisfactoriamente ";
            }   
        } catch (Exception e)
        {
           throw e;
        } finally
        {   
             _cnn = null;
        }
        return idEmpleado;
    }
}//Fin DAEmpleado

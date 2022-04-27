
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
        } catch (Exception ex)
        {
            throw ex;
        }finally{
            _cnn = null;
        }
        return lista;
    }//Fin método listarEmpleados
    //**************************************************************************** 
    //Método para modificar un empleado
    public int modificarEmpleado(EntidadEmpleado) throws SQLException {
        
    }
}//Fin DAEmpleado

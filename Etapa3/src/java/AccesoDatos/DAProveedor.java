
package AccesoDatos;

import Config.Config;
import Entidades.EntidadProveedor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;


public class DAProveedor {
    //Atributos
  
    private Connection _cnn;
    private String mensaje;
    //Propiedades
    public String getMensaje(){
        return mensaje;
    }
    //Constructor que inicia la conexión al instanciarce el objeto
    public DAProveedor() throws Exception{
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
    //*****************************************************************
    //método para insertar y actualizar un proveedor con procedimiento almacentado
    public int insertarProveedor(EntidadProveedor proveedor) throws SQLException{
        int resultado = -1;
        int id_Proveedor;
        
        try
        {
            CallableStatement cs = _cnn.prepareCall("{call SP_INSERTAR_PROVEEDOR(?,?,?,?,?,?,?,?)}");
            cs.setInt(1, proveedor.getId_proveedor());  
            cs.setString(2, proveedor.getNombreProveedor());      
            cs.setString(3, proveedor.getDireccion());       
            cs.setString(4, proveedor.getTelefono());     
            cs.setInt(5, proveedor.getExtension());    
            cs.setString(6, proveedor.getCorreo());      
            cs.setString(7, proveedor.getNumeroCuenta());
            cs.setString(8, mensaje);

            cs.registerOutParameter(1, Types.INTEGER);     
            cs.registerOutParameter(8, Types.VARCHAR);
            resultado = cs.executeUpdate();
            id_Proveedor = cs.getInt(1);
            
            mensaje  = cs.getString(8);
            
            
        } catch (Exception ex)
        {
            throw ex;
        }       
        return resultado;
    }//Fin insertarProveedor
    //****************************************************************************  
    //EliminarEmpleado
    public int eliminarProveedor(EntidadProveedor proveedor) throws SQLException{
        int resultado = -1;
        int id_Empleado;
        try
        {
            CallableStatement cs = _cnn.prepareCall("{call SP_ELIMINAR_PROVEEDOR(?,?)}");
            cs.setInt(1, proveedor.getId_proveedor());            
            cs.setString(2, mensaje);
            cs.registerOutParameter(1, Types.INTEGER);     
            cs.registerOutParameter(2, Types.VARCHAR);
            resultado = cs.executeUpdate();
            id_Empleado = cs.getInt(1);            
            mensaje  = cs.getString(2);            
            
        } catch (Exception ex)
        {
            throw ex;
        }       
        return resultado;
        
    }//Fin eliminarProveedor
    public List<EntidadProveedor> listarProveedor(String condicion) throws SQLException{
        ResultSet rs = null;
        List<EntidadProveedor> lista = new ArrayList();
        
        try
        {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID_PROVEEDOR,NOMBRE_PROVEEDOR,DIRECCION,TELEFONO,EXTENSION,CORREO,"
                             + "NUMERO_CUENTA, ESTADO FROM PROVEEDORES";
            if(!condicion.equals("")){
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new EntidadProveedor(rs.getInt("ID_PROVEEDOR"),
                                               rs.getString("NOMBRE_PROVEEDOR"),
                                               rs.getString("DIRECCION"),
                                               rs.getString("TELEFONO"),
                                               rs.getInt("EXTENSION"),
                                               rs.getString("CORREO"),
                                               rs.getString("NUMERO_CUENTA"), 
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
    public EntidadProveedor ObtenerUnProveedor(String condicion) throws SQLException{
           ResultSet rs = null;
           EntidadProveedor proveedor = new EntidadProveedor();
           try {
               Statement stm = _cnn.createStatement();
               String sentencia = "SELECT ID_PROVEEDOR,NOMBRE_PROVEEDOR,DIRECCION,TELEFONO,EXTENSION,CORREO,"
                                + "NUMERO_CUENTA FROM PROVEEDORES";
               if (!condicion.equals("")) {
                   sentencia = String.format("%s WHERE %s", sentencia, condicion);
               }
               rs = stm.executeQuery(sentencia);
               if (rs.next()) {
                   proveedor.setId_proveedor(rs.getInt(1));
                   proveedor.setNombreProveedor(rs.getString(2));
                   proveedor.setDireccion(rs.getString(3));
                   proveedor.setTelefono(rs.getString(4));  
                   proveedor.setExtension(rs.getInt(5));  
                   proveedor.setCorreo(rs.getString(6));                   
                   proveedor.setNumeroCuenta(rs.getString(7));   
                   proveedor.setExiste(true);
               }

           } catch (SQLException ex) {
               throw ex;
           } finally {
               _cnn = null;
           }
           return proveedor;
    }//fin ObtenerUnProveedor  
    //Método para modificar
    public int modificarProveedor(EntidadProveedor proveedor) throws SQLException{
        int resultado = 0;
        String sentencia = "UPDATE PROVEEDORES SET NOMBRE_PROVEEDOR=?,DIRECCION=?,TELEFONO=?,EXTENSION=?,"
                         + "CORREO=?,NUMERO_CUENTA=? WHERE ID_PROVEEDOR=?";
        
        try
        {
            
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            ps.setString(1, proveedor.getNombreProveedor()); 
            ps.setString(2, proveedor.getDireccion());    
            ps.setString(3, proveedor.getTelefono());    
            ps.setInt(4, proveedor.getExtension());   
            ps.setString(5, proveedor.getCorreo());  
            ps.setString(6, proveedor.getNumeroCuenta());  
            ps.setInt(7, proveedor.getId_proveedor()); 

               
           
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

}


package AccesoDatos;

import Config.Config;
import Entidades.EntidadProveedor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
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
    //método para insertar un proveedor con procedimiento almacentado
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
    public List<EntidadProveedor> listarProveedor(String condicion) throws SQLException{
        ResultSet rs = null;
        List<EntidadProveedor> lista = new ArrayList();
        
        try
        {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID_PROVEEDOR,NOMBRE_PROVEEDOR,DIRECCION,TELEFONO,EXTENSION,CORREO,"
                             + "NUMERO_CUENTA FROM PROVEEDORES";
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
                                              rs.getString("NUMERO_CUENTA")
                                              
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
}

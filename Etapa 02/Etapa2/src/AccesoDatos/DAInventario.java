
package AccesoDatos;

import Config.Config;
import Entidades.EntidadInventario;
import Entidades.EntidadProducto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;


public class DAInventario {
    //Atributos  
    private Connection _cnn;
    private String mensaje;
    //Propiedades
    public String getMensaje(){
        return mensaje;
    }
    //Constructor que inicia la conexión al instanciarce el objeto
    public DAInventario() throws Exception{
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
    //método para insertar y actualizar un inventario con procedimiento almacentado
    public int insertarInventario(EntidadInventario inventario) throws SQLException{
        int resultado = -1;
        int idInventario;
        
        try
        {
            CallableStatement cs = _cnn.prepareCall("{call SP_ACTUALIZAR_INVENTARIO(?,?,?,?,?,?,?)}");
            cs.setInt(1, inventario.getIdInventario());  
            cs.setInt(2, inventario.getIdProducto());      
            cs.setString(3, inventario.getDescripcion());       
            cs.setInt(4, inventario.getCantidadIngresada());     
            cs.setInt(5, inventario.getExistencia());   
            //cs.setInt(6, inventario.getCantidadVendida()); 
            cs.setString(6, inventario.getCodigoBarra());      
            cs.setString(7, mensaje);

            cs.registerOutParameter(1, Types.INTEGER);     
            cs.registerOutParameter(7, Types.VARCHAR);
            resultado = cs.executeUpdate();
            idInventario = cs.getInt(1);
            
            mensaje  = cs.getString(7);
            
            
        } catch (Exception ex)
        {
            throw ex;
        }       
        return resultado;
    }//Fin insertarInventario
    //****************************************************************************  
    //EliminarInventario
    public int eliminarInventario(EntidadInventario inventario) throws SQLException{
        int resultado = -1;
        int idInventario;
        try
        {
            CallableStatement cs = _cnn.prepareCall("{call SP_ELIMINAR_PRODUCTO_INVENTARIO(?,?)}");
            cs.setInt(1, inventario.getIdInventario());            
            cs.setString(2, mensaje);
            cs.registerOutParameter(1, Types.INTEGER);     
            cs.registerOutParameter(2, Types.VARCHAR);
            resultado = cs.executeUpdate();
            idInventario = cs.getInt(1);            
            mensaje  = cs.getString(2);            
            
        } catch (Exception ex)
        {
            throw ex;
        }       
        return resultado;
        
    }//Fin eliminarProveedor
    public List<EntidadInventario> listarInventario(String condicion) throws SQLException{
        ResultSet rs = null;
        List<EntidadInventario> lista = new ArrayList();
        
        try
        {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID_INVENTARIO,ID_PRODUCTO ,DESCRIPCION,CANTIDA_INGRESADA,EXISTENCIA,"
                             + "CANTIDAD_VENDIDA, CODIGO_BARRA FROM INVENTARIOS";
            if(!condicion.equals("")){
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new EntidadInventario(rs.getInt("ID_INVENTARIO"),
                                               rs.getInt("ID_PRODUCTO"),
                                               rs.getString("DESCRIPCION"),
                                               rs.getInt("CANTIDA_INGRESADA"),
                                               rs.getInt("EXISTENCIA"),
                                               rs.getInt("CANTIDAD_VENDIDA"),
                                               rs.getString("CODIGO_BARRA")

                                              
                ));
            }
        } catch (SQLException ex)
        {
            throw ex;
        }finally{
            _cnn = null;
        }
        return lista;
    }//Fin método listarInventario
    public EntidadInventario ObtenerUnInventario(String condicion) throws SQLException{
           ResultSet rs = null;
           EntidadInventario inventario = new EntidadInventario();
           try {
               Statement stm = _cnn.createStatement();
               String sentencia = "SELECT ID_INVENTARIO,ID_PRODUCTO ,DESCRIPCION,CANTIDA_INGRESADA,EXISTENCIA,"
                             + "CANTIDAD_VENDIDA, CODIGO_BARRA FROM INVENTARIOS";
               if (!condicion.equals("")) {
                   sentencia = String.format("%s WHERE %s", sentencia, condicion);
               }
               rs = stm.executeQuery(sentencia);
               if (rs.next()) {
                   inventario.setIdInventario(rs.getInt(1));
                   inventario.setIdProducto(rs.getInt(2));
                   inventario.setDescripcion(rs.getString(3));
                   inventario.setCantidadIngresada(rs.getInt(4));  
                   inventario.setExistencia(rs.getInt(5));  
                   inventario.setCantidadVendida(rs.getInt(6));                   
                   inventario.setCodigoBarra(rs.getString(7));   
                   inventario.setExiste(true);
               }

           } catch (SQLException ex) {
               throw ex;
           } finally {
               _cnn = null;
           }
           return inventario;
    }//fin ObtenerUnInventario  
     public EntidadProducto ObtenerUnProducto(String condicion) throws SQLException{
           ResultSet rs = null;
           EntidadProducto producto = new EntidadProducto();
           try {
               Statement stm = _cnn.createStatement();
               String sentencia = "SELECT ID_PRODUCTO,DESCRIPCION,CODIGO_BARRAS FROM PRODUCTOS";
               if (!condicion.equals("")) {
                   sentencia = String.format("%s WHERE %s", sentencia, condicion);
               }
               rs = stm.executeQuery(sentencia);
               if (rs.next()) {
                   producto.setIdProducto(rs.getInt(1));                
                   producto.setDescripcion(rs.getString(2));  
                   producto.setCodigoBarra(rs.getString(3));    
                   producto.setExiste(true);
               }

           } catch (SQLException ex) {
               throw ex;
           } finally {
               _cnn = null;
           }
           return producto;
    }//fin ObtenerUnProveedor  
}//Fin calse DAInventario

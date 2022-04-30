
package AccesoDatos;

import Config.Config;
import Entidades.EntidadProducto;
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


public class DAProducto {
    //Atributos 
     private Connection _cnn;
    private String mensaje;
    //Propiedades
    public String getMensaje(){
        return mensaje;
    }
    //Constructor que inicia la conexión al instanciarce el objeto
    public DAProducto() throws Exception{
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
    public int insertarProducto(EntidadProducto producto) throws SQLException{
        int resultado = -1;
        String id_Producto;
        
        try
        {
            CallableStatement cs = _cnn.prepareCall("{call SP_INSERTAR_PRODUCTO(?,?,?,?,?,?)}");
            cs.setInt(1, producto.getIdProducto());  
            cs.setInt(2, producto.getIdProveedor());      
            cs.setString(3, producto.getNombreProveedor());       
            cs.setString(4, producto.getDescripcion());
            cs.setDouble(5, producto.getPrecioUnidad());
     
            cs.setString(6, mensaje);

            cs.registerOutParameter(1, Types.INTEGER);     
            cs.registerOutParameter(6, Types.VARCHAR);
            resultado = cs.executeUpdate();
            id_Producto = cs.getString(1);
            
            mensaje  = cs.getString(6);
            
            
        } catch (Exception ex)
        {
            throw ex;
        }       
        return resultado;
    }//Fin insertarProducto
     public EntidadProveedor agregareProveedor(String condicion) throws SQLException{
        ResultSet rs = null;
        EntidadProveedor proveedor = new EntidadProveedor();
        
        try
        {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT NOMBRE_PROVEEDOR FROM PROVEEDORES";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            if (rs.next()) {
                    proveedor.setId_proveedor(rs.getInt(1));                
               }

            
        } catch (Exception ex)
        {
            throw ex;
        }       
        return proveedor;
    }//Fin insertarproveedor
     //***********************************************
     //obtener un producto
    public EntidadProducto ObtenerUnProducto(String condicion) throws SQLException{
           ResultSet rs = null;
           EntidadProducto producto = new EntidadProducto();
           try {
               Statement stm = _cnn.createStatement();
               String sentencia = "SELECT ID_PRODUCTO,ID_PROVEEDOR,NOMBRE_PROVEEDOR,DESCRIPCION,PRECIO_UNIDAD FROM PRODUCTOS";
               if (!condicion.equals("")) {
                   sentencia = String.format("%s WHERE %s", sentencia, condicion);
               }
               rs = stm.executeQuery(sentencia);
               if (rs.next()) {
                   producto.setIdProducto(rs.getInt(1));
                   producto.setIdProveedor(rs.getInt(2));
                   producto.setNombreProveedor(rs.getString(3));                   
                   producto.setDescripcion(rs.getString(4));  
                   producto.setPrecioUnidad(rs.getDouble(5));    
                   producto.setExiste(true);
               }

           } catch (SQLException ex) {
               throw ex;
           } finally {
               _cnn = null;
           }
           return producto;
    }//fin ObtenerUnProveedor  
    public List<EntidadProducto> listarProductos(String condicion) throws SQLException{
        ResultSet rs = null;
        List<EntidadProducto> lista = new ArrayList();
        
        try
        {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID_PRODUCTO,ID_PROVEEDOR,NOMBRE_PROVEEDOR,DESCRIPCION,PRECIO_UNIDAD FROM PRODUCTOS";
            if(!condicion.equals("")){
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new EntidadProducto(rs.getInt("ID_PRODUCTO"),
                                               rs.getInt("ID_PROVEEDOR"),
                                               rs.getString("NOMBRE_PROVEEDOR"),
                                               rs.getString("DESCRIPCION"),
                                               rs.getDouble("PRECIO_UNIDAD")                                              

                                              
                ));
            }
        } catch (SQLException ex)
        {
            throw ex;
        }finally{
            _cnn = null;
        }
        return lista;
    }//Fin método listarProductos
    //****************************************************************************  
    //EliminarProducto
    public int eliminarProducto(EntidadProducto producto) throws SQLException{
        int resultado = -1;
        int id_producto;
        try
        {
            CallableStatement cs = _cnn.prepareCall("{call SP_ELIMINAR_PRODUCTO(?,?)}");
            cs.setInt(1, producto.getIdProducto());            
            cs.setString(2, mensaje);
            cs.registerOutParameter(1, Types.INTEGER);     
            cs.registerOutParameter(2, Types.VARCHAR);
            resultado = cs.executeUpdate();
            id_producto = cs.getInt(1);            
            mensaje  = cs.getString(2);            
            
        } catch (Exception ex)
        {
            throw ex;
        }       
        return resultado;
        
    }//Fin eliminarProveedor
    
}


package AccesoDatos;

import Config.Config;
import Entidades.EntidadFactura;
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


public class DAFactura {
    
    private Connection _cnn;
    private String mensaje;
    //Propiedades
    public String getMensaje(){
        return mensaje;
    }
    //Constructor que inicia la conexión al instanciarce el objeto
    public DAFactura() throws Exception{
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
    public int insertarFactura(EntidadFactura factura) throws SQLException{
        int resultado = -1;
        int idFactura;
        
        try
        {
            CallableStatement cs = _cnn.prepareCall("{call SP_INSERTAR_FACTURA(?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, factura.getIdFactura());   
            cs.setInt(2, factura.getIdImpleado());       
            cs.setInt(3, factura.getIdProducto());     
            cs.setString(4, factura.getDescripcion());    
            cs.setInt(5, factura.getCantidad());      
            cs.setDouble(6, factura.getPrecioUnidad());            
            cs.setDouble(7, factura.getSubtotal());
            cs.setDouble(8, factura.getIva());
            cs.setDouble(9, factura.getDescuento());
            cs.setDouble(10, factura.getTotal());

            cs.setString(11, mensaje);

            cs.registerOutParameter(1, Types.INTEGER);     
            cs.registerOutParameter(11, Types.VARCHAR);
            resultado = cs.executeUpdate();
            idFactura = cs.getInt(1);
            
            mensaje  = cs.getString(11);
            
            
        } catch (Exception ex)
        {
            throw ex;
        }       
        return resultado;
    }//Fin insertarFactura
    public List<EntidadFactura> listarFactura(String condicion) throws SQLException{
        ResultSet rs = null;
        List<EntidadFactura> lista = new ArrayList();
        
        try
        {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID_FACTURA,ID_EMPLEADO,ID_PRODUCTO,DESCRIPCION,CANTIDAD,PRECIO_UNIDAD,"
                             + "SUBTOTAL,IVA,DESCUENTO,TOTAL FROM FACTURAS";
            if(!condicion.equals("")){
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new EntidadFactura(rs.getInt("ID_FACTURA"),
                                               rs.getInt("ID_EMPLEADO"),
                                               rs.getInt("ID_PRODUCTO"),
                                               rs.getString("DESCRIPCION"),
                                               rs.getInt("CANTIDAD"),
                                               rs.getDouble("PRECIO_UNIDAD"),
                                               rs.getDouble("SUBTOTAL"), 
                                               rs.getDouble("IVA"), 
                                               rs.getInt("DESCUENTO"),
                                               rs.getDouble("TOTAL")
                                              
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
    public EntidadFactura ObtenerUnaFactura(String condicion) throws SQLException{
           ResultSet rs = null;
           EntidadFactura factura = new EntidadFactura();
           try {
               Statement stm = _cnn.createStatement();
               String sentencia = "SELECT ID_FACTURA,ID_EMPLEADO,ID_PRODUCTO,DESCRIPCION,CANTIDAD,PRECIO_UNIDAD,"
                             + "SUBTOTAL,IVA,DESCUENTO,TOTAL FROM FACTURAS";
               if (!condicion.equals("")) {
                   sentencia = String.format("%s WHERE %s", sentencia, condicion);
               }
               rs = stm.executeQuery(sentencia);
               if (rs.next()) {
                   factura.setIdFactura(rs.getInt(1));
                   factura.setIdImpleado(rs.getInt(2));
                   factura.setIdProducto(rs.getInt(3));
                   factura.setDescripcion(rs.getString(4));  
                   factura.setCantidad(rs.getInt(5));  
                   factura.setPrecioUnidad(rs.getDouble(6));                   
                   factura.setSubtotal(rs.getDouble(7));   
                   factura.setIva(rs.getDouble(8));   
                   factura.setDescuento(rs.getInt(9));   
                   factura.setTotal(rs.getDouble(10));   

                   factura.setExiste(true);
               }

           } catch (SQLException ex) {
               throw ex;
           } finally {
               _cnn = null;
           }
           return factura;
    }//fin ObtenerUnaFactura
    public EntidadProducto ObtenerUnProducto(String condicion) throws SQLException{
           ResultSet rs = null;
           EntidadProducto producto = new EntidadProducto();
           try {
               Statement stm = _cnn.createStatement();
               String sentencia = "SELECT ID_PRODUCTO,DESCRIPCION FROM PRODUCTOS";
               if (!condicion.equals("")) {
                   sentencia = String.format("%s WHERE %s", sentencia, condicion);
               }
               rs = stm.executeQuery(sentencia);
               if (rs.next()) {
                   producto.setIdProducto(rs.getInt(1));                
                   producto.setDescripcion(rs.getString(2));  
                   producto.setExiste(true);
               }

           } catch (SQLException ex) {
               throw ex;
           } finally {
               _cnn = null;
           }
           return producto;
    }//fin ObtenerUnProveedor  
    public int eliminarFactura(EntidadFactura factura) throws SQLException{
        int resultado = -1;
        int idFactura;
        try
        {
            CallableStatement cs = _cnn.prepareCall("{call SP_ELIMINAR_FACTURA(?,?)}");
            cs.setInt(1, factura.getIdFactura());            
            cs.setString(2, mensaje);
            cs.registerOutParameter(1, Types.INTEGER);     
            cs.registerOutParameter(2, Types.VARCHAR);
            resultado = cs.executeUpdate();
            idFactura = cs.getInt(1);            
            mensaje  = cs.getString(2);            
            
        } catch (Exception ex)
        {
            throw ex;
        }       
        return resultado;
        
    }//Fin eliminarProveedor
}//fin DAFactura

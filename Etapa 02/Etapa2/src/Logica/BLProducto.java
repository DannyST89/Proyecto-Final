
package Logica;

import AccesoDatos.DAProducto;
import AccesoDatos.DAProveedor;
import Entidades.EntidadProducto;
import Entidades.EntidadProveedor;
import java.util.ArrayList;
import java.util.List;


public class BLProducto {
    //Atributos
    private String mensaje;    
    //Método de acceso
    public String getMensaje(){
        return mensaje;
    }
    //Cosntructor
    public int insertarProducto(EntidadProducto producto) throws Exception{
        DAProducto datosProducto;
        int id = -1;
        try
        {
            datosProducto= new DAProducto();
            id = datosProducto.insertarProducto(producto);
            mensaje = datosProducto.getMensaje();
        } catch (Exception ex)
        {
            throw ex;
        }
        return id;
    }//Fin método insertarProducto
    //*******************************************
    //mediante el código agregamos el proveedor y el 
     public EntidadProveedor agregarProveedor(String condicion) throws Exception{
         EntidadProveedor resultado;
        DAProveedor datosProveedor;

        try
        {
            datosProveedor = new DAProveedor();
            resultado = datosProveedor.ObtenerUnProveedor(condicion);

        } catch (Exception ex)
        {
            throw ex;
        }
        return resultado;
    }//Fin método insertarPrveedir
     //*******************************************
    //mediante el código agregamos el proveedor y el 
     public EntidadProducto ObtenerUnProducto(String condicion) throws Exception{
         EntidadProducto resultado;
        DAProducto datosProducto;

        try
        {
            datosProducto = new DAProducto();
            resultado = datosProducto.ObtenerUnProducto(condicion);
        } catch (Exception ex)
        {
            throw ex;
        }
        return resultado;
    }//Fin método insertarProducto
     //**********************************************************    
    //método para listarProveedor
    public List<EntidadProducto> ListarProducto(String condicion) throws Exception{
        List<EntidadProducto> producto = new ArrayList();
        DAProducto datosProducto;
        try {
            datosProducto = new DAProducto();
            producto = datosProducto.listarProductos(condicion);
            mensaje = datosProducto.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
         return producto;
    }//Fin método ListarProducto
    //**********************************************************   
    //Eliminar producto
    public int eliminarProducto(EntidadProducto producto) throws Exception{
        int resultado = -1;
        DAProducto datosProducto = new DAProducto();
       
        try
        {
            resultado = datosProducto.eliminarProducto(producto);
            mensaje = datosProducto.getMensaje();
        } catch (Exception ex)
        {
            throw ex;
        }
        return resultado;
    }
    //**********************************************************    
}

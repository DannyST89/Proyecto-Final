
package Logica;

import AccesoDatos.DAInventario;
import AccesoDatos.DAProducto;
import Entidades.EntidadInventario;
import Entidades.EntidadProducto;
import java.util.ArrayList;
import java.util.List;


public class BLInventario {
    
    //Atributos
    private String mensaje;    
    //Método de acceso
    public String getMensaje(){
        return mensaje;
    }
    //Cosntructor
    public int insertarInventario(EntidadInventario inventario) throws Exception{
        DAInventario datosInventario;
        int id = -1;
        try
        {
            datosInventario = new DAInventario();
            id = datosInventario.insertarInventario(inventario);
            mensaje = datosInventario.getMensaje();
        } catch (Exception ex)
        {
            throw ex;
        }
        return id;
    }//Fin método insertarInventario
    //**********************************************************    
     //**********************************************************   
    //Eliminar Inventario
    public int eliminarInventario(EntidadInventario inventario) throws Exception{
        int resultado = -1;
        DAInventario datosInventario = new DAInventario();
       
        try
        {
            resultado = datosInventario.eliminarInventario(inventario);
            mensaje = datosInventario.getMensaje();
        } catch (Exception ex)
        {
            throw ex;
        }
        return resultado;
    }
    //**********************************************************    
    //método para listarInventario
    public List<EntidadInventario> ListarInventario(String condicion) throws Exception{
        List<EntidadInventario> inventario = new ArrayList();
        DAInventario datosInventario;
        try {
            datosInventario = new DAInventario();
            inventario = datosInventario.listarInventario(condicion);
            mensaje = datosInventario.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
         return inventario;
    }//Fin método ListarInventario
    //*******************************************************
     public EntidadInventario ObtenerUnInventario(String condicion) throws Exception{
        EntidadInventario resultado;
        DAInventario datosInventario;
        try {
            datosInventario = new DAInventario();
            resultado = datosInventario.ObtenerUnInventario(condicion);
            if (resultado.isExiste()) {
                mensaje = "Proveedor encontrado";
            }
            else{
                mensaje = "No se encontraron registros";
            }
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
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
}//Fin BLInventario

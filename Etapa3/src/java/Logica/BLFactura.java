
package Logica;

import AccesoDatos.DAFactura;
import AccesoDatos.DAProducto;
import Entidades.EntidadFactura;
import Entidades.EntidadProducto;
import java.util.ArrayList;
import java.util.List;


public class BLFactura {
   
   //Atributos
    private String mensaje;    
    //Método de acceso
    public String getMensaje(){
        return mensaje;
    }
   
    public int insertarFactura(EntidadFactura factura) throws Exception{
        DAFactura datosFactura;
        int id = -1;
        try
        {
            datosFactura = new DAFactura();
            id = datosFactura.insertarFactura(factura);
            mensaje = datosFactura.getMensaje();
        } catch (Exception ex)
        {
            throw ex;
        }
        return id;
    }//Fin método insertarFactura
     public List<EntidadFactura> ListarFactura(String condicion) throws Exception{
        List<EntidadFactura> factura = new ArrayList();
        DAFactura datosFactura;
        try {
            datosFactura = new DAFactura();
            factura = datosFactura.listarFactura(condicion);
            mensaje = datosFactura.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
         return factura;
    }//Fin método ListarFactura
     public EntidadFactura ObtenerUnaFactura(String condicion) throws Exception{
        EntidadFactura resultado;
        DAFactura datosFactura;
        try {
            datosFactura = new DAFactura();
            resultado = datosFactura.ObtenerUnaFactura(condicion);
            if (resultado.isExiste()) {
                mensaje = "Factura encontrada";
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
      public int eliminarFactura(EntidadFactura factura) throws Exception{
        int resultado = -1;
        DAFactura datosFactura = new DAFactura();
       
        try
        {
            resultado = datosFactura.eliminarFactura(factura);
            mensaje = datosFactura.getMensaje();
        } catch (Exception ex)
        {
            throw ex;
        }
        return resultado;
    }
}//Fin de la clase BLFactura


package Logica;

import AccesoDatos.DAProveedor;
import Entidades.EntidadProveedor;
import java.util.ArrayList;
import java.util.List;


public class BLProveedor {
    //Atributos
    private String mensaje;    
    //Método de acceso
    public String getMensaje(){
        return mensaje;
    }
    //Cosntructor
    public int insertarProveedor(EntidadProveedor proveedor) throws Exception{
        DAProveedor datosProveedor;
        int id = -1;
        try
        {
            datosProveedor= new DAProveedor();
            id = datosProveedor.insertarProveedor(proveedor);
            mensaje = datosProveedor.getMensaje();
        } catch (Exception ex)
        {
            throw ex;
        }
        return id;
    }//Fin método insertarProveedor
    //**********************************************************    
     //**********************************************************   
    //Eliminar PROVEEDOR
    public int eliminarProveedor(EntidadProveedor proveedor) throws Exception{
        int resultado = -1;
        DAProveedor datosProveedor = new DAProveedor();
       
        try
        {
            resultado = datosProveedor.eliminarProveedor(proveedor);
            mensaje = datosProveedor.getMensaje();
        } catch (Exception ex)
        {
            throw ex;
        }
        return resultado;
    }
    //**********************************************************    
    //método para listarProveedor
    public List<EntidadProveedor> ListarProveedor(String condicion) throws Exception{
        List<EntidadProveedor> proveedor = new ArrayList();
        DAProveedor datosProveedor;
        try {
            datosProveedor = new DAProveedor();
            proveedor = datosProveedor.listarProveedor(condicion);
            mensaje = datosProveedor.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
         return proveedor;
    }//Fin método ListarProveedor
    //*******************************************************
     public EntidadProveedor ObtenerUnProveedor(String condicion) throws Exception{
        EntidadProveedor resultado;
        DAProveedor datosProveedor;
        try {
            datosProveedor = new DAProveedor();
            resultado = datosProveedor.ObtenerUnProveedor(condicion);
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
}

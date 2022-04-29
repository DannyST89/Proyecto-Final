
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
    public int insertarEmpleado(EntidadProveedor proveedor) throws Exception{
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
    }//Fin método insertarEmpleados
    //**********************************************************    

    //método para listarEmpleados
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
    }//Fin método ListarEmpleamdos
}

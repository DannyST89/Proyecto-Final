
package Logica;

import AccesoDatos.DAEmpleado;
import Entidades.EntidadEmpleado;//Importamos la entidadEmpleado


public class BLEmpleado {
    //Atributos
    private String mensaje;
    
    
    public String getMensaje(){
        return mensaje;
    }
    //Método Insertar un empleado
    public int insertarEmpleado(EntidadEmpleado Empleado) throws Exception{
        DAEmpleado datosEmpleado;
        int id = -1;
        try
        {
            datosEmpleado = new DAEmpleado();
            id = datosEmpleado.insertarEmpleado(Empleado);
            mensaje = datosEmpleado.getMensaje();
        } catch (Exception e)
        {
            throw e;
        }
        return id;
    }
}//Fin clase BLEmpleado


package Logica;

import AccesoDatos.DAEmpleado;
import Entidades.EntidadEmpleado;//Importamos la entidadEmpleado
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


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
    }//Fin método insertarEmpleados
    //**********************************************************
    //método para listarEmpleados
   public List<EntidadEmpleado> ListarClientes(String condicion) throws Exception{
        List<EntidadEmpleado> empleado = new ArrayList();
        DAEmpleado datosEmpleado;
        try {
            datosEmpleado = new DAEmpleado();
            empleado = datosEmpleado.listarEmpleados(condicion);
        } catch (Exception ex) {
            throw ex;
        }
        return empleado;
    }
}//Fin clase BLEmpleado

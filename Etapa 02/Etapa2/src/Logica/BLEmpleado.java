
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
    //Modificar un empleado
    public int modificarEmpleado(EntidadEmpleado empleado) throws Exception{
        int resultado = -1;
        DAEmpleado datosEmpleado;
        try
        {
            datosEmpleado = new DAEmpleado();
            resultado = datosEmpleado.modificarEmpleado(empleado);
            mensaje = datosEmpleado.getMensaje();
        } catch (Exception ex)
        {
            throw ex;
        }
        return resultado;
    }

    //**********************************************************   
    //Eliminar empleado
    public int eliminarEmpleado(EntidadEmpleado empleado) throws Exception{
        int resultado = -1;
        DAEmpleado datosEmpleado = new DAEmpleado();
       
        try
        {
            resultado = datosEmpleado.eliminarEmpleado(empleado);
            mensaje = datosEmpleado.getMensaje();
        } catch (Exception ex)
        {
            throw ex;
        }
        return resultado;
    }
    
    //**********************************************************    

    //método para listarEmpleados
   public List<EntidadEmpleado> ListarEmpleados(String condicion) throws Exception{
        List<EntidadEmpleado> empleado = new ArrayList();
        DAEmpleado datosEmpleado;
        try {
            datosEmpleado = new DAEmpleado();
            empleado = datosEmpleado.listarEmpleados(condicion);
        } catch (Exception ex) {
            throw ex;
        }
         return empleado;
    }//Fin método ListarEmpleamdos
    public EntidadEmpleado ObtenerUnEmpleado(String condicion) throws Exception{
        EntidadEmpleado resultado;
        DAEmpleado datosEmpleado;
        try {
            datosEmpleado = new DAEmpleado();
            resultado = datosEmpleado.ObtenerUnEmpleado(condicion);
            if (resultado.isExiste()) {
                mensaje = "Empleado encontrado";
            }
            else{
                mensaje = "No se encontraron registros";
            }
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
}//Fin clase BLEmpleado

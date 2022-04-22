
package Entidades;

import java.util.Date;


public class EntidadEmpleado {
    //Atributos
    private int idEmpleado;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String telefono;
    private String correo;
    private String direccion;
    private String cargo;
    private Date fechaIngreso;
    private String nombreUsuario;
    private String constrasenia;
    private String estado;
    private boolean existe;
    
    //Creámos los constructores de la clase
    //Con parámetros    
    public EntidadEmpleado(int idEmpleado, String nombre, String primerApellido, String segundoApellido, 
                           String telefono, String correo, String direccion, String cargo, Date fechaIngreso,
                           String nombreUsuario, String constrasenia, String estado, boolean existe){
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.cargo = cargo;
        this.fechaIngreso = fechaIngreso;
        this.nombreUsuario = nombreUsuario;
        this.constrasenia = constrasenia;
        this.estado = estado;
        this.existe = existe;
        
    }
    //Vacío 
    public EntidadEmpleado() {
        idEmpleado = 0;
        nombre = "";
        primerApellido = "";
        segundoApellido = "";
        telefono = "";
        correo = "";
        direccion = "";
        cargo = "";
        fechaIngreso = fechaIngreso;
        nombreUsuario = "";
        constrasenia = "";
        estado = "";
        existe = false;
        
    }
    //Creámos las propiedades 
    //Getter

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCargo() {
        return cargo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getConstrasenia() {
        return constrasenia;
    }

    public String getEstado() {
        return estado;
    }

    public boolean isExiste() {
        return existe;
    }
    //Setter

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setConstrasenia(String constrasenia) {
        this.constrasenia = constrasenia;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }
    
    
}//Fin clase EntidadEmpleado

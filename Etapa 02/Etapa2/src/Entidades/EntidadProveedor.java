
package Entidades;

import java.sql.Date;


public class EntidadProveedor {
    private int id_proveedor;
    private String nombreProveedor;
    private String direccion;
    private String telefono;
    private int extension;
    private String correo;
    private String numeroCuenta;
    private String estado;
    private boolean existe;
    //Constructor
    //con parámetros
    public EntidadProveedor(int id_proveedor, String nombreProveedor, String direccion, String telefono, int extension, String correo, String numeroCuenta,String estado, boolean existe) {
        this.id_proveedor = id_proveedor;
        this.nombreProveedor = nombreProveedor;
        this.direccion = direccion;
        this.telefono = telefono;
        this.extension = extension;
        this.correo = correo;
        this.numeroCuenta = numeroCuenta;
        this.estado = estado;
        this.existe = existe;
    }
      public EntidadProveedor(int id_proveedor, String nombreProveedor, String direccion, String telefono, int extension, String correo, String numeroCuenta,String estado) {
        this.id_proveedor = id_proveedor;
        this.nombreProveedor = nombreProveedor;
        this.direccion = direccion;
        this.telefono = telefono;
        this.extension = extension;
        this.correo = correo;
        this.numeroCuenta = numeroCuenta;
        this.estado = estado;
        this.existe = existe;
    }
    //Vacío
    public EntidadProveedor() {
        id_proveedor = 0;
        nombreProveedor = "";
        direccion = "";
        telefono = "";
        extension = 0;
        correo = "";
        numeroCuenta = "";
        estado = "";
        existe = false;
    }
    //Propiedades
    //Getter

    

    public int getId_proveedor() {
        return id_proveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getExtension() {
        return extension;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    public String getEstado() {
        return estado;
    }
    public boolean isExiste() {
        return existe;
    }
    //Setter

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setExiste(boolean existe) {
        this.existe = existe;
    }
}


package Entidades;


public class EntidadProducto {
    //Atributos
    private int idProducto;
    private int idProveedor;
    private String nombreProveedor;
    private String descripcion;
    private double precioUnidad;
    private boolean existe;
    //Agregamos los constructores

    public EntidadProducto(int idProducto, int idProveedor, String nombreProveedor, String descripcion, double precioUnidad, boolean existe) {
        this.idProducto = idProducto;
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.descripcion = descripcion;
        this.precioUnidad = precioUnidad;
        this.existe = existe;
    }    
    public EntidadProducto(int idProducto, int idProveedor, String nombreProveedor, String descripcion, double precioUnidad) {
        this.idProducto = idProducto;
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.descripcion = descripcion;
        this.precioUnidad = precioUnidad;
    }    
    
    public EntidadProducto() {
        idProducto = 0;
        idProveedor = 0;
        nombreProveedor = "";
        descripcion = "";
        precioUnidad = 0;
        existe = false;
    }
    //Propiedades
    //Getter
    public int getIdProducto() {
        return idProducto;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }
       public boolean isExiste() {
        return existe;
    }
    //Setter
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }  
    
}//Fin clase EntidadProducto

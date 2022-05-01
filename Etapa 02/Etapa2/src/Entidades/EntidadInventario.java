
package Entidades;


public class EntidadInventario {
    //Atributos
    private int idInventario;
    private int idProducto;
    private String descripcion;
    private int cantidadIngresada;
    private int existencia;
    private int cantidadVendida;
    private double precioUnidad;
    private boolean existe;
    //Constructores

    public EntidadInventario(int idInventario, int idProducto, String descripcion, int cantidadIngresada, int existencia, int cantidadVendida, double precioUnidad,boolean existe) {
        this.idInventario = idInventario;
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.cantidadIngresada = cantidadIngresada;
        this.existencia = existencia;
        this.cantidadVendida = cantidadVendida;
        this.precioUnidad = precioUnidad;
        this.existe = existe;
    }
     public EntidadInventario(int idInventario, int idProducto, String descripcion, int cantidadIngresada, int existencia, int cantidadVendida, double precioUnidad) {
        this.idInventario = idInventario;
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.cantidadIngresada = cantidadIngresada;
        this.existencia = existencia;
        this.cantidadVendida = cantidadVendida;
        this.precioUnidad = precioUnidad;
    }
     public EntidadInventario() {
        idInventario = 0;
        idProducto = 0;
        descripcion = "";
        cantidadIngresada = 0;
        existencia = 0;
        cantidadVendida = 0;
        precioUnidad = 0;
    }
    //métodos de acceso
     //Getter 
    public int getIdInventario() {
        return idInventario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidadIngresada() {
        return cantidadIngresada;
    }

    public int getExistencia() {
        return existencia;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public boolean isExiste() {
        return existe;
    }
     //Setter

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidadIngresada(int cantidadIngresada) {
        this.cantidadIngresada = cantidadIngresada;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }
    
}//Fin etidadInventario

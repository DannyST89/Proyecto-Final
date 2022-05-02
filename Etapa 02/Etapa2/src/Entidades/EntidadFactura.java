
package Entidades;


public class EntidadFactura {
    //Atributos
    private int idFactura;
    private int idImpleado;
    private int idProducto;
    private String descripcion;
    private int cantidad;
    private double precioUnidad;
    private double subtotal;
    private double iva;
    private int descuento;
    private double total;
    private boolean existe;
    //constructor

    public EntidadFactura(int idFactura, int idImpleado, int idProducto, String descripcion, int cantidad, double precioUnidad, double subtotal, double iva, int descuento, double total, boolean existe) {
        this.idFactura = idFactura;
        this.idImpleado = idImpleado;
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
        this.subtotal = subtotal;
        this.iva = iva;
        this.descuento = descuento;
        this.total = total;
        this.existe = existe;
    }
    public EntidadFactura(int idFactura, int idImpleado, int idProducto, String descripcion, int cantidad, double precioUnidad, double subtotal, double iva, int descuento, double total) {
        this.idFactura = idFactura;
        this.idImpleado = idImpleado;
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
        this.subtotal = subtotal;
        this.iva = iva;
        this.descuento = descuento;
        this.total = total;
    }
    public EntidadFactura() {
        idFactura = 0;
        idImpleado = 0;
        idProducto = 0;
        descripcion = "";
        cantidad = 0;
        precioUnidad = 0;
        subtotal = 0;
        iva = 0;
        descuento = 0;
        total = 0;
        existe = false;
    }
    //métodos de acceso
    //Getter
    public int getIdFactura() {
        return idFactura;
    }

    public int getIdImpleado() {
        return idImpleado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getIva() {
        return iva;
    }

    public int getDescuento() {
        return descuento;
    }

    public double getTotal() {
        return total;
    }

    public boolean isExiste() {
        return existe;
    }
    //Setter

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public void setIdImpleado(int idImpleado) {
        this.idImpleado = idImpleado;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    } 
}//Fin EntidadFactura


package Modelo;


public class DetalleVenta {
    
    private int id_celular;
    private int cantidad;
    private double subtotal;
    private int id_venta;

    public DetalleVenta(int id_celular, int cantidad, double subtotal, int id_venta) {
        this.id_celular = id_celular;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.id_venta = id_venta;
    }

    public DetalleVenta() {
    }

    
    
    public double calcularSubtotal(double precioCelular, int cantidadCelular){
        double subTotal = precioCelular * cantidadCelular;
        return subTotal;
    }

    public int getId_celular() {
        return id_celular;
    }

    public void setId_celular(int id_celular) {
        this.id_celular = id_celular;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }
    
    
    
}

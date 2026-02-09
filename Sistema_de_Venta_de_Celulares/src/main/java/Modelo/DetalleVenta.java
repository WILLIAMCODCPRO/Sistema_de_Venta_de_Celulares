
package Modelo;


public class DetalleVenta {
    
    private int id_celular;
    private int cantidad;
    private double subtotal;
    private Venta id_venta;

    public DetalleVenta(int id_celular, int cantidad) {
        this.id_celular = id_celular;
        this.cantidad = cantidad;
    }
    
    
    
}

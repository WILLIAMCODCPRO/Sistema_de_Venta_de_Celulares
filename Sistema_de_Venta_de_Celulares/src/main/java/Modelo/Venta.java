
package Modelo;

import java.time.LocalDateTime;

public class Venta {
    private int id_venta;
    private int id_cliente;
    private LocalDateTime fecha;
    private double total;

    public Venta(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Venta() {
    }

    public double calcularTotal(double subtotal){
        return subtotal * 1.19;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}

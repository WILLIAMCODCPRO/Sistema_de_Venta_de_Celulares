package Modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Factura implements Serializable{
    private String nombreCliente;
    private LocalDateTime fecha;
    private String modeloCelular;
    private int cantidad;
    private double total;

    public Factura(String nombreCliente, LocalDateTime fecha, String modeloCelular, int cantidad, double total) {
        this.nombreCliente = nombreCliente;
        this.fecha = fecha;
        this.modeloCelular = modeloCelular;
        this.cantidad = cantidad;
        this.total = total;
    }

       @Override
public String toString() {
    return """
           -----------------------
                 Factura
           
           Cliente:        %s
           Fecha:          %s
           -----------------------
           Modelo:         %s
           Cantidad:       %s
           Total venta:    %s
           ------------------------
           """.formatted(nombreCliente, fecha, modeloCelular, cantidad, total);
}
    
}

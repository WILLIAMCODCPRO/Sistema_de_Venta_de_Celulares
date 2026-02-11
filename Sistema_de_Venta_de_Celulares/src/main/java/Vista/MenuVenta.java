package Vista;

import Modelo.Factura;
import Utilidades.Mensaje;

public class MenuVenta implements Menu {

    @Override
    public void mostrarMenu() {
        System.out.println("""
                       ******************************
                       1.   Registrar Venta.
                       2.   Listar Ventas
                       3.   Salir.
                       ******************************
                       """);
        Mensaje.crearMensajePersonalizado("Que accion deseas realizar");
    }

    public void listar(String factura) {
        Mensaje.crearMensajePersonalizado(factura);
    }

    public void generarFactura(Factura factura) {

        System.out.println(factura);
    }

        
}

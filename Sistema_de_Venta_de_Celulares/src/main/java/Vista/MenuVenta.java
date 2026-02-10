package Vista;

import Modelo.Factura;
import Utilidades.Mensaje;
import java.util.ArrayList;


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
     
      public void listar(ArrayList<Factura> factura) {
        if (factura.isEmpty()) {
            Mensaje.crearMensajePersonalizado("No hay facturas registrados.");
        } else {
            factura.forEach(System.out::println);
        }
      }
      
        public void generarFactura(Factura factura) {
        
            System.out.println(factura);
        }
        
        
}

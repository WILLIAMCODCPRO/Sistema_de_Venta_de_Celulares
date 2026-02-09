package Vista;

import Utilidades.Mensaje;


public class MenuVenta {
     public void mostrarMenu() {
        System.out.println("""
                       ******************************
                       1.   Registrar Venta.
                       2.   Salir.
                       ******************************
                       """);
        Mensaje.crearMensajePersonalizado("Que accion deseas realizar");
    }
}

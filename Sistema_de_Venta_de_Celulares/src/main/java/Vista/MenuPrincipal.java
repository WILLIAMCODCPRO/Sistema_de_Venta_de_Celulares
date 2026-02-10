package Vista;

import Utilidades.Mensaje;


public class MenuPrincipal implements Menu {

    @Override
    public void mostrarMenu() {
        System.out.println("""
                       ******************************
                       1.   Gestionar Celulares.
                       2.   Gestionar Clientes.
                       3.   Gestionar Ventas.
                       4.   Ver Reportes.
                       5.   Salir
                       ******************************
                       """);
        Mensaje.crearMensajePersonalizado("Que accion deseas realizar");

    }
}

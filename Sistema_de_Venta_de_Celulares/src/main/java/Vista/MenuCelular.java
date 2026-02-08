
package Vista;

import Modelo.CelularBaseDeDatos;
import Utilidades.Mensaje;
import java.util.ArrayList;

public class MenuCelular {

    public void mostrarMenu() {
        System.out.println("""
                       ******************************
                       1.   Registrar Celular.
                       2.   listar Celulares.
                       3.   Editar Celular.
                       4.   Borrar Celular.
                       5.   Salir
                       ******************************
                       """);
        Mensaje.crearMensajePersonalizado("Que accion deseas realizar");
    }

   public void listar(ArrayList<CelularBaseDeDatos> celulares) {
    if (celulares.isEmpty()) {
        Mensaje.crearMensajePersonalizado("No hay celulares registrados.");
    } else {
        celulares.forEach(System.out::println);
    }
}

}

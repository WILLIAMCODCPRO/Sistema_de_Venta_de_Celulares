
package Vista;

import Utilidades.Mensaje;


public class MenuCelular {
    public void mostrarMenu(){
        System.out.println("""
                       ******************************
                       1.   Registrar Celular.
                       2.   Ver Celular.
                       3.   Editar Celular.
                       4.   Borrar Celular.
                       5.   Salir
                       ******************************
                       """);
        Mensaje.crearMensajePersonalizado("Que accion deseas realizar");
    }
}

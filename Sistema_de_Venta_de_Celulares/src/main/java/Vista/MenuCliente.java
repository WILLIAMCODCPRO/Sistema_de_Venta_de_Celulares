package Vista;

import Utilidades.Mensaje;

public class MenuCliente {
    
    public void mostrarMenuCliente(){
        System.out.println("""
                       ******************************
                       1.   Registrar Cliente.
                       2.   Ver Cliente.
                       3.   Editar Cliente.
                       4.   Borrar Cliente.
                       5.   Salir
                       ******************************
                       """);
        Mensaje.crearMensajePersonalizado("Que accion deseas realizar");
    }
    
   
}

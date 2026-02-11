package Vista;

import Modelo.Cliente;
import Utilidades.Mensaje;
import java.util.ArrayList;

public class MenuCliente implements Menu {
    
    @Override
    public void mostrarMenu(){
        System.out.println("""
                       ******************************
                       1.   Registrar Cliente.
                       2.   Listar Clientes.
                       3.   Editar Cliente.
                       4.   Borrar Cliente.
                       5.   Salir
                       ******************************
                       """);
        Mensaje.crearMensajePersonalizado("Que accion deseas realizar");
    }
    
     public void listar(ArrayList<Cliente> clientes) {
        if (clientes.isEmpty()) {
            Mensaje.crearMensajePersonalizado("No hay clientes registrados.");
        } else {
            clientes.forEach(System.out::println);
        }

    }
     
     public void listarOpciones(){
        Mensaje.crearMensajePersonalizado("""
                               Ingrese lo que quiere modificar
                               1. Nombre
                               2. Identificacion
                               3. Correo
                               4. Telefono
                               """);
    }
    
   
}

package Vista;

import Modelo.CelularBaseDeDatos;
import Utilidades.Mensaje;
import java.util.ArrayList;

public class MenuCelular implements Menu {

    @Override
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
    
    public void listarOpciones(){
        Mensaje.crearMensajePersonalizado("""
                               Ingrese lo que quiere modificar
                               1. Marca
                               2. Modelo
                               3. Sistema Operativo
                               4. Gama
                               5. Precio
                               6. Stock
                               """);
    }
    
    public void listarGama() {
        Mensaje.crearMensajePersonalizado("""
                                          Que gama de celular deseas registrar
                                          1. Alta
                                          2. Media
                                          3. Baja
                                          """);
    }

}

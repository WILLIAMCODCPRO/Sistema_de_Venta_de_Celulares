
package Controlador;


import Utilidades.EntradaUsuario;
import Utilidades.Mensaje;
import Modelo.Cliente;

public class ControladorCliente {
    
    protected Cliente registrarCliente(){
        Mensaje.crearMensajePersonalizado("Nombre");
        String nombre = EntradaUsuario.entradaString();
        
        Mensaje.crearMensajePersonalizado("identificacion");
        String identificaion = EntradaUsuario.entradaString();
        
        Mensaje.crearMensajePersonalizado("correo");
        String correo = EntradaUsuario.entradaString();
        
        Mensaje.crearMensajePersonalizado("telefono");
        String telefono = EntradaUsuario.entradaString();
        
        return new Cliente(nombre, identificaion, correo, telefono);
    };
}

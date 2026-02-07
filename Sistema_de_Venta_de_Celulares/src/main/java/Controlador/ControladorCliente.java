
package Controlador;


import Utilidades.ValidacionEntrada;
import Utilidades.Mensaje;
import Modelo.Cliente;

public class ControladorCliente {
    
    protected Cliente resgistar(){
        Mensaje.crearMensajePersonalizado("Nombre");
        String nombre = ValidacionEntrada.validarString();
        
        Mensaje.crearMensajePersonalizado("identificacion");
        String identificaion = ValidacionEntrada.validarString();;
        
        Mensaje.crearMensajePersonalizado("correo");
        String correo = ValidacionEntrada.validarString();
        
        Mensaje.crearMensajePersonalizado("telefono");
        String telefono = ValidacionEntrada.validarString();;
        
        return new Cliente(nombre, identificaion, correo, telefono);
    };
}


package Controlador;


import Utilidades.ValidacionEntrada;
import Utilidades.Mensaje;
import Modelo.Cliente;
import Persistencia.ClienteDAO;

public class ControladorCliente {
    
    private ClienteDAO clienteDAO;

    public ControladorCliente() {
        clienteDAO = new ClienteDAO();
    }
    
    private String validarIdentificacionUnica(){
        String identificacion;
        do {
            identificacion = ValidacionEntrada.validarString();

            if (clienteDAO.indentificacionExistente(identificacion)) {
                Mensaje.crearMensajePersonalizado("Esta identificacion ya se encuentra registrada"); 
               
            }
        } while (clienteDAO.indentificacionExistente(identificacion));
        return identificacion;
    }
    
    protected Cliente resgistrar() {

        Mensaje.crearMensajePersonalizado("Nombre");
        String nombre = ValidacionEntrada.validarString();

        Mensaje.crearMensajePersonalizado("identificaion");
        String identificacion = validarIdentificacionUnica();

        Mensaje.crearMensajePersonalizado("correo");
        String correo = ValidacionEntrada.validarCorreo();

        Mensaje.crearMensajePersonalizado("telefono");
        String telefono = ValidacionEntrada.validarString();

        Mensaje.crearMensajePersonalizado("Deseas registar al cliente: 1.SI  2.NO");
        int confirmacion = ValidacionEntrada.validacionOpUsuario(0, 3);
        if (confirmacion == 1) {
            return new Cliente(nombre, identificacion, correo, telefono);
        }
        if (confirmacion == 2) {
            Mensaje.crearMensajePersonalizado("Registro Canselado");
        }
        return null;
    }
;
}

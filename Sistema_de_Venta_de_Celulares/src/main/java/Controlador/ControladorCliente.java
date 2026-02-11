
package Controlador;


import Utilidades.ValidacionEntrada;
import Utilidades.Mensaje;
import Modelo.Cliente;
import Persistencia.ClienteDAO;
import Vista.MenuCliente;
import java.util.ArrayList;

public class ControladorCliente {
    
    private ClienteDAO clienteDAO;
    private MenuCliente menuCliente;

    public ControladorCliente() {
        clienteDAO = new ClienteDAO();
        menuCliente = new MenuCliente();
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
    
    protected void resgistrar() {

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
            Cliente guardarCliente = new Cliente(nombre, identificacion, correo, telefono);
            clienteDAO.guardar(guardarCliente);
        }
        if (confirmacion == 2) {
            Mensaje.crearMensajePersonalizado("Registro Canselado");
        }
        
    }
    
    protected void obtener() {
        ArrayList<Cliente> listarClientes = clienteDAO.listar();
        menuCliente.listar(listarClientes);
    }
}

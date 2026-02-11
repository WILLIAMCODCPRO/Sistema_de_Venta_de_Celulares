
package Controlador;


import Utilidades.ValidacionEntrada;
import Utilidades.Mensaje;
import Modelo.Cliente;
import Persistencia.ClienteDAO;
import Vista.MenuCliente;
import java.util.ArrayList;

public class ControladorCliente extends Controlador {
    
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
    
    @Override
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
    
    @Override
    protected void obtener() {
        ArrayList<Cliente> listarClientes = clienteDAO.listar();
        menuCliente.listar(listarClientes);
    }
    
    
    @Override
    protected void editar() {
        Mensaje.crearMensajePersonalizado("Id del Cliente que deseas editar");
        int id = ValidacionEntrada.validacionMayor0("El id no puede ser 0 o negativo");
        Cliente clienteBuscado = clienteDAO.buscar(id);

        if (clienteBuscado != null) {
            System.out.println(clienteBuscado);
            menuCliente.listarOpciones();
            int op = ValidacionEntrada.validacionOpUsuario(0, 5);
            switch (op) {
                case 1 -> {
                    Mensaje.crearMensajePersonalizado("Ingresa el nuevo nombre");
                    clienteBuscado.setNombre(ValidacionEntrada.validarString());
                }
                case 2 -> {
                    Mensaje.crearMensajePersonalizado("Ingresa la nueva identificacion");
                    clienteBuscado.setIdentificacion(validarIdentificacionUnica());
                }
                case 3 -> {
                    Mensaje.crearMensajePersonalizado("Ingresa el nuevo correo");
                    clienteBuscado.setCorreo(ValidacionEntrada.validarCorreo());
                }
                case 4 -> {
                    Mensaje.crearMensajePersonalizado("Ingresa el nuevo telefono");
                    clienteBuscado.setTelefono(ValidacionEntrada.validarString());
                }
                default ->Mensaje.crearMensajePersonalizado("opcion no valida");
            }
            Mensaje.crearMensajePersonalizado("Cliente editado con exito");
            clienteDAO.editar(clienteBuscado, id);

        } else {
            Mensaje.crearMensajePersonalizado("Cancelando editar cliente");
        }
    }
    
    @Override
    protected void borrar(){
        Mensaje.crearMensajePersonalizado("Ingrese el id del cliente que quieras borrar");
        int op = ValidacionEntrada.validacionMayor0("El id no puede ser 0 o negativo");
        Mensaje.crearMensajePersonalizado("Seguro que quieres eliminar este cliente: 1.SI  2.NO");
        int confirmacion = ValidacionEntrada.validacionOpUsuario(0, 3);
        if (confirmacion == 1) {
            clienteDAO.eliminar(op);
        } else if(confirmacion == 2){
            Mensaje.crearMensajePersonalizado("Elimicaion canselada");
        }
    }
}

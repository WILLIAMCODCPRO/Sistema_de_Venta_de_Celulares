package Controlador;

import Utilidades.Mensaje;
import Utilidades.ValidacionEntrada;
import Vista.MenuCliente;
import Modelo.Cliente;
import Persistencia.ClienteDAO;

public class ControladorMenuCliente {

    private MenuCliente menuCliente;
    private ClienteDAO persistenciaCliente;
    private ControladorCliente controladorCliente;

    protected ControladorMenuCliente() {
        menuCliente = new MenuCliente();
        persistenciaCliente = new ClienteDAO();
        controladorCliente = new ControladorCliente();
    }

    protected void iniciarMenuCliente() {

        int op;

        do {
            menuCliente.mostrarMenuCliente();
            op = ValidacionEntrada.validacionOpMenu(0, 6);
            switch (op) {
                case 1:
                    Cliente guardarCliente = controladorCliente.registrarCliente();
                    persistenciaCliente.insertarCliente(guardarCliente);
                    break;
                case 2:
                    
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    Mensaje.crearMensajePersonalizado("Volviendo al menu principal");
                    break;
            }
        } while (op != 5);

    }
}

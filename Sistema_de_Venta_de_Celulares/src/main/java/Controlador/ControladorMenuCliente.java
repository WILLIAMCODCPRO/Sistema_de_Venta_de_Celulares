package Controlador;

import Utilidades.Mensaje;
import Utilidades.ValidacionEntrada;
import Vista.MenuCliente;


public class ControladorMenuCliente extends ControladorMenu {

    private MenuCliente menuCliente;
    private ControladorCliente controladorCliente;

    protected ControladorMenuCliente() {
        menuCliente = new MenuCliente();
        controladorCliente = new ControladorCliente();
    }

    @Override
    protected void iniciarMenu() {

        int op;

        do {
            menuCliente.mostrarMenu();
            op = ValidacionEntrada.validacionOpUsuario(0, 6);
            switch (op) {
                case 1 -> controladorCliente.resgistrar();
                case 2 -> controladorCliente.obtener();
                case 3 -> controladorCliente.editar();
                case 4 -> controladorCliente.borrar();
                case 5 -> Mensaje.crearMensajePersonalizado("Volviendo al menu principal");
            }
        } while (op != 5);

    }
}

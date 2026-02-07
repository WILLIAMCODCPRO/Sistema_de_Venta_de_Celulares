package Controlador;

import Utilidades.Mensaje;
import Utilidades.ValidacionEntrada;
import Vista.MenuCliente;

public class ControladorMenuCliente {

    private MenuCliente menuCliente;

    public ControladorMenuCliente() {
        menuCliente = new MenuCliente();
    }

    public void iniciarMenuCliente() {

        int op;

        do {
            menuCliente.mostrarMenuCliente();
            op = ValidacionEntrada.validacionOpMenu(0, 6);
            switch (op) {
                case 1:

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

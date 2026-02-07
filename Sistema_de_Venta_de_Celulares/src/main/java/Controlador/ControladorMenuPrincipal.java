package Controlador;

import Vista.MenuPrincipal;
import Utilidades.Mensaje;
import Utilidades.ValidacionEntrada;
public class ControladorMenuPrincipal {

    private MenuPrincipal menuPrincipal;
    private ControladorMenuCliente menuCliente;

    public ControladorMenuPrincipal() {
        menuPrincipal = new MenuPrincipal();
        menuCliente = new ControladorMenuCliente();
    }

    public void iniciarMenuPrincipal() {
        int op;

        do {
            menuPrincipal.mostrarMenuPrincipal();
            op = ValidacionEntrada.validacionOpMenu( 0, 6);
            switch (op) {
                case 1:
                   
                    break;
                case 2:
                    menuCliente.iniciarMenuCliente();
                    break;
                case 3:
                   
                    break;
                case 4:
                    
                    break;
                case 5:
                    Mensaje.crearMensajePersonalizado("Saliendo del Programa");
                    Mensaje.crearMensajePersonalizado("Gracias por su visita");
                    break;
            }
        } while (op != 5);
    }
}

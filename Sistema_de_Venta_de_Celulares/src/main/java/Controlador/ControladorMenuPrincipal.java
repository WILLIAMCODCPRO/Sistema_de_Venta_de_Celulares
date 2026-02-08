package Controlador;

import Vista.MenuPrincipal;
import Utilidades.Mensaje;
import Utilidades.ValidacionEntrada;
public class ControladorMenuPrincipal {

    private MenuPrincipal menuPrincipal;
    private ControladorMenuCliente menuCliente;
    private ControladorMenuCelular menuCelular;

    public ControladorMenuPrincipal() {
        menuPrincipal = new MenuPrincipal();
        menuCliente = new ControladorMenuCliente();
        menuCelular = new ControladorMenuCelular();
    }

    public void iniciarMenu() {
        int op;

        do {
            menuPrincipal.mostrarMenu();
            op = ValidacionEntrada.validacionOpUsuario( 0, 6);
            switch (op) {
                case 1:
                   menuCelular.iniciarMenu();
                    break;
                case 2:
                    menuCliente.iniciarMenu();
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

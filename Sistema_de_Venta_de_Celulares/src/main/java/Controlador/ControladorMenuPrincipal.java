package Controlador;

import Vista.MenuPrincipal;
import Utilidades.Mensaje;
import Utilidades.ValidacionEntrada;
public class ControladorMenuPrincipal {

    private MenuPrincipal menuPrincipal;
    private ControladorMenuCliente menuCliente;
    private ControladorMenuCelular menuCelular;
    private ControladorMenuVenta menuVenta;

    public ControladorMenuPrincipal() {
        menuPrincipal = new MenuPrincipal();
        menuCliente = new ControladorMenuCliente();
        menuCelular = new ControladorMenuCelular();
        menuVenta = new ControladorMenuVenta();
        
    }

    public void iniciarMenu() {
        int op;

        do {
            menuPrincipal.mostrarMenu();
            op = ValidacionEntrada.validacionOpUsuario( 0, 6);
            switch (op) {
                case 1 -> menuCelular.iniciarMenu();
                case 2 -> menuCliente.iniciarMenu();
                case 3 -> menuVenta.iniciarMenu();
                case 4 -> {
                }
                case 5 -> {
                    Mensaje.crearMensajePersonalizado("Saliendo del Programa");
                    Mensaje.crearMensajePersonalizado("Gracias por su visita");
                }
            }
        } while (op != 5);
    }
}

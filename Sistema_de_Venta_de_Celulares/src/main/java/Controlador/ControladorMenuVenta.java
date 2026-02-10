
package Controlador;



import Utilidades.Mensaje;
import Utilidades.ValidacionEntrada;
import Vista.MenuVenta;


public class ControladorMenuVenta {
    private MenuVenta menuVenta;
    private ControladorVenta controladorVenta;

    protected ControladorMenuVenta() {
        menuVenta = new MenuVenta();
        controladorVenta = new ControladorVenta();
    }

    protected void iniciarMenu() {

        int op;

        do {
            menuVenta.mostrarMenu();
            op = ValidacionEntrada.validacionOpUsuario(0, 4);
            switch (op) {
                case 1 -> controladorVenta.resgistrar();
                case 2 -> controladorVenta.listar();
                case 3 -> Mensaje.crearMensajePersonalizado("Volviendo al menu principal");
               
            }
        } while (op != 3);

    }
}

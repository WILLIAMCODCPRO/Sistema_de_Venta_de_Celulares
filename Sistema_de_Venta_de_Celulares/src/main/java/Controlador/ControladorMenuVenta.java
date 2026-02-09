
package Controlador;

import Modelo.Venta;
import Persistencia.VentaDAO;
import Utilidades.Mensaje;
import Utilidades.ValidacionEntrada;
import Vista.MenuVenta;


public class ControladorMenuVenta {
    private MenuVenta menuVenta;
    private VentaDAO ventaDAO;
    private ControladorVenta controladorVenta;

    protected ControladorMenuVenta() {
        menuVenta = new MenuVenta();
        ventaDAO = new VentaDAO();
        controladorVenta = new ControladorVenta();
    }

    protected void iniciarMenu() {

        int op;

        do {
            menuVenta.mostrarMenu();
            op = ValidacionEntrada.validacionOpUsuario(0, 3);
            switch (op) {
                case 1 -> controladorVenta.resgistrar();
                case 2 -> Mensaje.crearMensajePersonalizado("Volviendo al menu principal");
               
            }
        } while (op != 2);

    }
}

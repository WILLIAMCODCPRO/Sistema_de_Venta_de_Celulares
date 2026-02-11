package Controlador;


import Utilidades.Mensaje;
import Utilidades.ValidacionEntrada;
import Vista.MenuCelular;
import Modelo.Celular;
import Modelo.CelularBaseDeDatos;
import Persistencia.CelularDAO;
import java.util.ArrayList;

public class ControladorMenuCelular extends ControladorMenu {

    private MenuCelular menuCelular;
    private ControladorCelular controladorCelular;
    

    protected ControladorMenuCelular() {
        menuCelular = new MenuCelular();
        controladorCelular = new ControladorCelular();
    }

    @Override
    protected void iniciarMenu() {

        int op;

        do {
            menuCelular.mostrarMenu();
            op = ValidacionEntrada.validacionOpUsuario(0, 6);
            switch (op) {
                case 1 -> controladorCelular.resgistrar();
                case 2 -> controladorCelular.obtener();
                case 3 -> controladorCelular.editar();
                case 4 -> controladorCelular.borrar();
                case 5 -> Mensaje.crearMensajePersonalizado("Volviendo al menu principal");
            }
        } while (op != 5);

    }
}

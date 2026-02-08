package Controlador;


import Utilidades.Mensaje;
import Utilidades.ValidacionEntrada;
import Vista.MenuCelular;
import Modelo.Celular;
import Modelo.CelularBaseDeDatos;
import Persistencia.CelularDAO;
import java.util.ArrayList;

public class ControladorMenuCelular {

    private MenuCelular menuCelular;
    private CelularDAO celularDAO;
    private ControladorCelular controladorCelular;

    protected ControladorMenuCelular() {
        menuCelular = new MenuCelular();
        celularDAO = new CelularDAO();
        controladorCelular = new ControladorCelular();
    }

    protected void iniciarMenu() {

        int op;

        do {
            menuCelular.mostrarMenu();
            op = ValidacionEntrada.validacionOpUsuario(0, 6);
            switch (op) {
                case 1:
                    Celular guardarCelular = controladorCelular.resgistrar();
                    if (guardarCelular == null) break;
                    celularDAO.guardar(guardarCelular);
                    break;
                case 2:
                    ArrayList<CelularBaseDeDatos> listarCelulares = controladorCelular.obtener();
                    menuCelular.listar(listarCelulares);
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

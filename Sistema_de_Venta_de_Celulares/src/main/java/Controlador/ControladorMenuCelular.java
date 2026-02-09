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
                case 1 -> {
                    menuCelular.listarGama();
                    Celular guardarCelular = controladorCelular.resgistrar();
                    if (guardarCelular == null) break;
                    celularDAO.guardar(guardarCelular);
                }
                case 2 -> {
                    ArrayList<CelularBaseDeDatos> listarCelulares = controladorCelular.obtener();
                    menuCelular.listar(listarCelulares);
                }
                case 3 -> controladorCelular.editar();
                case 4 -> {
                }
                case 5 -> Mensaje.crearMensajePersonalizado("Volviendo al menu principal");
            }
        } while (op != 5);

    }
}

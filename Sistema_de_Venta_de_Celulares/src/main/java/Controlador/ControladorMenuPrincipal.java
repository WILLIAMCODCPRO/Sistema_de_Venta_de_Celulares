package Controlador;

import Vista.MenuPrincipal;
import Utilidades.Mensaje;
import Utilidades.Validacion;
public class ControladorMenuPrincipal {

    private MenuPrincipal menu;

    public ControladorMenuPrincipal() {
        menu = new MenuPrincipal();
    }

    public void iniciarPrograma() {
        int op;

        do {
            op = menu.mostrarMenu();
            Validacion.validarOpMenu(op,0, 6);

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
                    Mensaje.crearMensajePersonalizado("Saliendo del Programa");
                    Mensaje.crearMensajePersonalizado("Gracias por su visita");
                    break;
            }
        } while (op != 5);
    }
}

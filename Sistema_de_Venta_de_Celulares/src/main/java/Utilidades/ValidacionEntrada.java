package Utilidades;

public class ValidacionEntrada {
    public static int validacionOpMenu(int rango1, int rango2){
        while (true) {
            try {
                int opMenu = EntradaUsuario.entradaOpMenu();
                if (opMenu <= rango1 || opMenu >= rango2) {
                    Mensaje.crearMensajePersonalizado("Opcion no valida intente de nuevo");
                } else {
                    return opMenu;
                }
            } catch (Exception e) {
                Mensaje.crearMensajePersonalizado("Opcion no valida intente de nuevo");
            }
        }
    }
}

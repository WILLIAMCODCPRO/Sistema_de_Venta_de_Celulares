package Utilidades;

public class ValidacionEntrada {

    public static int validacionOpMenu(int rango1, int rango2) {
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

    public static String validarString(){
        String texto;
        do {
            texto = EntradaUsuario.entradaString().trim();
            if (texto.isEmpty()) {
                Mensaje.crearMensajePersonalizado("Texto vacio intente denuevo");
            }
        } while (texto.isEmpty());
        return texto;
    }

}

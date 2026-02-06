
package Utilidades;

import java.util.Scanner;

public class Validacion {

    public static int validarOpMenu(int opMenu,int rango1, int rango2) {
        while (true) {
            try {
                opMenu = new Scanner(System.in).nextInt();
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

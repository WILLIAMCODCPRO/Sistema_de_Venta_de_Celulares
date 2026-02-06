package Utilidades;

import java.util.Scanner;

public class EntradaUsuario {
    
    public static int entradaOpMenu(){
        Mensaje.crearMensajePersonalizado("¿Que accion deseas realizar");
        int op = new Scanner(System.in).nextInt();
        return op;
    }
}

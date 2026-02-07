package Utilidades;

import java.util.Scanner;

public class EntradaUsuario {
    
    public static int entradaOpMenu(){
        int op = new Scanner(System.in).nextInt();
        return op;
    }
    
    public static String entradaString(){
        String stringUsuario = new Scanner(System.in).nextLine();
        return stringUsuario;
    }
}

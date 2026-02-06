package Vista;

import java.util.Scanner;

public class MenuPrincipal {

    public int mostrarMenu() {
        System.out.println("""
                       ******************************
                       1.   Gestionar Celulares.
                       2.   Gestionar Clientes.
                       3.   Gestionar Ventas.
                       4.   Ver Reportes
                       5.   Salir
                       ******************************
                       """);
        int op = new Scanner(System.in).nextInt();
        return op;

    }
}

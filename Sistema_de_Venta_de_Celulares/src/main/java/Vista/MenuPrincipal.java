package Vista;

import java.util.Scanner;

public class MenuPrincipal {

    public void menuPrincipal() {
        int op = 0;
        
        do {
            System.out.println("""
                           ******************************
                           1.   Gestionar Celulares.
                           2.   Gestionar Clientes.
                           3.   Gestionar Ventas.
                           4.   Ver Reportes
                           5.   Salir
                           """);
            op = new Scanner(System.in).nextInt();
        } while (op != 5);
    }
}

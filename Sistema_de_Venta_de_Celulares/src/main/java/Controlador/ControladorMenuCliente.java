
package Controlador;

import Utilidades.ValidacionEntrada;
import Vista.MenuCliente;


public class ControladorMenuCliente {
     private MenuCliente menu;
     
      public ControladorMenuCliente() {
        menu = new MenuCliente();
    }

    public void mostrarMenuCliente() {
        
        menu.mostrarMenuCliente();
           
    }
}

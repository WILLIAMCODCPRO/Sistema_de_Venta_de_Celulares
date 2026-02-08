
package Controlador;

import Modelo.CategoriaGama;
import Utilidades.ValidacionEntrada;
import Utilidades.Mensaje;
import Modelo.Celular;
import Modelo.CelularBaseDeDatos;
import Persistencia.CelularDAO;
import Modelo.FactoryCelular;
import java.util.ArrayList;

public class ControladorCelular {
    private CelularDAO celularDAO;
    private FactoryCelular factoryCelular;

    public ControladorCelular() {
        celularDAO = new CelularDAO();
        factoryCelular = new FactoryCelular();
    }
    
   
    protected Celular resgistrar() {
        
        Mensaje.crearMensajePersonalizado("""
                                          Que gama de celular deseas registrar
                                          1. Alta
                                          2. Media
                                          3. Baja
                                          """);
        
        int gama = ValidacionEntrada.validacionOpUsuario(0, 4);
        
        CategoriaGama gamaSeleccionada = switch (gama) {
            case 1 -> CategoriaGama.Alta;
            case 2 -> CategoriaGama.Media;
            case 3 -> CategoriaGama.Baja;
            default -> throw new IllegalStateException("No deberias poder verme");
        };

        Mensaje.crearMensajePersonalizado("Marca");
        String marca = ValidacionEntrada.validarString();

        Mensaje.crearMensajePersonalizado("Modelo");
        String modelo = ValidacionEntrada.validarString();

        Mensaje.crearMensajePersonalizado("Sistema operativo");
        String sistema_operativo = ValidacionEntrada.validarString();

        Mensaje.crearMensajePersonalizado("Precio");
        double precio = ValidacionEntrada.validacionPrecio();
        
        Mensaje.crearMensajePersonalizado("Stock");
        int stock = ValidacionEntrada.validacionStock();

        Mensaje.crearMensajePersonalizado("Deseas registar el celular: 1.SI  2.NO");
        int confirmacion = ValidacionEntrada.validacionOpUsuario(0, 3);
        if (confirmacion == 1) {
            return  factoryCelular.crearCelular(gamaSeleccionada, marca, modelo, sistema_operativo, precio, stock);
        }
        if (confirmacion == 2) {
            Mensaje.crearMensajePersonalizado("Registro Canselado");
        }
        return null;
    }
    
    protected ArrayList obtener(){
        ArrayList<CelularBaseDeDatos>listaCelulares = celularDAO.listar();
        return listaCelulares;
    }
    
   
}

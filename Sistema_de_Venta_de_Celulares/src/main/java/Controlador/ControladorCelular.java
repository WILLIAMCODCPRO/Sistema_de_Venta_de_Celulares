
package Controlador;

import Modelo.CategoriaGama;
import Utilidades.ValidacionEntrada;
import Utilidades.Mensaje;
import Modelo.Celular;
import Modelo.CelularBaseDeDatos;
import Persistencia.CelularDAO;
import Modelo.FactoryCelular;
import Vista.MenuCelular;
import java.util.ArrayList;

public class ControladorCelular {

    private CelularDAO celularDAO;
    private FactoryCelular factoryCelular;
    private MenuCelular menuCelular;

    public ControladorCelular() {
        celularDAO = new CelularDAO();
        factoryCelular = new FactoryCelular();
        menuCelular = new MenuCelular();
    }

    protected Celular resgistrar() {

        int gama = ValidacionEntrada.validacionOpUsuario(0, 4);

        CategoriaGama gamaSeleccionada = switch (gama) {
            case 1 ->
                CategoriaGama.Alta;
            case 2 ->
                CategoriaGama.Media;
            case 3 ->
                CategoriaGama.Baja;
            default ->
                throw new IllegalStateException("No deberias poder verme");
        };

        Mensaje.crearMensajePersonalizado("Marca");
        String marca = ValidacionEntrada.validarString();

        Mensaje.crearMensajePersonalizado("Modelo");
        String modelo = ValidacionEntrada.validarString();

        Mensaje.crearMensajePersonalizado("Sistema operativo");
        String sistema_operativo = ValidacionEntrada.validarString();

        Mensaje.crearMensajePersonalizado("Precio");
        double precio = ValidacionEntrada.validacionMayor0("El precio no puede ser 0 o negativo");

        Mensaje.crearMensajePersonalizado("Stock");
        int stock = ValidacionEntrada.validacionStock();

        Mensaje.crearMensajePersonalizado("Deseas registar el celular: 1.SI  2.NO");
        int confirmacion = ValidacionEntrada.validacionOpUsuario(0, 3);
        if (confirmacion == 1) {
            return factoryCelular.crearCelular(gamaSeleccionada, marca, modelo, sistema_operativo, precio, stock);
        }
        if (confirmacion == 2) {
            Mensaje.crearMensajePersonalizado("Registro Canselado");
        }
        return null;
    }

    protected ArrayList<CelularBaseDeDatos> obtener() {
        return celularDAO.listar();
    }

    protected void editar() {
        Mensaje.crearMensajePersonalizado("Id del celular que deseas editar");
        int id = ValidacionEntrada.validacionMayor0("El id no puede ser 0 o negativo");
        CelularBaseDeDatos celularBuscado = celularDAO.buscar(id);

        if (celularBuscado != null) {
            System.out.println(celularBuscado);
            menuCelular.listarOpciones();
            int op = ValidacionEntrada.validacionOpUsuario(0, 7);
            switch (op) {
                case 1 -> {
                    Mensaje.crearMensajePersonalizado("Ingresa la nueva marca");
                    celularBuscado.setMarca(ValidacionEntrada.validarString());
                }
                case 2 -> {
                    Mensaje.crearMensajePersonalizado("Ingresa el nuevo modelo");
                    celularBuscado.setModelo(ValidacionEntrada.validarString());
                }
                case 3 -> {
                    Mensaje.crearMensajePersonalizado("Ingresa el nuevo sistema operativo");
                    celularBuscado.setSistema_operativo(ValidacionEntrada.validarString());
                }
                case 4 -> {
                    Mensaje.crearMensajePersonalizado("Ingresa la nueva gama 1.Alta 2.Media 3.Baja)");
                    int gama = ValidacionEntrada.validacionOpUsuario(0, 4);
                    CategoriaGama nuevaGama = switch (gama) {
                        case 1 ->
                            CategoriaGama.Alta;
                        case 2 ->
                            CategoriaGama.Media;
                        case 3 ->
                            CategoriaGama.Baja;
                        default ->
                            throw new IllegalStateException("No se supone que debes verme");
                    };
                    
                    celularBuscado.setGama(nuevaGama);
                }
                case 5 -> { 
                    Mensaje.crearMensajePersonalizado("Ingresa el nuevo precio");
                    celularBuscado.setPrecio(ValidacionEntrada.validacionMayor0("El precio no puede ser 0 o negativo"));
                }
                case 6 -> {
                    Mensaje.crearMensajePersonalizado("Ingresa el nuevo stock");
                    celularBuscado.setStock(ValidacionEntrada.validacionStock());
                }
                default ->
                    Mensaje.crearMensajePersonalizado("opcion no valida");
            }
            celularDAO.editar(celularBuscado, id);

        } else {
            Mensaje.crearMensajePersonalizado("Cancelando editar celular");
        }
    }

}

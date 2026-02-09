package Controlador;

//select max(id) from venta
import Modelo.CelularBaseDeDatos;
import Modelo.Cliente;
import Modelo.Venta;
import Persistencia.CelularDAO;
import Persistencia.ClienteDAO;
import Persistencia.VentaDAO;
import Utilidades.Mensaje;
import Utilidades.ValidacionEntrada;
import Vista.MenuCliente;
import java.util.ArrayList;



public class ControladorVenta {
    private VentaDAO ventaDAO;
   private CelularDAO celularDAO;
   private ClienteDAO clienteDAO;
   private MenuCliente clienteMenu;

    public ControladorVenta() {
        ventaDAO = new VentaDAO();
        celularDAO = new CelularDAO();
        clienteDAO = new ClienteDAO();
        clienteMenu = new MenuCliente();
    }

    protected void resgistrar() {
        CelularBaseDeDatos celularEncontrado;
        Cliente clienteEncontrado;
        int id_cliente;
        int id_celular;
        
        
        
        ArrayList<Cliente> listarClientes = clienteDAO.listar();
        clienteMenu.listar(listarClientes);
        Mensaje.crearMensajePersonalizado("Ingresa el numero del cliente al que le vas a vender el producto ");
        do{
            id_cliente = ValidacionEntrada.validacionMayor0("el numero del cliente no puede se 0 o menor");
            clienteEncontrado = clienteDAO.buscar(id_cliente);
        }while(clienteEncontrado == null);
        Venta registarVenta = new Venta(id_cliente);
        ventaDAO.guardar(registarVenta);
       
        
        
        do{
            Mensaje.crearMensajePersonalizado("Ingresa el id del celular que vas a vender ");
            id_celular = ValidacionEntrada.validacionMayor0("el id no puede se 0 o menor");
            celularEncontrado = celularDAO.buscar(id_celular);
        }while(celularEncontrado == null);
        
        
        
        
        Mensaje.crearMensajePersonalizado("Ingresa la cantidad de celulares vendidos");
        int id_cantidad = ValidacionEntrada.validacionMayor0("Se debe de vender al menos un celular");
        
    }
}

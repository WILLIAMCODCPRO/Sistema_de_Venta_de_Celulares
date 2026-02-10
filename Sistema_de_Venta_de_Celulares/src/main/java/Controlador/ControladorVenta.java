package Controlador;

//select max(id) from venta

import Modelo.CelularBaseDeDatos;
import Modelo.Cliente;
import Modelo.DetalleVenta;
import Modelo.Factura;
import Modelo.Venta;
import Persistencia.CelularDAO;
import Persistencia.ClienteDAO;
import Persistencia.DetalleVentaDAO;
import Persistencia.FacturaDAO;
import Persistencia.VentaDAO;
import Utilidades.Mensaje;
import Utilidades.ValidacionEntrada;
import Vista.MenuCelular;
import Vista.MenuCliente;
import Vista.MenuVenta;
import java.util.ArrayList;



public class ControladorVenta {

    private VentaDAO ventaDAO;
    private CelularDAO celularDAO;
    private ClienteDAO clienteDAO;
    private FacturaDAO facturaDAO;
    private MenuCliente clienteMenu;
    private MenuCelular celularMenu;
    private MenuVenta ventaMenu;
    private DetalleVentaDAO detalleVentaDAO;
    private DetalleVenta detalleVenta;
    private Venta venta;
    
    
  
    

    public ControladorVenta() {
        ventaDAO = new VentaDAO();
        celularDAO = new CelularDAO();
        clienteDAO = new ClienteDAO();
        clienteMenu = new MenuCliente();
        celularMenu = new MenuCelular();
        detalleVentaDAO = new DetalleVentaDAO();
        detalleVenta = new DetalleVenta();
        venta = new Venta();
        ventaMenu = new MenuVenta();
        facturaDAO = new FacturaDAO();
        
        
    }

    protected void resgistrar() {
        CelularBaseDeDatos celularEncontrado;
        Cliente clienteEncontrado;
        int id_cliente;
        int id_celular;
        int cantidad;
        int restarStock;
        
        
        ArrayList<Cliente> listarClientes = clienteDAO.listar();
        clienteMenu.listar(listarClientes);
        Mensaje.crearMensajePersonalizado("Ingresa el numero del cliente al que le vas a vender el producto ");
        do{
            id_cliente = ValidacionEntrada.validacionMayor0("el numero del cliente no puede se 0 o menor");
            clienteEncontrado = clienteDAO.buscar(id_cliente);
        }while(clienteEncontrado == null);
        
       
        
        ArrayList<CelularBaseDeDatos> listarCelulares = celularDAO.listar();
        celularMenu.listar(listarCelulares);
        do {
            Mensaje.crearMensajePersonalizado("Ingresa el numero del celular que vas a vender");
            id_celular = ValidacionEntrada.validacionMayor0("El nnmero del celular no puede ser 0 o menor" );

            celularEncontrado = celularDAO.buscar(id_celular);

            if (celularEncontrado != null) {

                if (!celularEncontrado.validarStock()) {
                    celularEncontrado = null;
                }

            }

        } while (celularEncontrado == null);

        do {
            Mensaje.crearMensajePersonalizado("Ingresa la cantidad de celulares vendidos");
            cantidad = ValidacionEntrada.validacionMayor0("Se debe de vender al menos un celular");
          

            if (cantidad > celularEncontrado.getStock()) {
                Mensaje.crearMensajePersonalizado("La cantidad a vender es mayor a stock disponible, intentelo de nuevo");
                
            }
        } while (cantidad > celularEncontrado.getStock());
        restarStock = celularEncontrado.getStock() - cantidad;
        
        Mensaje.crearMensajePersonalizado("Deseas registar al cliente: 1.SI  2.NO");
        int confirmacion = ValidacionEntrada.validacionOpUsuario(0, 3);
        if (confirmacion == 1) {
            Venta registarVenta = new Venta(id_cliente);
            ventaDAO.guardar(registarVenta);
            int idVenta = ventaDAO.obtenerIdVenta();
            double subtotal = detalleVenta.calcularSubtotal(celularEncontrado.getPrecio(), cantidad);
            DetalleVenta registrarDetalleVenta = new DetalleVenta(celularEncontrado.getId(), cantidad, subtotal, idVenta);
            detalleVentaDAO.guardar(registrarDetalleVenta);
            double total = venta.calcularTotal(subtotal);
            registarVenta.setTotal(total);
            ventaDAO.editar(registarVenta, idVenta);
            celularEncontrado.setStock(restarStock);
            celularDAO.editar(celularEncontrado, id_celular);
            
            
           /// Generar Factura
           Venta datosVenta = ventaDAO.buscar(idVenta);
           Factura factura = new Factura(clienteEncontrado.getNombre(),datosVenta.getFecha(),celularEncontrado.getModelo(),cantidad,datosVenta.getTotal());
           ventaMenu.generarFactura(factura);
           facturaDAO.guardarFacturaVenta(factura);
           
            
        }
        if (confirmacion == 2) {
            Mensaje.crearMensajePersonalizado("Registro Canselado");
            
        }
        
    }
    
    protected void listar(){
        
    }
}

package Persistencia;

import BaseDeDatos.Conexion;
import Modelo.Venta;
import Utilidades.Mensaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class VentaDAO {
    
    private Conexion conexion = new Conexion();
    
     public void guardar(Venta venta) {
        try (Connection c = conexion.conectar();) {
            PreparedStatement ps = c.prepareStatement("insert into venta (id_cliente) values (?)");
            ps.setInt(1, venta.getId_cliente());
            ps.executeUpdate(); 
            Mensaje.crearMensajePersonalizado("Venta registrado con exito");
        } catch (SQLException e) {
            Mensaje.crearMensajePersonalizado("Hubo un error al resgistar la venta: " + e.getMessage());
        }
    }
}

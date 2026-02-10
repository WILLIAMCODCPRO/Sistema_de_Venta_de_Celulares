
package Persistencia;

import BaseDeDatos.Conexion;
import Modelo.DetalleVenta;
import Utilidades.Mensaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DetalleVentaDAO {
    private Conexion conexion = new Conexion();

    public void guardar(DetalleVenta detalleVenta) {
        try (Connection c = conexion.conectar();) {
            PreparedStatement ps = c.prepareStatement("insert into detalle_venta (id_venta,id_celular,cantidad,subtotal) values (?,?,?,?)");
            ps.setInt(1, detalleVenta.getId_venta());
            ps.setInt(2, detalleVenta.getId_celular());
            ps.setInt(3, detalleVenta.getCantidad());
            ps.setDouble(4, detalleVenta.getSubtotal());
            ps.executeUpdate();
           
        } catch (SQLException e) {
            Mensaje.crearMensajePersonalizado("Hubo un error al resgistar la venta: " + e.getMessage());
        }
    }
}

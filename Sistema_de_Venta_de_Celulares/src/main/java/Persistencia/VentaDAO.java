package Persistencia;

import BaseDeDatos.Conexion;
import Modelo.Factura;

import Modelo.Venta;
import Utilidades.Mensaje;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
    public int obtenerIdVenta() {
        int idVenta = 0;
        try (Connection c = conexion.conectar();) {
           
          
            PreparedStatement ps = c.prepareStatement("select max(id) from venta");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idVenta  = rs.getInt(1);
            } else {
                Mensaje.crearMensajePersonalizado("No se ecnontro el id");
            }
        } catch (SQLException e) {
            Mensaje.crearMensajePersonalizado("Hubo un error en la busqueda: " + e.getMessage());
        }
        
        return idVenta;
    }
    
     public Venta buscar(int id) {
        Venta venta = new Venta();
        try (Connection c = conexion.conectar();) {
            PreparedStatement ps = c.prepareStatement("select * from venta WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                venta.setId_venta(rs.getInt("id"));
                venta.setId_cliente(rs.getInt("id_cliente"));
                venta.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
                venta.setTotal(rs.getDouble("total"));
            } else {
                Mensaje.crearMensajePersonalizado("Esa venta no existe, intenta de nuevo");
                return null;
            }
        } catch (SQLException e) {
            Mensaje.crearMensajePersonalizado("Hubo un error al buscar la venta: " + e.getMessage());
        }
        return venta;
    }
    
    public void editar(Venta venta, int id) {
        try (Connection c = conexion.conectar();) {
            PreparedStatement ps = c.prepareStatement("update venta set id_cliente=?, total=? where id=?");
            ps.setInt(1, venta.getId_cliente());
            ps.setDouble(2, venta.getTotal());
            ps.setInt(3, id);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            Mensaje.crearMensajePersonalizado("Hubo un error al editar la venta: " + e.getMessage());
        }
    }
    
   

}


package Persistencia;

import BaseDeDatos.Conexion;
import Modelo.Celular;
import Utilidades.Mensaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CelularDAO {
    private Conexion conexion = new Conexion(); 

    
    public void guardar(Celular celular) {
        try (Connection c = conexion.conectar();) {
            PreparedStatement ps = c.prepareStatement("insert into celular (marca, modelo, sistema_operativo, gama ,precio,stock) values (?, ?, ?, ?,?,?)");
            ps.setString(1, celular.getMarca());
            ps.setString(2, celular.getModelo());
            ps.setString(3, celular.getSistema_operativo());
            ps.setString(4, celular.getGama().name());
            ps.setDouble(5, celular.getPrecio());
            ps.setInt(6, celular.getStock());
            ps.executeUpdate(); 
            Mensaje.crearMensajePersonalizado("Celular registrado con exito");
        } catch (SQLException e) {
            Mensaje.crearMensajePersonalizado("Hubo un error al resgistar el celular: " + e.getMessage());
        }
    }
}

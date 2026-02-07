package Persistencia;

import BaseDeDatos.Conexion;
import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Utilidades.Mensaje;

public class ClienteDAO {

    private Conexion conexion = new Conexion(); 

    
    public void guardar(Cliente cliente) {
        try (Connection c = conexion.conectar();) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO cliente (nombre, identificacion, correo, telefono) VALUES (?, ?, ?, ?)");
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getIdentificacion());
            ps.setString(3, cliente.getCorreo());
            ps.setString(4, cliente.getTelefono());
            ps.executeUpdate(); 
            Mensaje.crearMensajePersonalizado("Cliente registrado con exito");
        } catch (SQLException e) {
            Mensaje.crearMensajePersonalizado("Hubo un error al resgistar el cliente: " + e.getMessage());
        }
    }
}


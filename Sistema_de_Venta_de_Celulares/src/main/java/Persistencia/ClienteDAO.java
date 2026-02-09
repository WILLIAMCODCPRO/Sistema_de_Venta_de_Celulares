package Persistencia;

import BaseDeDatos.Conexion;
import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Utilidades.Mensaje;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClienteDAO {

    private Conexion conexion = new Conexion(); 

    
    public void guardar(Cliente cliente) {
        try (Connection c = conexion.conectar();) {
            PreparedStatement ps = c.prepareStatement("insert into cliente (nombre, identificacion, correo, telefono) values (?, ?, ?, ?)");
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
    
    public ArrayList<Cliente> listar() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try (Connection c = conexion.conectar();) {
            PreparedStatement ps = c.prepareStatement("select * from cliente");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                clientes.add(new Cliente(rs.getInt("id"),rs.getString("nombre"),rs.getString("identificacion"),rs.getString("correo"),rs.getString("telefono")));
            }

        } catch (SQLException e) {
            Mensaje.crearMensajePersonalizado("Hubo un error al buscasr clientes: " + e.getMessage());
        }

        return clientes;
    }
    
    public boolean indentificacionExistente(String identificacion) {
    
        try (Connection c = conexion.conectar();
            PreparedStatement ps = c.prepareStatement("select count(*) from cliente where identificacion = ?")) {
            ps.setString(1, identificacion);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            Mensaje.crearMensajePersonalizado("Hubo un error al buscar las indentificaiones" + e.getMessage());
        }
        return false;
    }
    
    public Cliente buscar(int id){
        Cliente cliente = new Cliente();
        try (Connection c = conexion.conectar();) {
            PreparedStatement ps = c.prepareStatement("select * from cliente WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) { 
            cliente.setId(rs.getInt("id"));
            cliente.setNombre(rs.getString("nombre"));
            cliente.setIdentificacion(rs.getString("identificacion"));
            cliente.setCorreo(rs.getString("correo"));
            cliente.setTelefono(rs.getString("telefono"));
            
        } else {
            Mensaje.crearMensajePersonalizado("No hay ningun cliente con ese id, intenta de nuevo");
            return null;
        }
        } catch (SQLException e) {
            Mensaje.crearMensajePersonalizado("Hubo un error al buscar el id: " + e.getMessage());
        }
        return cliente;
    }
    
    
}


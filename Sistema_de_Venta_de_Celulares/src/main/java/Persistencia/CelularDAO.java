
package Persistencia;

import BaseDeDatos.Conexion;
import Modelo.CategoriaGama;
import Modelo.Celular;
import Modelo.CelularBaseDeDatos;
import Utilidades.Mensaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


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
 
    public ArrayList<CelularBaseDeDatos> listar() {
        ArrayList<CelularBaseDeDatos> celulares = new ArrayList<>();
        try (Connection c = conexion.conectar();) {
            PreparedStatement ps = c.prepareStatement("select * from celular");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                celulares.add(new CelularBaseDeDatos(
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("sistema_operativo"),
                        CategoriaGama.valueOf(rs.getString("gama")),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                ));
            }

        } catch (SQLException e) {
            Mensaje.crearMensajePersonalizado("Hubo un error al buscasr clientes: " + e.getMessage());
        }

        return celulares;
    }
    
    public void editar(CelularBaseDeDatos celularBaseDeDatos, int id) {
        try (Connection c = conexion.conectar();) {
            PreparedStatement ps = c.prepareStatement("update celular set marca=?, modelo=?, sistema_operativo=?, gama=?,precio=?,stock=? where id=?");
            ps.setString(1, celularBaseDeDatos.getMarca());
            ps.setString(2, celularBaseDeDatos.getModelo());
            ps.setString(3, celularBaseDeDatos.getSistema_operativo());
            ps.setString(4, celularBaseDeDatos.getGama().name());
            ps.setDouble(5, celularBaseDeDatos.getPrecio());
            ps.setInt(6, celularBaseDeDatos.getStock());
            ps.setInt(7, id);
            ps.executeUpdate(); 
            
        } catch (SQLException e) {
            Mensaje.crearMensajePersonalizado("Hubo un error al editar el celular: " + e.getMessage());
        }
    }
    
    public CelularBaseDeDatos buscar(int id) {
        CelularBaseDeDatos celular = new CelularBaseDeDatos();
        try (Connection c = conexion.conectar();) {
            PreparedStatement ps = c.prepareStatement("select * from celular WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                celular.setId(rs.getInt("id"));
                celular.setMarca(rs.getString("marca"));
                celular.setModelo(rs.getString("modelo"));
                celular.setSistema_operativo(rs.getString("sistema_operativo"));
                celular.setGama(CategoriaGama.valueOf(rs.getString("gama")));
                celular.setPrecio(rs.getDouble("precio"));
                celular.setStock(rs.getInt("stock"));
            } else {
                Mensaje.crearMensajePersonalizado("Ese celular no existe, intenta de nuevo");
                return null;
            }
        } catch (SQLException e) {
            Mensaje.crearMensajePersonalizado("Hubo un error al buscar el celular: " + e.getMessage());
        }
        return celular;
    }
    
    public void eliminar(int id){
        try (Connection c = conexion.conectar();) {
            PreparedStatement ps = c.prepareStatement("delete from celular where id=?");
            ps.setInt(1, id);
            ps.executeUpdate(); 
            Mensaje.crearMensajePersonalizado("Celular eliminado con exito");
        } catch (SQLException e) {
            Mensaje.crearMensajePersonalizado("Hubo un error al intentar eliminar " + e.getMessage());
        }
    }
}

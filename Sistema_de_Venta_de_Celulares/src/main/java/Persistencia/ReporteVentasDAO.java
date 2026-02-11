
package Persistencia;

import BaseDeDatos.Conexion;
import Modelo.CategoriaGama;
import Modelo.ReporteCelularBajoStock;
import Modelo.ReporteCelularesMasVendidos;
import Modelo.ReporteVentasTotalesPorMes;
import Utilidades.Mensaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Month;
import java.util.ArrayList;



public class ReporteVentasDAO  {
    
    private Conexion conexion = new Conexion();

    public ArrayList<ReporteCelularBajoStock> reporteCelularBajoStock() {
        ArrayList<ReporteCelularBajoStock> celulares = new ArrayList<>();
        try (Connection c = conexion.conectar();) {
            PreparedStatement ps = c.prepareStatement("select marca,modelo,sistema_operativo,gama,stock from celular");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                celulares.add(new ReporteCelularBajoStock(
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("sistema_operativo"),
                        CategoriaGama.valueOf(rs.getString("gama")),
                        rs.getInt("stock")
                ));
            }

        } catch (SQLException e) {
            Mensaje.crearMensajePersonalizado("Hubo un error al buscasr celulares: " + e.getMessage());
        }

        return celulares;
    }

    public ArrayList<ReporteCelularesMasVendidos> reporteCelularesMasVendidos() {
        ArrayList<ReporteCelularesMasVendidos> celulares = new ArrayList<>();
        try (Connection c = conexion.conectar();) {
            PreparedStatement ps = c.prepareStatement("select c.marca, c.modelo, c.sistema_operativo, c.gama, sum(d.cantidad) as totalVentas FROM detalle_venta d inner join celular c ON d.id_celular = c.id group by c.id, c.marca, c.modelo, c.sistema_operativo, c.gama ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                celulares.add(new ReporteCelularesMasVendidos(
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("sistema_operativo"),
                        CategoriaGama.valueOf(rs.getString("gama")),
                        rs.getInt("totalVentas")
                ));
            }

        } catch (SQLException e) {
            Mensaje.crearMensajePersonalizado("Hubo un error al buscar ventas: " + e.getMessage());
        }

        return celulares;
    }
    
    public ArrayList<ReporteVentasTotalesPorMes> reporteVentasPorMes() {
        ArrayList<ReporteVentasTotalesPorMes> celulares = new ArrayList<>();
        try (Connection c = conexion.conectar();) {
            PreparedStatement ps = c.prepareStatement("select month(fecha) as mes, year(fecha) as year, count(*) as ventasTotales from venta group by year(fecha), month(fecha) order by year(fecha), month(fecha)");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                celulares.add(new ReporteVentasTotalesPorMes(
                        Month.of(rs.getInt("mes")),
                        rs.getString("year"),
                        rs.getInt("ventasTotales")
                ));
            }

        } catch (SQLException e) {
            Mensaje.crearMensajePersonalizado("Hubo un error al buscar ventas: " + e.getMessage());
        }

        return celulares;
    }
    
    
    
   
}


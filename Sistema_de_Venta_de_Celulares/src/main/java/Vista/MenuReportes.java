package Vista;


import Modelo.ReporteCelularBajoStock;
import Modelo.ReporteCelularesMasVendidos;
import Modelo.ReporteVentasTotalesPorMes;
import Utilidades.Mensaje;
import java.util.ArrayList;
import java.util.Comparator;

public class MenuReportes {

   
    public void listarReportes(ArrayList<ReporteCelularBajoStock> celulares, ArrayList<ReporteCelularesMasVendidos> celularesMasVendios, ArrayList<ReporteVentasTotalesPorMes> ventasPorMes) {
        if (celulares.isEmpty()) {
            Mensaje.crearMensajePersonalizado("No hay celulares con menos 5 de stock");
        } else {
            Mensaje.crearMensajePersonalizado("Celulares que tiene menos de 5 en stock ");
            celulares.stream()
                    .filter(c -> c.getStock() < 5)
                    .forEach(System.out::println);
        }

        if (celularesMasVendios.isEmpty()) {
            Mensaje.crearMensajePersonalizado("No hay celulares vendidos");
        } else {
            Mensaje.crearMensajePersonalizado("Top 3 celulares mas vendidos");
            celularesMasVendios.stream()
                    .sorted(Comparator.comparingInt(
                            ReporteCelularesMasVendidos::getTotalVentas
                    ).reversed())
                    .limit(3)
                    .forEach(System.out::println);
        }

        if (ventasPorMes.isEmpty()) {
            Mensaje.crearMensajePersonalizado("No hay ventas por mes");
        } else {
            Mensaje.crearMensajePersonalizado("Total de ventas por mes");
            ventasPorMes.stream()
                    .forEach(System.out::println);
        }

    }

}

package Modelo;

import java.time.Month;


public class ReporteVentasTotalesPorMes {
    private Month mes;
    private String year;
    private int ventasTotales;

    public ReporteVentasTotalesPorMes(Month mes, String year, int ventasTotales) {
        this.mes = mes;
        this.year = year;
        this.ventasTotales = ventasTotales;
    }

    public Month getMes() {
        return mes;
    }

    public void setMes(Month mes) {
        this.mes = mes;
    }

    
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getVentasTotales() {
        return ventasTotales;
    }

    public void setVentasTotales(int ventasTotales) {
        this.ventasTotales = ventasTotales;
    }
    
      @Override
    public String toString() {
        return """
            Mes: %-10s | Year: %-15s | Ventas totales: %s,
           """.formatted(mes, year, ventasTotales, ventasTotales);
    }
}


package Controlador;


import Modelo.ReporteCelularBajoStock;
import Modelo.ReporteCelularesMasVendidos;
import Modelo.ReporteVentasTotalesPorMes;
import Persistencia.ReporteVentasDAO;
import java.util.ArrayList;
import Vista.MenuReportes;

public class ControladorReporteVenta {
    private ReporteVentasDAO reporteVentaDAO;
    private MenuReportes reportesMenu;
    
    protected ControladorReporteVenta(){
        reporteVentaDAO = new ReporteVentasDAO();
        reportesMenu = new MenuReportes();
    }
    
    protected void generarReportes(){
        ArrayList<ReporteCelularBajoStock> celularStockBajo= reporteVentaDAO.reporteCelularBajoStock();
        ArrayList<ReporteCelularesMasVendidos> celularesMasVendidos= reporteVentaDAO.reporteCelularesMasVendidos();
        ArrayList< ReporteVentasTotalesPorMes> ventasMes = reporteVentaDAO.reporteVentasPorMes();
        reportesMenu.listarReportes(celularStockBajo, celularesMasVendidos,ventasMes);
        
        
    }
}

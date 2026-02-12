package Persistencia;

import Modelo.Factura;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FacturaDAO {

    public  void guardar(Factura factura) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("reporte_ventas.txt", true))) {
            bw.write(factura.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String listar(){
        StringBuilder facturaEntera = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("reporte_ventas.txt"))) {
            String imprimirFacturas;
            while ((imprimirFacturas = br.readLine()) != null) {
                facturaEntera.append(imprimirFacturas).append("\n"); 
            }
        } catch (Exception e) {
            System.out.println("Todavia no hay regsitros de ventas generados");
        }
        return facturaEntera.toString();
    }

}


package Persistencia;

import Modelo.Factura;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class FacturaDAO {
        ArrayList<Factura> historialFacturas = new ArrayList();
    
     public void guardarFacturaVenta(Factura factura){
         historialFacturas.add(factura);
        try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("reporte_ventas.txt"))){
            oss.writeObject(historialFacturas);
            
 
           
        }catch (Exception e){
            e.printStackTrace();
        }
    }
     
     public void obtener(){
         try (ObjectInputStream oss = new ObjectInputStream(new FileInputStream("reporte_ventas.txt"))){
            oss.readObject();
            
 
           
        }catch (Exception e){
            e.printStackTrace();
        }
     }
}

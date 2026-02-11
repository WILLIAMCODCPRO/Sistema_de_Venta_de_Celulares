
package Modelo;

public class ReporteCelularesMasVendidos {
    private String marca;
    private String modelo;
    private String sistema_operativo;
    private CategoriaGama gama;
    private int totalVentas;

    public ReporteCelularesMasVendidos(String marca, String modelo, String sistema_operativo, CategoriaGama gama, int totalVentas) {
        this.marca = marca;
        this.modelo = modelo;
        this.sistema_operativo = sistema_operativo;
        this.gama = gama;
        this.totalVentas = totalVentas;
    }

  

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSistema_operativo() {
        return sistema_operativo;
    }

    public void setSistema_operativo(String sistema_operativo) {
        this.sistema_operativo = sistema_operativo;
    }

    public CategoriaGama getGama() {
        return gama;
    }

    public void setGama(CategoriaGama gama) {
        this.gama = gama;
    }

    public int getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(int totalVentas) {
        this.totalVentas = totalVentas;
    }

    
       @Override
    public String toString() {
        return """
            Marca: %-10s | Modelo: %-15s | Sistema Operativo: %-10s | Gama: %-5s | Ventas: %s,
           """.formatted(marca, modelo, sistema_operativo, gama, totalVentas);
    }
}


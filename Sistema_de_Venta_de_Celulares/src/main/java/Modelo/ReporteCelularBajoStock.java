package Modelo;


public class ReporteCelularBajoStock {
    private String marca;
    private String modelo;
    private String sistema_operativo;
    private CategoriaGama gama;
    private int stock;

    public ReporteCelularBajoStock(String marca, String modelo, String sistema_operativo, CategoriaGama gama, int stock) {
        this.marca = marca;
        this.modelo = modelo;
        this.sistema_operativo = sistema_operativo;
        this.gama = gama;
        this.stock = stock;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setSistema_operativo(String sistema_operativo) {
        this.sistema_operativo = sistema_operativo;
    }

    public void setGama(CategoriaGama gama) {
        this.gama = gama;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getSistema_operativo() {
        return sistema_operativo;
    }

    public CategoriaGama getGama() {
        return gama;
    }

    public int getStock() {
        return stock;
    }
    
    @Override
    public String toString() {
    return """
           Marca: %-10s | Modelo: %-15s | Sistema Operativo: %-10s | Gama: %-5s | Stock: %s,
           """.formatted( marca, modelo, sistema_operativo, gama, stock);
}
}

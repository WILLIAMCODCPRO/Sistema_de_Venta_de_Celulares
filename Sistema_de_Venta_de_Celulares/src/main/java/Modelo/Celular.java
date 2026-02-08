package Modelo;

public abstract class Celular {

    protected String marca;
    protected String modelo;
    protected String sistema_operativo;
    protected CategoriaGama gama;
    protected double precio;
    protected int stock;

    public Celular(String marca, String modelo, String sistema_operativo, CategoriaGama gama, double precio, int stock) {
        this.marca = marca;
        this.modelo = modelo;
        this.sistema_operativo = sistema_operativo;
        this.gama = gama;
        this.precio = precio;
        this.stock = stock;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    
    public CategoriaGama getGama() {
        return gama;
    }

}

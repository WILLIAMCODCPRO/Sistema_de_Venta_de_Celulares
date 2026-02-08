package Modelo;

public abstract class Celular {

    protected int marca;
    protected int modelo;
    protected int sistema_operativo;
    protected CategoriaGama gama;
    protected double precio;
    protected int stock;

    public Celular(int marca, int modelo, int sistema_operativo, double precio, int stock) {
        this.marca = marca;
        this.modelo = modelo;
        this.sistema_operativo = sistema_operativo;
        this.precio = precio;
        this.stock = stock;
    }


  
    
    public CategoriaGama getGama() {
        return gama;
    }

}

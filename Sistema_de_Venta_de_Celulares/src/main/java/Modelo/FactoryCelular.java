package Modelo;


public class FactoryCelular {
    
    
    
    public Celular crearCelular(CategoriaGama tipoGama, String marca, String modelo, String sistema_operativo, double precio, int stock){
        return switch (tipoGama) {
            case Alta -> new CelularGamaAlta(marca, modelo, sistema_operativo, precio, stock);
            case Media -> new CelularGamaMedia(marca, modelo, sistema_operativo, precio, stock);
            case Baja -> new CelularGamaBaja(marca, modelo, sistema_operativo, precio, stock);
        };
    }
    
    
}

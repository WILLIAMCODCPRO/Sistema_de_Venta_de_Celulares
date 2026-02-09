
package Modelo;


public class CelularBaseDeDatos extends Celular {
    private int id;

    public CelularBaseDeDatos(int id, String marca, String modelo, String sistema_operativo, CategoriaGama gama, double precio, int stock) {
        super(marca, modelo, sistema_operativo, gama, precio, stock);
        this.id = id;
    }

    public CelularBaseDeDatos() {
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    
    @Override
public String toString() {
    return """
           *****************************
           ID:             %s
           Marca:          %s
           Modelo:         %s
           Sistema Op:     %s
           Gama:           %s
           Precio:         %s
           Stock:          %s
           """.formatted(id, marca, modelo, sistema_operativo, gama, precio, stock);
}

}

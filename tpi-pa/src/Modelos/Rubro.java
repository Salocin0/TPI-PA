
package Modelos;
import javax.persistence.Table;

@Table (name="Rubro")
public class Rubro {
    private String nombre;
    private String descripcion;

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}


package Modelos;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Calificacion")
public class Calificacion implements Serializable {
    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
    private long id;
    
    private int estado;
    
    private String descripcion;
    private int calificacion;

    public Calificacion() {
    }

    public Calificacion(String descripcion,int calificacion){
        this.estado = 1;
        this.descripcion=descripcion;
        this.calificacion=calificacion;    
    }
        
    public String getDescripcion() {
        return descripcion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
    
}

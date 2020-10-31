
package Modelos;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="Calificacion")
public class Calificacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_producto_id_seq")
    @SequenceGenerator(name = "categoria_producto_id_seq", sequenceName = "categoria_producto_id_seq", allocationSize = 1) 
    private long id;
    
    private int estado;
    
    private String descripcion;
    private int calificacion;

    public Calificacion() {
        this.estado = 0;
        this.descripcion="";
        this.calificacion=-1;
    }

    public Calificacion(int estado,String descripcion,int calificacion){
        this.estado = estado;
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

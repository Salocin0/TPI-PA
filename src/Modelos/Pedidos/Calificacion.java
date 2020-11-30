
package Modelos.Pedidos;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="calificacion")
public class Calificacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calificacion_id_seq")
    @SequenceGenerator(name = "calificacion_id_seq", sequenceName = "calificacion_id_seq", allocationSize = 1) 
    private long id;
    
    @Column(name = "estado", columnDefinition = "Boolean default 'false'")
    private boolean estado;
    
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    
    @Column(name="calificacion", columnDefinition="Integer default '0'")
    private int calificacion;

    public Calificacion() {
        this.estado = true;
        this.descripcion="";
        this.calificacion=-1;
    }

    public Calificacion(boolean estado,String descripcion,int calificacion){
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

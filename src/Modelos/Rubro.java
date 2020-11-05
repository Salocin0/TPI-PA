
package Modelos;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="Rubro")
public class Rubro implements Serializable, Comparable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_producto_id_seq")
    @SequenceGenerator(name = "categoria_producto_id_seq", sequenceName = "categoria_producto_id_seq", allocationSize = 1) 
    private long id;
    @Column
    private int estado;
    @Column
    private String nombre;
    @Column
    private String descripcion;

    public Rubro() {
    }

    public Rubro(int estado,String nombre,String descripcion){
        this.estado= estado;
        this.nombre=nombre;
        this.descripcion=descripcion;
    }
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int compareTo(Object o) {
        Rubro p=(Rubro) o;
        return this.getNombre().compareTo(p.getNombre());
    }
    /*@Override
    public String toString() {
        return (String.valueOf(id));
    }*/
}

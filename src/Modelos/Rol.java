package Modelos;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Rol") 
public class Rol implements Serializable {
    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
    private long id;
    
    private int estado;
    
    private String nombre;
    private String descripcion;
    //////Set & get ////// NOMBRE
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //////Set & get ////// DESCRIPCION
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    //////Set & get ////// ID
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    //////Set & get ////// ESTADO
    public int getEstado() {
        return estado;
    }
    public void setEstado(int estado) {
        this.estado = estado;
    }
}

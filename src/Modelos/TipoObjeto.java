package Modelos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
 
@Entity
@Table (name="tipo_objeto")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) 
public class TipoObjeto implements Serializable, Comparable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_objeto_id_seq")
    @SequenceGenerator(name = "tipo_objeto_id_seq", sequenceName = "tipo_objeto_id_seq", allocationSize = 1) 
    private long id;
    
    @Column(name = "estado", columnDefinition = "Boolean default 'false'")
    private boolean estado;
   
    @Column(columnDefinition = "TEXT")
    private String nombre;
   
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    
    public TipoObjeto(){
    }
    
    public TipoObjeto(boolean estado,String nombre,String descripcion){
        this.estado=estado;
        this.nombre=nombre;
        this.descripcion=descripcion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   
    public boolean isNuevo() {
        return this.getId()==0;
    }
   
    public void asEliminado() {
        this.setEstado(false);
    }
    
    @Override
    public int compareTo(Object o) {
        return 1;
    }
}
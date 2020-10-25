
package Modelos;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="categoria_producto")
public class CategoriaProducto implements Serializable {
//    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
//    private long id;
    
    
    
      
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_producto_id_seq")
    @SequenceGenerator(name = "categoria_producto_id_seq", sequenceName = "categoria_producto_id_seq", allocationSize = 1) 
    private long id;

    private String nombre;
    private String descripcion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

       public CategoriaProducto(){
           //to-do
       }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}

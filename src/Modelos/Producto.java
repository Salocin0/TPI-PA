
package Modelos;

import java.io.Serializable;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.CascadeType;
import javax.persistence.Table;


@Entity
@Table (name="Producto")
public class Producto implements Serializable{
    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
    private long id;
    private String nombre;
    private String descripcion;
    private float precio;
    @OneToOne (targetEntity = CategoriaProducto.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY) 
    private CategoriaProducto categoria;

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public CategoriaProducto getCategoria() {
        return categoria;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setCategoria(CategoriaProducto categoria) {
        this.categoria = categoria;
    }

  
}

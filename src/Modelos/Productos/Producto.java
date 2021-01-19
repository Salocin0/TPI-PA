package Modelos.Productos;

import Modelos.Categoria_Producto.CategoriaProducto;
import Modelos.Usuarios.Comercios.Comercio;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="producto")
public class Producto implements Serializable, Comparable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "producto_id_seq")
    @SequenceGenerator(name = "producto_id_seq", sequenceName = "producto_id_seq", allocationSize = 1) 
    private long id;
    
    @Column(name = "estado", columnDefinition = "Boolean default 'false'")
    private boolean estado;
    
    @Column(columnDefinition = "TEXT")
    private String nombre;
    
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    
    @Column(name="precio", columnDefinition="Decimal(13,2) default '0.00'")
    private double precio;
    
    @ManyToOne (targetEntity = CategoriaProducto.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY) 
    private CategoriaProducto categoria;
    
    @ManyToOne (targetEntity = Comercio.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    private Comercio comercio;

    public Producto() {
    }
    
    public Producto(boolean estado,String nombre,String descripcion,double precio,CategoriaProducto categoria, Comercio comercios/*,imagen imagen*/){
        this.estado=estado;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.precio=precio;
        this.categoria=categoria;
        this.comercio= comercios;
    }
    
    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
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

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Comercio getComercio() {
        return comercio;
    }

    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
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

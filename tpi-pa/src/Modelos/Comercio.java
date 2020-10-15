package Modelos;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="Comercio")
public class Comercio implements Serializable {
    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
    private long id;
    
    private int estado;
    
    private String nombre;
    private String correoElectronico;
    private String contraseña;
    private String direccionCompleta;
    private String coordenadas;
    @OneToOne (targetEntity = Rubro.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    private Rubro rubro;
    @OneToOne (targetEntity = Calificacion.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    private Calificacion calificacion;
    @ManyToOne (targetEntity = Producto.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    private Producto producto;
    
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
    //////Set & get ////// NOMBRE
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //////Set & get ////// CORREO ELECTRONICO
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    //////Set & get ////// CONTRASEÑA
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    //////Set & get ////// DIRECCION COMPLETA
    public String getDireccionCompleta() {
        return direccionCompleta;
    }
    public void setDireccionCompleta(String direccionCompleta) {
        this.direccionCompleta = direccionCompleta;
    }
    //////Set & get ////// COORDENADAS
    public String getCoordenadas() {
        return coordenadas;
    }
    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }
    //////Set & get ////// RUBRO
    public Rubro getRubro() {
        return rubro;
    }
    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }
    //////Set & get ////// CATEGORIA
    public Calificacion getCalificacion() {
        return calificacion;
    }
    public void setCategoria(Calificacion categoria) {
        this.calificacion = categoria;
    }
    //////Set & get ////// PRODUCTO
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}

package Modelos.Usuarios.Comercios;

import Modelos.Productos.Producto;
import Modelos.Usuarios.Usuario;
import Modelos.Rubros.Rubro;
import Modelos.Usuarios.Usuario;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="comercio")
public class Comercio extends Usuario{
    @ManyToOne (targetEntity = Rubro.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    private Rubro rubro;

    @ManyToOne (targetEntity = Producto.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    private Producto producto;
    
    @Column(name="calificacion", columnDefinition="Decimal(13,2) default '0.00'")
    private double calificacion;

    public Comercio() {
    }
    
    public Comercio(String nombre, String correoElectronico,String contraseña,String direccion, int telefono,Rubro rubro,Producto producto,double calificacion){
        super(nombre, correoElectronico,contraseña,direccion, telefono);
        this.rubro=rubro;
        this.producto=producto;
        this.calificacion=calificacion;
    }
    //////Set & get ////// RUBRO
    public Rubro getRubro() {
        return rubro;
    }
    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }
    //////Set & get ////// PRODUCTO
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
}

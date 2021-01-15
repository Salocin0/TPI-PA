package Modelos.Usuarios.Comercios;

import Modelos.Productos.Producto;
import Modelos.Rubros.Rubro;
import Modelos.Usuarios.Usuario;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="comercio")
public class Comercio extends Usuario{
    @ManyToOne (targetEntity = Rubro.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    private Rubro rubro;

    @OneToMany(mappedBy = "comercio")
    private List<Producto> producto;
    
    @Column(name="calificacion", columnDefinition="Decimal(13,2) default '0.00'")
    private double calificacion;

    public Comercio() {
    }
    
    public Comercio(String nombre, String correoElectronico,String contraseña,String direccion, int telefono,Rubro rubro,Producto producto,double calificacion){
        super(nombre, correoElectronico,contraseña,direccion, telefono);
        this.rubro=rubro;
        this.producto=(List<Producto>) producto;
        this.calificacion=calificacion;
    }
    
    public Rubro getRubro() {
        return rubro;
    }
    
    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }
    
    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

//    @Override
//    public String toString() {
//        return this.getNombre();
//    }
    
    
}
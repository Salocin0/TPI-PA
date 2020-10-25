package Modelos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="Comercio")
public class Comercio extends Usuario{
        
    @ManyToOne (targetEntity = Rubro.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    private Rubro rubro;

    @ManyToOne (targetEntity = Producto.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    private Producto producto;
    
    private Double calificacion;
    
    /*public Comercio(){
        //TO-DO
    }*/
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
    
    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }
}

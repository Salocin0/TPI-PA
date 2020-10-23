
package Modelos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
@Table (name="DetallePedido")
public class DetallePedido implements Serializable {
    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
    private long id;
    
    private int estado;
    @ManyToOne (targetEntity = Producto.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private Producto producto;
    private int cantidad;
    private float subtotal;
    
    @OneToMany (targetEntity = Pedido.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY) 
    private Pedido pedido;
    
    public DetallePedido(){
        //to-do
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getSubtotal() {
        return subtotal;
    }
}

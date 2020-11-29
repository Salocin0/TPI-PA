
package Modelos;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;


@Entity
@Table (name="detalle_pedido")
public class DetallePedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detalle_pedido_id_seq")
    @SequenceGenerator(name = "detalle_pedido_id_seq", sequenceName = "detalle_pedido_id_seq", allocationSize = 1) 
    private long id;
    
    private int estado;
    
    @ManyToOne (targetEntity = Producto.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private Producto producto;
    
    private int cantidad;
    @Column(name="subTotal", columnDefinition="Decimal(13,2) default '0.00'")
    private double subtotal;

    @OneToOne (targetEntity = Pedido.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY) 
    private Pedido pedido;

    public DetallePedido() {
    }
    
    /*public DetallePedido(int estado,int cantidad, Pedido pedido, Producto producto,double subtotal){
        this.estado=estado;
        this.cantidad=cantidad;
        this.pedido=pedido;
        this.producto=producto;
        this.subtotal=subtotal;
                                        
    }*/
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

    public double getSubtotal() {
        return subtotal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
}

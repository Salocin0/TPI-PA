
package Modelos;

import javax.persistence.CascadeType;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.FetchType;


@Entity
@Table (name="DetallePedido")
public class DetallePedido {
    @OneToOne (targetEntity = Producto.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private Producto producto;
    private int cantidad;
    private float subtotal;

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

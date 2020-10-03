package Modelos;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="Pedido")
public class Pedido implements Serializable {
    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
    private long id;
    
    private int estado;
    
    @OneToOne (targetEntity = Usuario.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    private Usuario usuario;
    @OneToOne (targetEntity = Comercio.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    private Comercio comercio;
    @OneToMany (targetEntity = DetallePedido.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    private DetallePedido detallePedido;
    private int subtotal;
    private int total;

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
    //////Set & get ////// USUARIO
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    //////Set & get ////// COMERCIO
    public Comercio getComercio() {
        return comercio;
    }
    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
    }
    //////Set & get ////// DETALLE PEDIDO
    public DetallePedido getDetallePedido() {
        return detallePedido;
    }
    public void setDetallePedido(DetallePedido detallePedido) {
        this.detallePedido = detallePedido;
    }
    //////Set & get ////// SUBTOTAL
    public int getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }
    //////Set & get ////// TOTAL
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
}

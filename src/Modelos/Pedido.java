package Modelos;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;



@Entity
@Table (name="pedido")
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido_id_seq")
    @SequenceGenerator(name = "pedido_id_seq", sequenceName = "pedido_id_seq", allocationSize = 1) 
    private long id;
    
    private boolean estado;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date hora;
    
    @ManyToOne (targetEntity = Cliente.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    private Cliente cliente;
   
    @ManyToOne (targetEntity = Comercio.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY) 
    private Comercio comercio;
    
    
    @OneToMany (targetEntity = DetallePedido.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private Set<DetallePedido> detallePedido = new HashSet();
      
    
    @Column(name="subTotal", columnDefinition="Decimal(13,2) default '0.00'") 
    private double subtotal;
    @Column(name="total", columnDefinition="Decimal(13,2) default '0.00'")
    private double total;
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Set<DetallePedido> getDetallePedido() {
        return detallePedido;
    }

    //////Set & get ////// ID
    public void setDetallePedido(Set<DetallePedido> detallePedido) {    
        this.detallePedido = detallePedido;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    //////Set & get ////// ESTADO
    public boolean getEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    //////Set & get ////// CLIENTE
    public Usuario getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    //////Set & get ////// COMERCIO
    public Comercio getComercio() {
        return comercio;
    }
    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
    }
    //////Set & get ////// DETALLE PEDIDO

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

 
    public Pedido() {
    }
//    public static class DetallePedido {
//
//        public DetallePedido() {
//        }
//    }
//    
}
//   @Column(name="centro2", columnDefinition="Integer default '0'")
//    private int centro2;
    /*@OneToMany(targetEntity = ItemLiquidacionClienteCorrectivaRepuestos.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
    private Set<ItemLiquidacionClienteCorrectivaRepuestos> detalleCorrectivaRepuestos = new HashSet();*/
    
    
//    
//     @Column(name = "obligatorioAsignacionFactura", columnDefinition = "Boolean default 'false'")
//    private boolean obligatorioAsignacionFactura;
    //CALCULAR O GUARDAR??

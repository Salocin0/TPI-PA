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
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table (name="Pedido")
public class Pedido implements Serializable {
    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
    private long id;
    
    private int estado;
    
    public Pedido(){
        //-TO-DO
    }
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date hora;
    //cambiar manytoone
    @ManyToOne (targetEntity = Cliente.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    private Cliente cliente;
   
    @ManyToOne (targetEntity = Comercio.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY) 
    private Comercio comercio;
    
    /*@OneToMany(targetEntity = ItemLiquidacionClienteCorrectivaRepuestos.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
    private Set<ItemLiquidacionClienteCorrectivaRepuestos> detalleCorrectivaRepuestos = new HashSet();*/
    
    @OneToMany (targetEntity = DetallePedido.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private Set<DetallePedido> detallePedido = new HashSet();
      
    //   @Column(name="centro2", columnDefinition="Integer default '0'")
//    private int centro2;
    
    
//    
//     @Column(name = "obligatorioAsignacionFactura", columnDefinition = "Boolean default 'false'")
//    private boolean obligatorioAsignacionFactura;

    @Column(name="subTotal", columnDefinition="Decimal(13,2) default '0.00'") 
    private double subtotal;
  
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
    public int getEstado() {
        return estado;
    }
    public void setEstado(int estado) {
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
    /*public DetallePedido getDetallePedido() {
        return detallePedido;
    }
    public void setDetallePedido(DetallePedido detallePedido) {
        this.detallePedido = detallePedido;
    }*/
 
}

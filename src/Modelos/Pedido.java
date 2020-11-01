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
@Table (name="Pedido")
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_producto_id_seq")
    @SequenceGenerator(name = "categoria_producto_id_seq", sequenceName = "categoria_producto_id_seq", allocationSize = 1) 
    private long id;
    
    private int estado;

    public Pedido() {
        //TO-DO??
        //this.estado=0;
    }
    
    public Pedido(int estado,Date fecha, Date hora, Cliente cliente,Comercio comercio,DetallePedido detallePedido){
        this.estado=estado;
        this.fecha=fecha;
        this.hora=hora;
        this.cliente=cliente;
        this.comercio=comercio;
        this.detallePedido=(Set<DetallePedido>) detallePedido;
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
    //CALCULAR O GUARDAR??
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
    
}

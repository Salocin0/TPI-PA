package Modelos.Pedidos;

import Modelos.Usuarios.Clientes.Cliente;
import Modelos.Usuarios.Comercios.Comercio;
import Modelos.Usuarios.Usuario;
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
public class Pedido implements Serializable,Comparable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido_id_seq")
    @SequenceGenerator(name = "pedido_id_seq", sequenceName = "pedido_id_seq", allocationSize = 1) 
    private long id;
    
    @Column(name = "estado", columnDefinition = "Boolean default 'false'")
    private boolean estado;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    
    @ManyToOne (targetEntity = Cliente.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    private Cliente cliente;
   
    @ManyToOne (targetEntity = Comercio.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY) 
    private Comercio comercio;
    
    @OneToMany (targetEntity = DetallePedido.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private Set<DetallePedido> detallePedido = new HashSet();
    
    @Column(name="total", columnDefinition="Decimal(13,2) default '0.00'")
    private double total;
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Set<DetallePedido> getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(Set<DetallePedido> detallePedido) {    
        this.detallePedido = detallePedido;
    }

    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public boolean getEstado() {
        return estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Usuario getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Comercio getComercio() {
        return comercio;
    }
    
    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public Pedido() {
    }
    
    public boolean isNuevo() {
        return this.getId()==0;
    }
   
    public void asEliminado() {
        this.setEstado(false);
    }
    
    @Override
    public int compareTo(Object o) {
        return 1;
    }
}


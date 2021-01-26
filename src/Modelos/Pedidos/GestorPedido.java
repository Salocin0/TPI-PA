package Modelos.Pedidos;

import static Hibernate.HibernateUtil.getSession;
import Modelos.GestorGn;
import Modelos.Productos.Producto;
import Modelos.Rubros.GestorRubro;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class GestorPedido extends GestorGn {
    
    private GestorRubro gestorRubro= new GestorRubro();
    
    public DetallePedido crearDetalle(int cantidad, Pedido pedido, Producto producto){
        DetallePedido dp = new DetallePedido();
        dp.setCantidad(cantidad);
        dp.setId(0);
        dp.setEstado(true);
        dp.setPedido(pedido);
        dp.setProducto(producto);
        dp.setSubtotal(this.calcularSubtotal(producto, cantidad));
        return dp;
    }
    
    public void guardarDetalle(DetallePedido dp) {
        this.guardarObjeto(dp);
    }
    
    public void guardarPedido(Pedido p) {
           this.guardarObjeto(p);
    }
    
    public float calcularSubtotal(Producto producto, int cantidad){
        return (float) (producto.getPrecio() * cantidad);
    }
    
    public List <Pedido> listar(String fase){   
        return this.listarPedido(Pedido.class,true,-1,fase);
    }
    
    public List listarPedido(Class clase, boolean estado,int max,String fase){
        Criteria crit = getSession().createCriteria(clase).add (Restrictions.eq("estado",estado)).add (Restrictions.eq("fase",fase)).setMaxResults(max);
        return crit.list();
    }

    /*public DefaultComboBoxModel getComboModelRubro() {
         return gestorRubrothrow new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}

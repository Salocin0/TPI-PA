package Modelos.Pedidos;

import Modelos.GestorGn;
import Modelos.Productos.Producto;
import java.util.ArrayList;
import java.util.List;

public class GestorPedido extends GestorGn {
    Pedido pedido;
    List<DetallePedido> listDetallePedido = new ArrayList();
    DetallePedido dp;

    public DetallePedido getDp() {
        if (dp == null) {
           synchronized (DetallePedido.class) {
                dp = new DetallePedido();
           }
        }
        return dp;
    }

    public void setDp(DetallePedido dp) {
        this.dp = dp;
    }

    public List<DetallePedido> getListDetallePedido() {
        return listDetallePedido;
    }

    public void setListDetallePedido(List<DetallePedido> listDetallePedido) {
        this.listDetallePedido = listDetallePedido;
    }

    public Pedido getPedido() {
        if (pedido == null) {
           synchronized (Pedido.class) {
                pedido = new Pedido();
           }
        }
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public void crearDetalle(int cantidad, Pedido pedido, Producto producto){
        //getListDetallePedido().add(this.getDp());
        this.getDp().setCantidad(cantidad);
        this.getDp().setId(0);
        this.getDp().setEstado(true);
        this.getDp().setPedido(pedido);
        this.getDp().setProducto(producto);
        this.getDp().setSubtotal(this.calcularSubtotal(producto, cantidad));
        //this.guardarModelo();
        System.out.println(this.getDp().getId());
        getListDetallePedido().add(this.getDp());
    }
    
    private void guardarModelo() {
        if (this.getDp().isNuevo()) {
           this.guardarObjeto(this.getDp());
        }else{
           this.actualizarObjeto(this.getDp()); 
        }
    }
    
    public float calcularSubtotal(Producto producto, int cantidad){
        return (float) (producto.getPrecio() * cantidad);
    }
}

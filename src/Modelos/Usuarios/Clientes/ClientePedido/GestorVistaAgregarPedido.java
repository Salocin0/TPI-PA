package Modelos.Usuarios.Clientes.ClientePedido;

import Modelos.GestorGn;
import Modelos.Pedidos.DetallePedido;
import Modelos.Pedidos.GestorPedido;
import Modelos.Pedidos.Pedido;
import Modelos.Productos.Producto;
import Modelos.Rubros.Rubro;
import Modelos.Usuarios.Clientes.Cliente;
import Modelos.Usuarios.Comercios.Comercio;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestorVistaAgregarPedido extends GestorGn{
    private VistaAgregarPedido form;
    private Pedido model;
    private Cliente cliente;
    List<DetallePedido> detallePedido;
    Comercio comercio = new Comercio();
    //DetallePedido modeldetalle;
    GestorPedido gp = new GestorPedido();
    
    
    public GestorPedido getGestorPedido() {
        if (gp == null) {
           synchronized (GestorPedido.class) {
                gp = new GestorPedido();
           }
        }
        return gp;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetallePedido> getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(List<DetallePedido> detallePedido) {
        this.detallePedido = detallePedido;
    }

    public VistaAgregarPedido getForm() {
        return form;
    }

    public void setForm(VistaAgregarPedido form) {
        this.form = form;
    }

    public Pedido getModel() {
        return model;
    }

    public void setModel(Pedido model) {
        this.model = model;
    }
    
    public void agregar(){
        if(this.getForm().getTbProductos().getSelectedRow()!=-1){
            String cantidad = JOptionPane.showInputDialog("Ingrese Cantidad:");
            DetallePedido item = getGestorPedido().crearDetalle(Integer.parseInt(cantidad), this.getModel(), (Producto)this.getForm().getTbProductos().getValueAt(this.getForm().getTbProductos().getSelectedRow(), 0));
            this.getForm().getModeloPedido().addRow(new Object[]{item,item.getProducto().getNombre(),item.getProducto().getDescripcion(),item.getProducto().getPrecio(),cantidad,item.getSubtotal()});
            this.getForm().getLbTotal().setText("Total: "+ String.valueOf(this.calcularTotal()));
            this.getForm().estadoPantalla(4);
        }
    }
    
    public void quitar(){
        if(this.getForm().getTbPedido().getSelectedRow()!=-1){
            DefaultTableModel modelopedido = (DefaultTableModel) this.getForm().getTbPedido().getModel();
            modelopedido.removeRow(this.getForm().getTbPedido().getSelectedRow());
            this.getForm().getTbPedido().setModel(modelopedido);
            this.getForm().getLbTotal().setText("Total: "+ String.valueOf(this.calcularTotal()));
        }
    }
    
    public void guardar(){
        if(this.getForm().getTbPedido().getRowCount()<5){//control de que no se pase de 5 productos diferentes
            this.setModel(new Pedido());
            this.setValores();
            getGestorPedido().guardarPedido(this.getModel());
        }
    }
    //mover
    
    public void setValores(){
//        this.
//        this.getModel().setCliente(cliente);
        this.getModel().setComercio(comercio.listarComercio(Comercio.class, this.getForm().getCbComercio().getSelectedItem().toString()));
        this.getModel().setEstado(true);
        this.getModel().setFecha(new Date());
        this.getModel().setTotal(this.calcularTotal());
        this.getModel().setDetallePedido(this.convertToSet((DefaultTableModel) this.getForm().getTbPedido().getModel(),this.getModel()));
        this.getModel().setFase("Recibido");
    }
    
    
    
    public  HashSet convertToSet (DefaultTableModel table,Pedido pedido ) {
         HashSet set=new HashSet();
         for(int i=0;i<table.getRowCount();i++){
             DetallePedido item =(DetallePedido) table.getValueAt(i, 0);
             item.setPedido(pedido);
             set.add(item);
          }
         return set;  
    }
    
    public void cambiarEstado(){
        if(this.getForm().getTbPedido().getRowCount()==0){
            this.getForm().estadoPantalla(3);
        }
    }
    
    private double calcularTotal(){
        double total = 0;
        for(int i=0;i<this.getForm().getTbPedido().getModel().getRowCount();i++){
            DetallePedido det = (DetallePedido) this.getForm().getTbPedido().getModel().getValueAt(i, 0);
            total += det.getSubtotal();
        }
        return total;
    }
        
    public void eliminar(){
        this.getModel().asEliminado();
        this.actualizarObjeto(this.getModel());        
    }

    public void iniciarComboRubro(){
        List list = listarClase(Rubro.class,true,-1);

        for(int i=0;i<list.size();i++){
            this.getForm().getCbRubro().addItem(list.get(i).toString());
        }
        
        //this.getForm().getCbRubro().setModel(this.getGestorPedido().getComboModelRubro());
        
    }
    
    public void iniciarComboComercio(){
        List list = comercio.listarComercio(Comercio.class, buscarR() ,-1);
        for(int i=0;i<list.size();i++){
            this.getForm().getCbComercio().addItem(list.get(i).toString());
        }
    }

    public Rubro buscarR() {
        Rubro r = (Rubro) traerObjeto(Rubro.class,this.getForm().getCbRubro().getSelectedItem().toString(),1);
        return r;
    }
    
    public Comercio buscar() {
        Comercio c = (Comercio) traerObjeto(Comercio.class,this.getForm().getCbComercio().getSelectedItem().toString(),-1);
    return c;
    }

    public DefaultTableModel listarDatosProducto(DefaultTableModel modelTabla) {
        TreeSet<Producto> lista= new TreeSet();
        List<Producto> list = listarProductosPedido(Producto.class, getCantidad() ,buscarComercio());
            Producto auxModel;
            Iterator it = (Iterator) list.iterator();
            while (it.hasNext()) {
                auxModel =(Producto) it.next();
                lista.add(auxModel);
            }
            Iterator it2 = (Iterator) lista.iterator();
            while (it2.hasNext()) {
                auxModel =(Producto) it2.next();
                Object[] fila = {auxModel,auxModel.getId(),auxModel.getNombre(),auxModel.getDescripcion(),auxModel.getCategoria(),auxModel.getPrecio()};
                modelTabla.addRow(fila);
            }
            return modelTabla;
    }

    public Comercio buscarComercio() {
        if(buscarObjeto(Comercio.class,this.getForm().getCbComercio().getSelectedItem().toString(),1)==true){
            Comercio c = (Comercio) traerObjeto(Comercio.class,this.getForm().getCbComercio().getSelectedItem().toString(),1);
            return c;
        } 
        return null;
    }

    public int getCantidad(){
        return this.getForm().cantidad((String) this.getForm().getCbCantidad().getSelectedItem());
    }

    public void open() {
        setForm(new VistaAgregarPedido());
        getForm().setVisible(true); 
    }
}
package Modelos.Usuarios.Clientes.Cliente_Pedido;

import Modelos.Categoria_Producto.CategoriaProducto;
import Modelos.GestorGn;
import Modelos.Pedidos.DetallePedido;
import Modelos.Pedidos.Pedido;
import Modelos.Productos.Producto;
import Modelos.Rubros.Rubro;
import Modelos.Usuarios.Clientes.Cliente;
import Modelos.Usuarios.Comercios.Comercio;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.table.DefaultTableModel;

public class GestorVistaAgrePed extends GestorGn{
    private VistaAgregarPedido form;
    private Pedido model;
    private Cliente cliente;
    List<DetallePedido> detallePedido;

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
    
    public void guardar(){
        if(this.getModel()== null){
            this.setModel(new Pedido());
        }
        setValores();
        this.guardarModelo();   
    }   
    
    public void setValores(){
        Date fecha = new Date();
        this.getModel().setEstado(true);
        this.getModel().setCliente(cliente);
        this.getModel().setFecha(fecha);
        this.getModel().setComercio((Comercio) this.getForm().getCbComercio().getSelectedItem());
        this.getModel().setDetallePedido((Set<DetallePedido>) this.detallePedido);
        this.getModel().setTotal(calcularTotal());
    }
    
    private double calcularTotal(){
        double total = 0;
        for(int i=0;i>detallePedido.size();i++){
            total += detallePedido.get(i).getSubtotal();
        }
        return total;
    }
     
    private void guardarModelo() {
        if (this.getModel().isNuevo()) {
           this.guardarObjeto(this.getModel());
        }else{
           this.actualizarObjeto(this.getModel()); 
        }
        this.model = null;
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
    }
    
    public void iniciarComboComercio(){
        List list = listarComercio(Comercio.class, buscarR() ,-1);
        for(int i=0;i<list.size();i++){
            this.getForm().getCbComercio().addItem(list.get(i).toString());
        }
    }
    
    public void iniciarComboCategoria(){
        List list = listarClase(CategoriaProducto.class,true,-1);
        for(int i=0;i<list.size();i++){
            this.getForm().getCbCatProd().addItem(list.get(i).toString());
        }
    }
    
    public Rubro buscarR() {
        Rubro r = (Rubro) traerObjeto(Rubro.class,this.getForm().getCbRubro().getSelectedItem().toString(),-1);
    return r;
    }
    
    /*public void cargarDatos(Pedido pedido){
        Pedido r = pedido;
        this.setModel(pedido);
        this.getForm().getTxtId().setText(String.valueOf((int) r.getId()));
        this.getForm().getTxtNombre().setText(r.getNombre());
        this.getForm().getTxtDescripcion().setText(r.getDescripcion());
    }*/

    public DefaultTableModel listarDatosProducto(DefaultTableModel modelTabla) {
        TreeSet<Producto> lista= new TreeSet();
        
        /*if(buscarProductosPedido(Producto.class,this.getForm().cantidad((String)this.getForm().getCbCantidad().getSelectedItem()),this.getForm().getCbComercio().getSelectedItem(), this.getForm().getCbCatProd().getSelectedItem())==true) {
            List<Producto> list = listarProductosPedido(Producto.class, this.getForm().cantidad((String) this.getForm().getCbCantidad().getSelectedItem()),this.getForm().getCbComercio().getSelectedItem(), this.getForm().getCbCatProd().getSelectedItem());
            Producto auxModel;
            Iterator it = (Iterator) list.iterator();
            while (it.hasNext()) {
                auxModel =(Producto) it.next();
                lista.add(auxModel);
            }
            Iterator it2 = (Iterator) lista.iterator();
            while (it2.hasNext()) {
                auxModel =(Producto) it2.next();
                Object[] fila = {auxModel,auxModel.getId(),auxModel.getNombre(),auxModel.getDescripcion()};
                modelTabla.addRow(fila);
            }
            return modelTabla;
        }*/
        List<Producto> list = listarProductosPedido(Producto.class, getCantidad() ,buscarComercio(), buscarCatProd());
            Producto auxModel;
            Iterator it = (Iterator) list.iterator();
            while (it.hasNext()) {
                auxModel =(Producto) it.next();
                lista.add(auxModel);
            }
            Iterator it2 = (Iterator) lista.iterator();
            while (it2.hasNext()) {
                auxModel =(Producto) it2.next();
                Object[] fila = {auxModel,auxModel.getId(),auxModel.getNombre(),auxModel.getDescripcion()};
                modelTabla.addRow(fila);
            }
            return modelTabla;
    }
    
    public Comercio buscarComercio() {
        Comercio c = (Comercio) traerObjeto(Comercio.class,this.getForm().getCbComercio().getSelectedItem().toString(),1);
        return c;
    }
    
    public CategoriaProducto buscarCatProd() {
        CategoriaProducto cp = (CategoriaProducto) traerObjeto(Comercio.class,this.getForm().getCbCatProd().getSelectedItem().toString(),1);
        return cp;
    }
    
    public int getCantidad(){
        return this.getForm().cantidad((String) this.getForm().getCbCantidad().getSelectedItem());
    }
     
//    public void imprimir() {
//        this.abrirListado("./Reportes/prueba.jasper");
//        this.agregarParametroListado("titulo", "Listado de rubros");
////      this.agregarParametroListado("imagenReporte", this.pathImagenReporteLogo);
//        this.agregarDatosListado(this.convertTo(this.getForm().getTableRubro()));
//        this.imprimirListado();
//    }
    
   /* private TreeSet convertTo(JTable tbl) {
        TreeSet<AuxGenerico> lista = new TreeSet();
        DefaultTableModel modelo = (DefaultTableModel) tbl.getModel();
        for(int i=0;i<modelo.getRowCount();i++){
            lista.add(new AuxGenerico((Pedido) modelo.getValueAt(i, 0),i));
        }
        return lista;
    }*/
    
    public void open() {
        setForm(new VistaAgregarPedido());
        getForm().setVisible(true); 
    }
}
package Modelos.Usuarios.Clientes.Cliente_Pedido;

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
    
    DetallePedido modeldetalle;

    public DetallePedido getModeldetalle() {
        return modeldetalle;
    }

    public void setModeldetalle(DetallePedido modeldetalle) {
        this.modeldetalle = modeldetalle;
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
    
    public void guardar(){
        this.guardarDetalles();
        if(this.getModel()== null){
            this.setModel(new Pedido());
        }
        setValores();
        this.guardarModelo();   
    }
    
    public void guardarDetalles(){
        System.out.println(getDetallePedido().size());
        for(int i=0;i<getDetallePedido().size();i++){
            this.setModeldetalle(getDetallePedido().get(i));
            this.guardarModeloDetalle();
        }
    }
    
    private void guardarModeloDetalle() {
        if (this.getModel().isNuevo()) {
           this.guardarObjeto(this.getModel());
        }else{
           this.actualizarObjeto(this.getModel()); 
        }
        this.model = null;
    }
    
    public void setValores(){
        Date fecha = new Date();
        this.getModel().setEstado(true);
        this.getModel().setCliente(cliente);
        this.getModel().setFecha(fecha);
        this.getModel().setComercio(buscar());
        this.getModel().setDetallePedido((Set<DetallePedido>) this.detallePedido);
        this.getModel().setTotal(calcularTotal());
    }
    
    public Comercio buscar() {
        Comercio c = (Comercio) traerObjeto(Comercio.class,this.getForm().getCbComercio().getSelectedItem().toString(),-1);
    return c;
    }
    
    private double calcularTotal(){
        double total = 0;
        for(int i=0;i>getDetallePedido().size();i++){
            total += getDetallePedido().get(i).getSubtotal();
        }
        return total;
    }
     
    private void guardarModelo() {
        if (this.getModeldetalle().isNuevo()) {
           this.guardarObjeto(this.getModeldetalle());
        }else{
           this.actualizarObjeto(this.getModeldetalle()); 
        }
        this.modeldetalle = null;
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
    
    public Rubro buscarR() {
        Rubro r = (Rubro) traerObjeto(Rubro.class,this.getForm().getCbRubro().getSelectedItem().toString(),1);
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
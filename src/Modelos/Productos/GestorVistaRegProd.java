package Modelos.Productos;

import AuxReporte.AuxGenericoProducto;
import Modelos.Categoria_Producto.CategoriaProducto;
import Modelos.GestorGn;
import Modelos.Usuarios.Comercios.Comercio;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GestorVistaRegProd extends GestorGn {
    private VistaRegProd form;
    private Producto model;
    private Comercio comercio;

    public Comercio getComercio() {
        return comercio;
    }

    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
    }

    public VistaRegProd getForm() {
        return form;
    }

    public void setForm(VistaRegProd form) {
        this.form = form;
    }

    public Producto getModel() {
        return model;
    }

    public void setModel(Producto model) {
        this.model = model;
    }
    
    public void guardar(){
        if(this.getModel()== null){
            this.setModel(new Producto());
        }
        setValores();
        this.guardarModelo();   
    }   
    
    public void setValores(){
        this.getModel().setEstado(true);
        this.getModel().setNombre(this.getForm().getTxtNombre().getText());
        this.getModel().setDescripcion(this.getForm().getTxtDescripcion().getText());
        this.getModel().setPrecio(Float.valueOf(this.getForm().getTxtPrecio().getText()));
        this.getModel().setComercios((List<Comercio>)this.getComercio());
        this.getModel().setCategoria(buscar());
    }
    public CategoriaProducto buscar() {
        CategoriaProducto r = (CategoriaProducto) traerObjeto(CategoriaProducto.class,this.getForm().getCbCategoria().getSelectedItem().toString(),-1);
    return r;
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
    
    public void cargarDatos(Producto producto){
        Producto r = producto;
        this.setModel(producto);
        this.getForm().getTxtId().setText(String.valueOf((int) r.getId()));
        this.getForm().getTxtNombre().setText(r.getNombre());
        this.getForm().getTxtDescripcion().setText(r.getDescripcion());
        this.getForm().getTxtPrecio().setText(String.valueOf(r.getPrecio()));
        this.getForm().getCbCategoria().setSelectedItem(r.getCategoria());//no funciona
    }
    
    public void iniciarCombo(){
        List list = listarClase(CategoriaProducto.class,true,-1);
        for(int i=0;i<list.size();i++){
            this.getForm().getCbCategoria().addItem(list.get(i).toString());
        }
    }

    public DefaultTableModel listarDatos(DefaultTableModel modelTabla,Class clase) {
        TreeSet<Producto> lista= new TreeSet();
        List<Producto> list = listar(clase,this.getForm().getTxtBuscar().getText(), this.getForm().cantidad((String) this.getForm().getCbCantidad().getSelectedItem()));
        Producto auxModel;
        Iterator it = (Iterator) list.iterator();
        while (it.hasNext()) {
            auxModel =(Producto) it.next();
            lista.add(auxModel);
        }
        Iterator it2 = (Iterator) lista.iterator();
        while (it2.hasNext()) {
            auxModel =(Producto) it2.next();
            Object[] fila = {auxModel,auxModel.getId(),auxModel.getNombre(),auxModel.getDescripcion(),auxModel.getPrecio(),auxModel.getCategoria(),auxModel.getComercios()};
            modelTabla.addRow(fila);  
        }
        return modelTabla;
    }
     
    public void imprimir() {
        this.abrirListado("./Reportes/prueba.jasper");
        this.agregarParametroListado("titulo", "Listado de rubros");
//      this.agregarParametroListado("imagenReporte", this.pathImagenReporteLogo);
        this.agregarDatosListado(this.convertTo(this.getForm().getTableDatos()));
        this.imprimirListado();
    }
    
    private TreeSet convertTo(JTable tbl) {
        TreeSet<AuxGenericoProducto> lista = new TreeSet();
        DefaultTableModel modelo = (DefaultTableModel) tbl.getModel();
        for(int i=0;i<modelo.getRowCount();i++){
            lista.add(new AuxGenericoProducto((Producto) modelo.getValueAt(i, 0),i));
        }
        return lista;
    }

    public void open() {
        setForm(new VistaRegProd());
        getForm().setVisible(true); 
    }
}


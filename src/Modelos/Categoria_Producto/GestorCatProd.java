package Modelos.Categoria_Producto;
import Modelos.GestorGn;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import javax.swing.table.DefaultTableModel;

public class GestorCatProd extends GestorGn{
    private VistaCatProd form;
    private CategoriaProducto model;

    public CategoriaProducto getModel() {
        return model;
    }

    public void setModel(CategoriaProducto model) {
        this.model = model;
    }
  
    public VistaCatProd getForm() {
        return form;
    }
    
    public void setForm(VistaCatProd form) {
        this.form = form;
    }
    
    public void guardar(){
        if (this.getModel()== null){
            this.setModel(new CategoriaProducto());
        }
        setValores();
        this.guardarModelo();   
    }   
    
     public void setValores(){
        this.getModel().setDescripcion(this.getForm().getTxtDescripcion().getText());
        this.getModel().setNombre(this.getForm().getTxtNombre().getText());
        this.getModel().setEstado(true);
    }
     
    private void guardarModelo() {
        if (this.getModel().isNuevo()) {
           this.guardarObjeto(this.getModel());
        }else{
            this.actualizarObjeto(this.getModel()); 
        }
    }
        
    public void eliminar(){
        this.getModel().asEliminado();
        this.actualizarObjeto(this.getModel());        
    }
    
    public void cargarDatos(CategoriaProducto cat){
        CategoriaProducto r = cat;
        this.setModel(cat);
        this.getForm().getTxtId().setText(String.valueOf((int) r.getId()));
        this.getForm().getTxtNombre().setText(r.getNombre());
        this.getForm().getTxtDescripcion().setText(r.getDescripcion());
    }
    
    public DefaultTableModel listarDatos(DefaultTableModel modelTabla,String cadena, int max) {
        TreeSet<CategoriaProducto> lista= new TreeSet();
        List<CategoriaProducto> list = listar(CategoriaProducto.class,cadena, max);
        CategoriaProducto auxModel;
        Iterator it = (Iterator) list.iterator();
        while (it.hasNext())  {
            auxModel =(CategoriaProducto) it.next();
            lista.add(auxModel);
         }
       
        Iterator it2 = (Iterator) lista.iterator();
        while (it2.hasNext())  {
            auxModel =(CategoriaProducto) it2.next();
            Object[] fila = {auxModel,auxModel.getId(),auxModel.getNombre(),auxModel.getDescripcion()};
            modelTabla.addRow(fila);  
        }
        return modelTabla;
    }
    /*
    //revisar, no funcion remplazo del de arriba
    public DefaultTableModel listarDatos() {
        DefaultTableModel modelTabla = (DefaultTableModel) this.getForm().getTableRubro().getModel();
        TreeSet<Rubro> lista= new TreeSet();
        List<Rubro> list = listar(Class.class,this.getForm().getTxtBuscar().getText(), this.getForm().cantidad((String) this.getForm().getCbCantidad().getSelectedItem()));
        Rubro auxModel;
        Iterator it = (Iterator) list.iterator();
        while (it.hasNext())  {
            auxModel =(Rubro) it.next();
            lista.add(auxModel);
         }
       
        Iterator it2 = (Iterator) lista.iterator();
        while (it2.hasNext())  {
            auxModel =(Rubro) it2.next();
            Object[] fila = {auxModel,auxModel.getId(),auxModel.getNombre(),auxModel.getDescripcion()};
            modelTabla.addRow(fila);  
        }
        return modelTabla;
    }
    */
    /////ARREGLAR////////////////////////////////
//    public void imprimir() {
//        this.abrirListado("./Reportes/prueba.jasper");
//        this.agregarParametroListado("titulo", "Listado de rubros");
////      this.agregarParametroListado("imagenReporte", this.pathImagenReporteLogo);
//        this.agregarDatosListado(this.convertTo(this.getForm().getTableDatos()));
//        this.imprimirListado();
//    }
//    
//    private TreeSet convertTo(JTable tbl) {
//        TreeSet<AuxGenerico> lista = new TreeSet();
//        DefaultTableModel modelo = (DefaultTableModel) tbl.getModel();
//        for(int i=0;i<modelo.getRowCount();i++){
//            lista.add(new AuxGenerico( (CategoriaProducto) modelo.getValueAt(i, 0),i));
//        }
//        return lista;
//    }

    public void open() {
        setForm(new VistaCatProd());
        getForm().setVisible(true); 
    }
}

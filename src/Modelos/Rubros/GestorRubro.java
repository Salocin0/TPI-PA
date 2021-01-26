package Modelos.Rubros;

import AuxReporte.AuxGenerico;
import Modelos.GestorGn;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GestorRubro extends GestorGn{
    private VistaRubro form;
    private Rubro model;

    public Rubro getModel() {
        return model;
    }

    public void setModel(Rubro model) {
        this.model = model;
    }
  
    public VistaRubro getForm() {
        return form;
    }
    
    public void setForm(VistaRubro form) {
        this.form = form;
    }
    
    public void guardar(){
        if(this.getModel()== null){
            this.setModel(new Rubro());
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
        this.model = null;
    }
        
    public void eliminar(){
        this.getModel().asEliminado();
        this.actualizarObjeto(this.getModel());        
    }
    
    public void cargarDatos(Rubro rubro){
        Rubro r = rubro;
        this.setModel(rubro);
        this.getForm().getTxtId().setText(String.valueOf((int) r.getId()));
        this.getForm().getTxtNombre().setText(r.getNombre());
        this.getForm().getTxtDescripcion().setText(r.getDescripcion());
    }

    public DefaultTableModel listarDatos(DefaultTableModel modelTabla,Class clase) {
        TreeSet<Rubro> lista= new TreeSet();
        List<Rubro> list = listar(clase,this.getForm().getTxtBuscar().getText(), this.getForm().cantidad((String) this.getForm().getCbCantidad().getSelectedItem()));
        Rubro auxModel;
        Iterator it = (Iterator) list.iterator();
        while (it.hasNext()) {
            auxModel =(Rubro) it.next();
            lista.add(auxModel);
        }
        Iterator it2 = (Iterator) lista.iterator();
        while (it2.hasNext()) {
            auxModel =(Rubro) it2.next();
            Object[] fila = {auxModel,auxModel.getId(),auxModel.getNombre(),auxModel.getDescripcion()};
            modelTabla.addRow(fila);  
        }
        return modelTabla;
    }
     
    public void imprimir() {
        this.abrirListado("./Reportes/prueba.jasper");
        this.agregarParametroListado("titulo", "Listado de rubros");
//      this.agregarParametroListado("imagenReporte", this.pathImagenReporteLogo);
        this.agregarDatosListado(this.convertTo(this.getForm().getTableRubro()));
        this.imprimirListado();
    }
    
    private TreeSet convertTo(JTable tbl) {
        TreeSet<AuxGenerico> lista = new TreeSet();
        DefaultTableModel modelo = (DefaultTableModel) tbl.getModel();
        for(int i=0;i<modelo.getRowCount();i++){
            lista.add(new AuxGenerico((Rubro) modelo.getValueAt(i, 0),i));
        }
        return lista;
    }

    public void open() {
        setForm(new VistaRubro());
        getForm().setVisible(true); 
    }
    
    public List <Rubro> listar(){   
        return this.listarClase(Rubro.class,true,-1);
    }
       
    public DefaultComboBoxModel getComboModel() {      
        DefaultComboBoxModel auxModel= new DefaultComboBoxModel();
        auxModel.addElement("");
        for (Rubro auxTipo : this.listar()) {
            auxModel.addElement(auxTipo);
        }
         return auxModel;
    }
}
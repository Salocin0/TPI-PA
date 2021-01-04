
package Modelos.Usuarios.Administradores.ABMCAdmin;

import AuxReporte.AuxGenericoAdmin;
import Modelos.GestorGn;
import Modelos.Usuarios.Administradores.Administrador;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GestorAdminABMC extends GestorGn{
    private VistaAdminABMC form;
    private Administrador model;

    public Administrador getModel() {
        return model;
    }

    public void setModel(Administrador model) {
        this.model = model;
    }
  
    public VistaAdminABMC getForm() {
        return form;
    }
    
    public void setForm(VistaAdminABMC form) {
        this.form = form;
    }
    
    public void guardar(){
        if(this.getModel()== null){
            this.setModel(new Administrador());
        }
        setValores();
        this.guardarModelo();   
    }   
    
    public void setValores(){
        this.getModel().setContraseña(String.valueOf(this.getForm().getTxtContraseña().getPassword()));
        this.getModel().setCorreo(this.getForm().getTxtCorreo().getText());
        this.getModel().setDireccion(this.getForm().getTxtDireccion().getText());
        this.getModel().setTelefono(Integer.parseInt(this.getForm().getTxtTelefono().getText()));
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
    
    public void cargarDatos(Administrador admin){
        this.setModel(admin);
        this.getForm().getTxtId().setText(String.valueOf((int) this.getModel().getId()));
        this.getForm().getTxtContraseña().setText(this.getModel().getContraseña());
        this.getForm().getTxtCorreo().setText(this.getModel().getCorreo());
        this.getForm().getTxtDireccion().setText(this.getModel().getDireccion());
        this.getForm().getTxtTelefono().setText(String.valueOf((int) this.getModel().getTelefono()));
        this.getForm().getTxtNombre().setText(this.getModel().getNombre());
    }
    
    public DefaultTableModel listarDatos(DefaultTableModel modelTabla,String cadena, int max) {
        TreeSet<Administrador> lista= new TreeSet();
        List<Administrador> list = listar(Administrador.class,cadena, max);
        Administrador auxModel;
        Iterator it = (Iterator) list.iterator();
        while (it.hasNext())  {
            auxModel =(Administrador) it.next();
            lista.add(auxModel);
        }
       
        Iterator it2 = (Iterator) lista.iterator();
        while (it2.hasNext())  {
            auxModel =(Administrador) it2.next();
            Object[] fila = {auxModel,auxModel.getId(),auxModel.getNombre(), auxModel.getCorreo(), auxModel.getContraseña(),auxModel.getDireccion(),auxModel.getTelefono()};
            modelTabla.addRow(fila);  
        }
        return modelTabla;
    }
    //revisar, no funcion remplazo del de arriba
    /*public DefaultTableModel listarDatos() {
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
    }*/
     
    public void imprimir() {
        this.abrirListado("./Reportes/prueba.jasper");
        this.agregarParametroListado("titulo", "Listado de rubros");
//      this.agregarParametroListado("imagenReporte", this.pathImagenReporteLogo);
        this.agregarDatosListado(this.convertTo(this.getForm().getTableDatos()));
        this.imprimirListado();
    }
    
    private TreeSet convertTo(JTable tbl) {
        TreeSet<AuxGenericoAdmin> lista = new TreeSet();
        DefaultTableModel modelo = (DefaultTableModel) tbl.getModel();
        for(int i=0;i<modelo.getRowCount();i++){
            lista.add(new AuxGenericoAdmin((Administrador) modelo.getValueAt(i, 0),i));
        }
        return lista;
    }
    
    public void open() {
        setForm(new VistaAdminABMC());
        getForm().setVisible(true); 
    }
}

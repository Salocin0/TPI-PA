package Modelos.Usuarios.Administradores.ABMCComercio;

import AuxReporte.AuxGenericoCliente;
import AuxReporte.AuxGenericoComercio;
import Modelos.GestorGn;
import Modelos.Rubros.Rubro;
import Modelos.Usuarios.Clientes.Cliente;
import Modelos.Usuarios.Comercios.Comercio;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GestorComercioABMC extends GestorGn{
    private VistaComercioABMC form;
    private Comercio model;

    public Comercio getModel() {
        return model;
    }

    public void setModel(Comercio model) {
        this.model = model;
    }

    public VistaComercioABMC getForm() {
        return form;
    }

    public void setForm(VistaComercioABMC form) {
        this.form = form;
    }
    
    public void guardar(){
        if(this.getModel()== null){
            this.setModel(new Comercio());
        }
        setValores();
        this.guardarModelo();   
    }   
    
    public void setValores(){
        this.getModel().setContraseña(String.valueOf(this.getForm().getTxtContraseña().getPassword()));
        this.getModel().setCorreo(this.getForm().getTxtCorreo().getText());
        this.getModel().setDireccion(this.getForm().getTxtDireccion().getText());
        this.getModel().setTelefono(Integer.getInteger(this.getForm().getTxtTelefono().getText()));
        this.getModel().setNombre(this.getForm().getTxtNombre().getText());
        this.getModel().setEstado(true);
        this.getModel().setRubro((Rubro)this.getForm().getCbRubro().getSelectedItem());
        //this.getModel().setProducto();
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
    
    public void cargarDatos(Comercio comercio){
        this.setModel(comercio);
        this.getForm().getTxtId().setText(String.valueOf((int) this.getModel().getId()));
        this.getForm().getTxtContraseña().setText(this.getModel().getContraseña());
        this.getForm().getTxtCorreo().setText(this.getModel().getCorreo());
        this.getForm().getTxtDireccion().setText(this.getModel().getDireccion());
        this.getForm().getTxtTelefono().setText(String.valueOf((int) this.getModel().getTelefono()));
        this.getForm().getTxtNombre().setText(this.getModel().getNombre());
        this.getForm().getCbRubro().setSelectedItem(this.getModel().getRubro());
        //PRODUCTO
    }
    
    public DefaultTableModel listarDatos(DefaultTableModel modelTabla,String cadena, int max) {
        TreeSet<Comercio> lista= new TreeSet();
        List<Comercio> list = listar(Comercio.class,cadena, max);
        Comercio auxModel;
        Iterator it = (Iterator) list.iterator();
        while (it.hasNext())  {
            auxModel =(Comercio) it.next();
            lista.add(auxModel);
        }
       
        Iterator it2 = (Iterator) lista.iterator();
        while (it2.hasNext())  {
            auxModel =(Comercio) it2.next();
            Object[] fila = {auxModel,auxModel.getId(),auxModel.getNombre(), auxModel.getRubro(), auxModel.getCorreo(), auxModel.getContraseña(),auxModel.getDireccion(),auxModel.getTelefono()/*,PRODUCTO*/};
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
        TreeSet<AuxGenericoComercio> lista = new TreeSet();
        DefaultTableModel modelo = (DefaultTableModel) tbl.getModel();
        for(int i=0;i<modelo.getRowCount();i++){
            lista.add(new AuxGenericoComercio((Comercio) modelo.getValueAt(i, 0),i));
        }
        return lista;
    }
    
    public void open() {
        setForm(new VistaComercioABMC());
        getForm().setVisible(true); 
    }
}

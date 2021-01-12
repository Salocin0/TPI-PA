package Modelos.Usuarios.Administradores.ABMCCliente;

import AuxReporte.AuxGenericoCliente;
import Modelos.GestorGn;
import Modelos.Usuarios.Clientes.Cliente;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GestorClienteABMC extends GestorGn{
    private VistaClienteABMC form;
    private Cliente model;

    public Cliente getModel() {
        return model;
    }

    public void setModel(Cliente model) {
        this.model = model;
    }

    public VistaClienteABMC getForm() {
        return form;
    }

    public void setForm(VistaClienteABMC form) {
        this.form = form;
    }
    
    public void guardar(){
        if(this.getModel()== null){
            this.setModel(new Cliente());
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
        this.getModel().setApellido(this.getForm().getTxtApellido().getText());
        this.getModel().setFechaNacimiento(this.getForm().getTxtFechaNacimiento().getText());
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
    
    public void cargarDatos(Cliente cliente){
        this.setModel(cliente);
        this.getForm().getTxtId().setText(String.valueOf((int) this.getModel().getId()));
        this.getForm().getTxtContraseña().setText(this.getModel().getContraseña());
        this.getForm().getTxtCorreo().setText(this.getModel().getCorreo());
        this.getForm().getTxtDireccion().setText(this.getModel().getDireccion());
        this.getForm().getTxtTelefono().setText(String.valueOf((int) this.getModel().getTelefono()));
        this.getForm().getTxtNombre().setText(this.getModel().getNombre());
        this.getForm().getTxtApellido().setText(this.getModel().getApellido());
        this.getForm().getTxtFechaNacimiento().setText(this.getModel().getFechaNacimiento());
    }

    public DefaultTableModel listarDatos(DefaultTableModel modelTabla,Class clase) {
        TreeSet<Cliente> lista= new TreeSet();
        List<Cliente> list = listar(clase,this.getForm().getTxtBuscar().getText(), this.getForm().cantidad((String) this.getForm().getCbCantidad().getSelectedItem()));
        Cliente auxModel;
        Iterator it = (Iterator) list.iterator();
        while (it.hasNext()) {
            auxModel =(Cliente) it.next();
            lista.add(auxModel);
        }
        Iterator it2 = (Iterator) lista.iterator();
        while (it2.hasNext()) {
            auxModel =(Cliente) it2.next();
            Object[] fila = {auxModel,auxModel.getId(),auxModel.getNombre(), auxModel.getApellido(), auxModel.getCorreo(), auxModel.getContraseña(),auxModel.getDireccion(),auxModel.getTelefono(),auxModel.getFechaNacimiento()};
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
        TreeSet<AuxGenericoCliente> lista = new TreeSet();
        DefaultTableModel modelo = (DefaultTableModel) tbl.getModel();
        for(int i=0;i<modelo.getRowCount();i++){
            lista.add(new AuxGenericoCliente((Cliente) modelo.getValueAt(i, 0),i));
        }
        return lista;
    }
    
    public void open() {
        setForm(new VistaClienteABMC());
        getForm().setVisible(true); 
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelos.GestorRubro;
import Modelos.Rubro;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Hibernate.GestorHibernate;

/**
 *
 * @author nicol
 */
public class GestorABMCRubro implements FuncionesABMC{
    GestorHibernate gh = new GestorHibernate();
    private boolean isItemValidos=true;
    ABMCRubro form;  
    GestorRubro gestor= new GestorRubro();                  
 
 //Definicion de getter y setter de variables, objetos y gestores   

    public GestorHibernate getGh() {
        return gh;
    }

    public void setGh(GestorHibernate gh) {
        this.gh = gh;
    }

    public boolean isIsItemValidos() {
        return isItemValidos;
    }

    public void setIsItemValidos(boolean isItemValidos) {
        this.isItemValidos = isItemValidos;
    }

    public ABMCRubro getForm() {
        return form;
    }

    public void setForm(ABMCRubro form) {
        this.form = form;
    }

    public GestorRubro getGestor() {
        return gestor;
    }

    public void setGestor(GestorRubro gestor) {
        this.gestor = gestor;
    }
    
    
    public void guardar(String nombre,String descripcion) {
        Rubro r = new Rubro(1,nombre,descripcion);
        gh.guardarObjeto(r);
    }
    
    /* private void setItems(JTable tbl) {
        DefaultTableModel modeloTabla= (DefaultTableModel) tbl.getModel();
        for (ItemProyecto item : this.getGestor().getDetalle()) {
             Object[] fila = {item, item.getDenominacion()}; 
             modeloTabla.addRow(fila);
        }
    }
    
    public void addItem() {
        if (this.isItemValidos) {
            DefaultTableModel modeloTabla  = (DefaultTableModel) this.getForm().getTbl().getModel(); 
            ItemProyecto item  = new  ItemProyecto(this.getForm().getTxtItemDenominacion().getText());  
          
            Object[] fila = {item, item.getDenominacion() }; 
            modeloTabla.addRow(fila); 
            this.getForm().clearItemView();
        }    
    }
    */
    @Override
    public void guardar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consultar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /*ABMCRubro form;  
    GestorRubro gestor= new GestorRubro();                  
 
 //Definicion de getter y setter de variables, objetos y gestores   
    public Rubro getModel() {
        return this.gestor.getModel();
    }

    public void setModel(JComboBox cmb) {
        this.setModel((Rubro) cmb.getSelectedItem());
    }

    private void setModel(Rubro model) {
        this.getGestor().setModel(model);
    }

    public GestorRubro getGestor() {
        return gestor;
    }

    public void setGestor(GestorRubro gestor) {
        this.gestor = gestor;
    }

    public ABMCRubro getForm() {
        return form;
    }

    public void setForm(ABMCRubro form) {
        this.form = form;
    }
    /*TO-DO
     public void initializeTabla(JTable tbl) {
        String[] titulo={"","Deuda"};
        String[] ancho ={"5","200"};
        this.newModelTable(tbl,titulo,ancho);  
    } 
    
    
    @Override
    public void newModel() {
        this.gestor.newModel();
        this.setModoNuevo();
    } 

    @Override
    public void cancelarView() {
        
    }

    @Override
    public void deleteView() {
        
         this.getGestor().eliminar();
         this.getForm().viewEliminar();
    }
    
    @Override
    public int setModel() { 
        if (this.isDatosValidos()) {
            this.getGestor().setDenominacion(this.getForm().getTxtDenominacion().getText());     
            this.getGestor().setTipoProyecto((TipoProyecto) this.getForm().getCmbTipoProyecto().getSelectedItem());
            this.getGestor().setDetalle(this.getForm().getTbl());
            return 0;}
        else {
            return 1;
        } 
    }
    
    @Override
    public void saveView() {
        int err;
        err= this.setModel();
        if (err ==0){ 
           this.getGestor().saveModel(this.getOpcABM());
           this.actualizarView();
        }
    }
    
    @Override
    public boolean isDatosValidos() {
        if (this.isEmpty(this.getForm().getTxtDenominacion())) 
           { JOptionPane.showMessageDialog(null, "Falta ingresar la descripción del Proyecto");
            this.getForm().getTxtDenominacion().grabFocus();
            return false; 
           } 
    
        if (this.isEmpty(this.getForm().getTbl())) 
           { JOptionPane.showMessageDialog(null, "Falta ingresar el item de Proyecto");
            this.getForm().getCmbTipoProyecto().grabFocus();
            return false; 
           } 
    
    
         if (this.isEmpty(this.getForm().getCmbTipoProyecto())) 
           { JOptionPane.showMessageDialog(null, "Falta ingresar la tipo de Proyecto");
            this.getForm().getCmbTipoProyecto().grabFocus();
            return false; 
           } 
        return true;
    }

    @Override
    public boolean getModelXCodigo(String codigo) {
        Proyecto auxModel;
        auxModel=this.gestor.buscarCodigo(codigo);
        if (auxModel!=null) {
           this.setModel(auxModel);
           return true;  }
        else {
            return false;
        }
    }

    public void setModelProyecto(JComboBox cmb) {
        cmb.setModel(gestor.getComboModel());
    }
 
    @Override
    public void openFormulario(JDesktopPane pantalla) {
        this.setEscritorio(pantalla);
        this.setForm(new FrmProyecto(this));
        this.setTitulo(this.getForm().getTitle());
        this.getEscritorio().add(this.getForm());
        this.getForm().setVisible(true);
    }
      
    @Override
    public void getView() {
        this.getForm().getTxtCodigo().setText(this.getGestor().getCodigo());
        this.getForm().getTxtDenominacion().setText(this.getGestor().getDenominacion());
        this.getForm().getCmbTipoProyecto().setSelectedItem(this.getGestor().getTipoProyecto());
        this.setItems(this.getForm().getTbl());
    }
    
    @Override
    public void actualizarView() {
        this.getForm().viewGuardar();
        if (this.getOpcABM()==0) {
            this.getForm().getTxtCodigo().setText(this.getGestor().getCodigo());
            this.getGestor().setDetalle(this.getForm().getTbl());
        }
   
    } 

    public void setModelTipoProyecto(JComboBox cmb) {
        cmb.setModel(gestor.getComboModelTipoProyecto());
   }
    
    
   

    private boolean isItemValidos() {
        return true;
    }

    public void removeItem() {
       if (this.isItemTablaSelected(this.getForm().getTbl())){
           this.removeItemTabla(this.getForm().getTbl());
        }
    }

   public void imprimir() {

        this.abrirListado(this.pathReportes+"ListadoTipoDominio.jasper");
        this.agregarParametroListado("titulo", "Proyecto");
         this.agregarParametroListado("usuario", "Yo");
        this.agregarDatosListado(this.gestor.listar());
        this.imprimirListado();
    }

    void openFormularioTipo(DefaultComboBoxModel model) {
         GestorVistaTipoProyecto gestorVistaTipoGasto =new GestorVistaTipoProyecto();
        gestorVistaTipoGasto.openFormulario(model,this.getEscritorio());
    }
}*/

    
}

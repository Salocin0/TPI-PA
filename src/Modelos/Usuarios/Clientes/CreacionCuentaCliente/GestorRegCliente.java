package Modelos.Usuarios.Clientes.CreacionCuentaCliente;

import Hibernate.GestorHibernate;
import Modelos.Usuarios.Clientes.Cliente;

public class GestorRegCliente extends GestorHibernate{
    private VistaRegCliente form;
    private Cliente model;

    public Cliente getModel() {
        return model;
    }

    public void setModel(Cliente model) {
        this.model = model;
    }
  
    public VistaRegCliente getForm() {
        return form;
    }
    
    public void setForm(VistaRegCliente form) {
        this.form = form;
    }
    
    public void open() {
        setForm(new VistaRegCliente());
        getForm().setVisible(true); 
    }
    public void guardar(){
        if (this.getModel()== null){
            this.setModel(new Cliente());
        }
        setValores();
        this.guardarModelo();   
    }   
    
     public void setValores(){
        this.getModel().setApellido(this.getForm().getTxtApellido().getText());
        this.getModel().setContraseña(String.valueOf(this.getForm().getTxtContraseña().getPassword()));
        this.getModel().setCorreo(this.getForm().getTxtCorreo().getText());
        this.getModel().setDireccion(this.getForm().getTxtDireccion().getText());
        this.getModel().setNombre(this.getForm().getTxtNombre().getText());
        this.getModel().setTelefono(Integer.parseInt(this.getForm().getTxtTelefono().getText()));
    }
     
    private void guardarModelo() {
        if (this.getModel().isNuevo()) {
           this.guardarObjeto(this.getModel());
        }else{
            this.actualizarObjeto(this.getModel()); 
        }
    }
    
}

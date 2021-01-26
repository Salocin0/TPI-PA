package Modelos.Usuarios.Clientes.CreacionCuentaCliente;

import Hibernate.GestorHibernate;
import Modelos.Usuarios.Clientes.Cliente;

public class GestorRegistrarCliente extends GestorHibernate{
    private VistaRegistrarCliente form;
    private Cliente model;

    public Cliente getModel() {
        return model;
    }

    public void setModel(Cliente model) {
        this.model = model;
    }
  
    public VistaRegistrarCliente getForm() {
        return form;
    }
    
    public void setForm(VistaRegistrarCliente form) {
        this.form = form;
    }
    
    public void open() {
        setForm(new VistaRegistrarCliente());
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
        this.getModel().setNombre(this.getForm().getTxtNombre().getText());
        this.getModel().setApellido(this.getForm().getTxtApellido().getText());
        this.getModel().setDireccion(this.getForm().getTxtDireccion().getText());
        this.getModel().setTelefono(Integer.parseInt(this.getForm().getTxtTelefono().getText()));
        this.getModel().setFechaNacimiento(this.getForm().getTxtFechaNacimiento().getText());
        this.getModel().setCorreo(this.getForm().getTxtCorreo().getText());
        this.getModel().setContraseña(String.valueOf(this.getForm().getTxtContraseña().getPassword()));
    }
     
    private void guardarModelo() {
        if (this.getModel().isNuevo()) {
           this.guardarObjeto(this.getModel());
        }else{
            this.actualizarObjeto(this.getModel()); 
        }
    }
}
package Modelos.Usuarios.Clientes;

import Modelos.GestorGn;

public class GestorVistaPrincipalCliente extends GestorGn {
    private VistaPrincipalCliente form;
    Cliente cliente = new Cliente();

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public VistaPrincipalCliente getForm() {
        return form;
    }

    public void setForm(VistaPrincipalCliente form) {
        this.form = form;
    }
    
    public void traerCliente(String correo){
        this.cliente = (Cliente) traerUsuario(Cliente.class,correo,1);
    }
    
    public void open() {
        setForm(new VistaPrincipalCliente());
        getForm().setVisible(true); 
    }
}
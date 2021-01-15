package Modelos.Usuarios.Clientes;

import Modelos.GestorGn;

public class GestorVistaPrincipalCliente extends GestorGn {
    private VistaPrincipalCliente form;
    
    
    public VistaPrincipalCliente getForm() {
        return form;
    }

    public void setForm(VistaPrincipalCliente form) {
        this.form = form;
    }
    
    public void open() {
        setForm(new VistaPrincipalCliente());
        getForm().setVisible(true); 
    }
}
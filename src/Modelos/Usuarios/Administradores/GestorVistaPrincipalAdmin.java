package Modelos.Usuarios.Administradores;

import Modelos.GestorGn;

public class GestorVistaPrincipalAdmin extends GestorGn {
    private VistaPrincipalAdmin form;

    public VistaPrincipalAdmin getForm() {
        return form;
    }

    public void setForm(VistaPrincipalAdmin form) {
        this.form = form;
    }
    
    public void open() {
        setForm(new VistaPrincipalAdmin());
        getForm().setVisible(true); 
    }
}
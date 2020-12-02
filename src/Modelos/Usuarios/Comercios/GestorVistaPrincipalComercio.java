package Modelos.Usuarios.Comercios;

import Modelos.GestorGn;

public class GestorVistaPrincipalComercio extends GestorGn {
    private VistaPrincipalComercio form;

    public VistaPrincipalComercio getForm() {
        return form;
    }

    public void setForm(VistaPrincipalComercio form) {
        this.form = form;
    }
    
    public void open() {
        setForm(new VistaPrincipalComercio());
        getForm().setVisible(true); 
    }
}

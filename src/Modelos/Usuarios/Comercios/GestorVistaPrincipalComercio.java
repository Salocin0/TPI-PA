package Modelos.Usuarios.Comercios;

import Modelos.GestorGn;

public class GestorVistaPrincipalComercio extends GestorGn {
    private VistaPrincipalComercio form;
    Comercio comercio = new Comercio();

    public Comercio getComercio() {
        return comercio;
    }

    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
    }

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
    
    public void traerComercio(String correo){
        this.comercio = (Comercio) traerUsuario(Comercio.class,correo,1);
    }
}
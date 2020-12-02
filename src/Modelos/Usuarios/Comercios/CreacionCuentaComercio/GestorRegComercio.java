package Modelos.Usuarios.Comercios.CreacionCuentaComercio;

public class GestorRegComercio {
    private VistaRegComercio form;

    public VistaRegComercio getForm() {
        return form;
    }

    public void setForm(VistaRegComercio form) {
        this.form = form;
    }
    
    public void open() {
        setForm(new VistaRegComercio());
        getForm().setVisible(true); 
    }
}

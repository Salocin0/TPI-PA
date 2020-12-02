package Modelos.Usuarios.Clientes.CreacionCuentaCliente;

public class GestorRegCliente {
    private VistaRegCliente form;

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
}

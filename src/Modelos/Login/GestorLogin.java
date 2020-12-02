package Modelos.Login;

import Modelos.GestorGn;

public class GestorLogin extends GestorGn {
    private Login form;

    public Login getForm() {
        return form;
    }

    public void setForm(Login form) {
        this.form = form;
    }
    
    public void open() {
        setForm(new Login());
        getForm().setVisible(true); 
    }
}

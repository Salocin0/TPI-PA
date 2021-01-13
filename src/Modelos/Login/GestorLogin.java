package Modelos.Login;

import Modelos.GestorGn;
import Modelos.Usuarios.Administradores.Administrador;
import Modelos.Usuarios.Clientes.Cliente;
import Modelos.Usuarios.Comercios.Comercio;

public class GestorLogin extends GestorGn {
    private Login form;

    public Login getForm() {
        return form;
    }

    public void setForm(Login form) {
        this.form = form;
    }
    
    public boolean existeUsuario(){
        int item = this.getForm().getCbTipoLogin().getSelectedIndex();
        
        if(item == 0){
           return true;
            /* Cliente U;
            if(buscarUsuario(Cliente.class,this.getForm().getTxtCorreo().getText())==true){
                U = (Cliente) traerUsuario(Cliente.class,this.getForm().getTxtCorreo().getText(),1); 
                return String.valueOf(this.getForm().getTxtContraseña().getPassword()).equals(U.getContraseña());
            }*/
        }
        if(item == 1){
            Comercio U;
            if(buscarUsuario(Comercio.class,this.getForm().getTxtCorreo().getText())==true){
                U = (Comercio) traerUsuario(Comercio.class,this.getForm().getTxtCorreo().getText(),1); 
                return String.valueOf(this.getForm().getTxtContraseña().getPassword()).equals(U.getContraseña());
            }
        }
        if(item == 2){
            Administrador U;
            if(buscarUsuario(Administrador.class,this.getForm().getTxtCorreo().getText())==true){
                U = (Administrador) traerUsuario(Administrador.class,this.getForm().getTxtCorreo().getText(),1);
                return String.valueOf(this.getForm().getTxtContraseña().getPassword()).equals(U.getContraseña());
            }
        }
        return false;
    }
    
    public void open() {
        setForm(new Login());
        getForm().setVisible(true); 
    }
}

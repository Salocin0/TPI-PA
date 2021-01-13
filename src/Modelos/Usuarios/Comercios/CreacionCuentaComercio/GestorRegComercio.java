package Modelos.Usuarios.Comercios.CreacionCuentaComercio;

import Modelos.GestorGn;
import Modelos.Rubros.Rubro;
import Modelos.Usuarios.Comercios.Comercio;
import java.util.List;

public class GestorRegComercio extends GestorGn{
    private VistaRegComercio form;
    private Comercio model;

    public Comercio getModel() {
        return model;
    }
    public VistaRegComercio getForm() {
        return form;
    }

    public void setForm(VistaRegComercio form) {
        this.form = form;
    }

    public void setModel(Comercio model) {
        this.model = model;
    }
    
    public void open() {
        setForm(new VistaRegComercio());
        getForm().setVisible(true); 
    }
    
    public void guardar(){
        if (this.getModel()== null){
            this.setModel(new Comercio());
        }
        setValores();
        this.guardarModelo();   
    }   
    
     public void setValores(){
        this.getModel().setContraseña(String.valueOf(this.getForm().getTxtContraseña().getPassword()));
        this.getModel().setCorreo(this.getForm().getTxtCorreo().getText());
        this.getModel().setDireccion(this.getForm().getTxtDireccion().getText());
        this.getModel().setNombre(this.getForm().getTxtNombre().getText());
        this.getModel().setTelefono(Integer.parseInt(this.getForm().getTxtTelefono().getText()));
        this.getModel().setRubro(buscar());
    }
    
    public Rubro buscar() {
        Rubro r = (Rubro) traerObjeto(Rubro.class,this.getForm().getCbRubro().getSelectedItem().toString(),-1);
    return r;
    }
    
    public void iniciarCombo(){
        List list = listarClase(Rubro.class,true,-1);
        for(int i=0;i<list.size();i++){
            this.getForm().getCbRubro().addItem(list.get(i).toString());
        }
    }
    
    private void guardarModelo() {
        if (this.getModel().isNuevo()) {
           this.guardarObjeto(this.getModel());
        }else{
            this.actualizarObjeto(this.getModel()); 
        }
    }
}

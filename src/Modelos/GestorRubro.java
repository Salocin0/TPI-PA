package Modelos;
import Hibernate.GestorHibernate;
import static Hibernate.HibernateUtil.getSession;
import java.util.*;
import javax.swing.DefaultComboBoxModel;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class GestorRubro extends  GestorHibernate{
    private Rubro  model;
    
    public Rubro  getModel() {
        return model;
    }

    public void setModel(Rubro  motivoCuota) {
        this.model = motivoCuota;
    }
   

    public int getEstado() {
        return this.getModel().getEstado();
    }

    public void setEstado(int estado) {
        this.getModel().setEstado(estado);
    }
     

       

     

    

   
    public void actualizarObjeto() {
        this.actualizarObjeto(this.getModel());
    }
  
    
   // busquedas, iteradores y otras 
    public List <Rubro> listar(){   
        return this.listarClase(Rubro.class,"codigo",0);
    }
        
    public List <Rubro> listar(int estado){   
          Criteria crit = getSession().createCriteria(Rubro.class)  
                  .add (Restrictions.eq("estado",estado));
        return crit.list();
    }
    
    public DefaultComboBoxModel getComboModel() {      
        DefaultComboBoxModel auxModel= new DefaultComboBoxModel();
        auxModel.addElement("");
        for (Rubro auxTipo : this.listar()) {
            auxModel.addElement(auxTipo);
        }
         return auxModel;
    }  
    

    
    

    public Rubro buscarCodigo(String codigo) {
        return this.buscarCodigo(Integer.valueOf(codigo));
    }
   
    public Rubro buscarCodigo(int codigo) {
       Rubro  auxModel=null;
       try {
          auxModel= (Rubro) this.listarClaseCodigo(Rubro.class, codigo).get(0);
          return auxModel;}
       catch(Exception e){
          return auxModel;
       }
    }

}

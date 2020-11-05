package Modelos;
import Hibernate.GestorHibernate;
import static Hibernate.HibernateUtil.getSession;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class GestorRubro extends  GestorHibernate{
    public List <Rubro> listar(){   
        return this.listarClase(Rubro.class,"id",1);
    }
    
    /*public List listarClase(Class clase,String atributoOrden, int estado){
        Criteria crit = getSession().createCriteria(clase).addOrder(Order.asc(atributoOrden))
                        .add (Restrictions.eq("estado",estado));
        return crit.list();
    }
    
    public List listarClase(int estado){
        Criteria crit = getSession().createCriteria(Rubro.class).add(Restrictions.eq("estado",estado));;
        return crit.list();
    }*/
}

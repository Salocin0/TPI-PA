package Modelos;

import Hibernate.GestorHibernate;
import static Hibernate.HibernateUtil.getSession;
import Modelos.Categoria_Producto.CategoriaProducto;
import Modelos.Usuarios.Comercios.Comercio;
import ireport.GestorDeReportes;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class GestorGn extends GestorHibernate {
    private GestorDeReportes gestorReportes = new GestorDeReportes();
    
    public void abrirListado(String archivo){
        try{
            gestorReportes= new GestorDeReportes(archivo);
            gestorReportes.agregarParametro("tituloMembrete", "");
            gestorReportes.agregarParametro("tituloMembrete2", "");
            gestorReportes.agregarParametro("frase", "");
            gestorReportes.agregarParametro("pieMembrete", "");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void imprimirListado() {
        try{
            gestorReportes.imprimir();
//          gestorReportes.imprimirDirecto();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void agregarDatosListado(HashSet lista) {
        gestorReportes.setColeccionDeDatos(lista);
    }

    public void agregarDatosListado(Set lista) {
        gestorReportes.setColeccionDeDatos(lista);
    }
  
    public void agregarDatosListado(TreeSet listaDatosOrdenada){
        gestorReportes.setColeccionDeDatos(listaDatosOrdenada);
    }

    public void agregarDatosListado(List listaDatosOrdenada){
        gestorReportes.setColeccionDeDatos(listaDatosOrdenada);
    }

    public void agregarParametroListado(String nombre,Object objeto){
        gestorReportes.agregarParametro(nombre, objeto);
    } 
    
    public List listar(Class clase,String cadena,int max){   
        Criteria crit = getSession().createCriteria(clase).addOrder(Order.desc("id"))
            .add (Restrictions.eq("estado",true)).setMaxResults(max);
            if (!cadena.contentEquals("")) {
                crit.add (Restrictions.like("nombre",cadena+"%"));
            }   
        return crit.list();
    }
    public List listarProductos(Class clase,String cadena,int max,Object objeto){   
        Criteria crit = getSession().createCriteria(clase).addOrder(Order.desc("id"))
            .add (Restrictions.eq("estado",true)).setMaxResults(max).add (Restrictions.eq("comercio",objeto));
            if (!cadena.contentEquals("")) {
                crit.add (Restrictions.like("nombre",cadena+"%"));
            }   
        return crit.list();
    }
    
    public List listarProductosPedido(Class clase,int max,Comercio comercio, CategoriaProducto catprod){   
        Criteria crit = getSession().createCriteria(clase).addOrder(Order.desc("id"))
            .add (Restrictions.eq("estado",true)).setMaxResults(max).add (Restrictions.eq("comercio",comercio)).add (Restrictions.eq("categoria",catprod));  
        return crit.list();
    }
    public boolean buscarProductosPedido(Class clase,int max,Object comercio, Object catprod){   
        Criteria crit = getSession().createCriteria(clase).addOrder(Order.desc("id"))
            .add (Restrictions.eq("estado",true)).setMaxResults(max).add (Restrictions.eq("comercio",comercio)).add (Restrictions.eq("categoria",catprod));  
        return !crit.list().isEmpty();
    }
     
    public Object traerObjeto(Class clase){   
       Criteria crit = getSession().createCriteria(clase).addOrder(Order.desc("id"))
            .add (Restrictions.eq("estado",true)).setMaxResults(1);  
        return crit.list().get(0);
    }
    public Object traerObjeto(Class clase,String cadena,int max){   
       Criteria crit = getSession().createCriteria(clase).addOrder(Order.desc("id"))
            .add (Restrictions.eq("estado",true)).setMaxResults(max).add (Restrictions.eq("nombre",cadena));  
        return crit.list().get(0);
    }
    public Object traerUsuario(Class clase,String cadena,int max){   
        Criteria crit = getSession().createCriteria(clase).addOrder(Order.desc("id"))
            .add (Restrictions.eq("estado",true)).setMaxResults(max).add(Restrictions.eq("correoElectronico", cadena));  
        return crit.list().get(0);
    }
    
    public boolean buscarUsuario(Class clase,String cadena){   
        Criteria crit = getSession().createCriteria(clase).addOrder(Order.asc("id"))
            .add (Restrictions.eq("estado",true)).add (Restrictions.eq("correoElectronico",cadena)) ;
        return !crit.list().isEmpty();
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelos.GestorRubro;
import Modelos.Rubro;
import Hibernate.GestorHibernate;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nicol
 */
public class GestorABMCRubro extends GestorVista{
    GestorHibernate gh = new GestorHibernate();
    private boolean isItemValidos=true;
    ABMCRubro form;  
    GestorRubro gestor= new GestorRubro();                  
 
 //Definicion de getter y setter de variables, objetos y gestores   

    public GestorHibernate getGh() {
        return gh;
    }

    public void setGh(GestorHibernate gh) {
        this.gh = gh;
    }

    public boolean isIsItemValidos() {
        return isItemValidos;
    }

    public void setIsItemValidos(boolean isItemValidos) {
        this.isItemValidos = isItemValidos;
    }

    public ABMCRubro getForm() {
        return form;
    }

    public void setForm(ABMCRubro form) {
        this.form = form;
    }

    public GestorRubro getGestor() {
        return gestor;
    }

    public void setGestor(GestorRubro gestor) {
        this.gestor = gestor;
    }
    
    public void guardar(String nombre,String descripcion) {
        Rubro r = new Rubro(0,nombre,descripcion);
        gh.guardarObjeto(r);
    }
     public DefaultTableModel listarDatos(DefaultTableModel modelTabla) {
        TreeSet<Rubro> lista= new TreeSet();
        List<Rubro> list = gestor.listar();
        Rubro auxModel;
        Iterator it = (Iterator) list.iterator();
        while (it.hasNext())  {
            auxModel =(Rubro) it.next();
            lista.add(auxModel);
         }
       
        Iterator it2 = (Iterator) lista.iterator();
        while (it2.hasNext())  {
            auxModel =(Rubro) it2.next();
            Object[] fila = {auxModel,auxModel.getId(),auxModel.getNombre(),auxModel.getDescripcion()};
            modelTabla.addRow(fila);
           
        }
        return modelTabla;
    }

}
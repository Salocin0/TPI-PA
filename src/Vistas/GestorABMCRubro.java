/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelos.GestorRubro;
import Hibernate.GestorHibernate;

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
    
    

}
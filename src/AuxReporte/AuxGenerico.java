/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuxReporte;

import Modelos.Rubros.Rubro;

/**
 *
 * @author Mauro Perelda
 */
public class AuxGenerico  implements Comparable{
    
    private String nombre;
    private long id;
    private String descripcion;
    private int orden;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    

    public AuxGenerico() {
    }

    public AuxGenerico(Rubro rubro, int orden) {
        this.descripcion= rubro.getDescripcion();
         this.nombre= rubro.getNombre();
        this.orden = orden;
    }
    
  
    
    @Override
    public int compareTo(Object o) {
        AuxGenerico p = (AuxGenerico) o;
        return this.getOrden()-p.getOrden();

    }
}
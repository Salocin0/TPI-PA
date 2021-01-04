/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuxReporte;

import Modelos.Rubros.Rubro;
import Modelos.Usuarios.Comercios.Comercio;

/**
 *
 * @author Mauro Perelda
 */
public class AuxGenericoComercio  implements Comparable{
    
    private String nombre;
    private long id;
    private String correo;
    private String Contraseña;
    private int telefono;
    private String Direccion;
    private Rubro rubro;
    private int orden;
    //Producto

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    
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

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    

    public AuxGenericoComercio() {
    }

    public AuxGenericoComercio(Comercio comercio, int orden) {
        this.nombre = comercio.getNombre();
        this.id = comercio.getId();
        this.Contraseña = comercio.getContraseña();
        this.Direccion = comercio.getDireccion();
        this.correo = comercio.getCorreo();
        this.telefono = comercio.getTelefono();
        this.rubro = comercio.getRubro();
        this.orden = orden;
    }
     
    @Override
    public int compareTo(Object o) {
        AuxGenericoComercio p = (AuxGenericoComercio) o;
        return this.getOrden()-p.getOrden();

    }
}

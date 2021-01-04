/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuxReporte;

import Modelos.Usuarios.Administradores.Administrador;

/**
 *
 * @author Mauro Perelda
 */
public class AuxGenericoAdmin  implements Comparable{
    
    private String nombre;
    private long id;
    private String correo;
    private String Contraseña;
    private int telefono;
    private String Direccion;
    private int orden;

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

    

    public AuxGenericoAdmin() {
    }

    public AuxGenericoAdmin(Administrador admin, int orden) {
        this.nombre = admin.getNombre();
        this.id = admin.getId();
        this.Contraseña = admin.getContraseña();
        this.Direccion = admin.getDireccion();
        this.correo = admin.getCorreo();
        this.telefono = admin.getTelefono();
        this.orden = orden;
    }
    
  
    
    @Override
    public int compareTo(Object o) {
        AuxGenericoAdmin p = (AuxGenericoAdmin) o;
        return this.getOrden()-p.getOrden();

    }
}

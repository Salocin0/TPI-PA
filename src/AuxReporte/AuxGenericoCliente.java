/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuxReporte;

import Modelos.Usuarios.Clientes.Cliente;

/**
 *
 * @author Mauro Perelda
 */
public class AuxGenericoCliente  implements Comparable{
    
    private String nombre;
    private long id;
    private String correo;
    private String Contraseña;
    private int telefono;
    private String Direccion;
    private String apellido;
    private String fechaNacimiento;         
    private int orden;

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    

    public AuxGenericoCliente() {
    }

    public AuxGenericoCliente(Cliente cliente, int orden) {
        this.nombre = cliente.getNombre();
        this.id = cliente.getId();
        this.Contraseña = cliente.getContraseña();
        this.Direccion = cliente.getDireccion();
        this.correo = cliente.getCorreo();
        this.telefono = cliente.getTelefono();
        this.apellido = cliente.getApellido();
        this.fechaNacimiento = cliente.getFechaNacimiento();
        this.orden = orden;
    }
     
    @Override
    public int compareTo(Object o) {
        AuxGenericoCliente p = (AuxGenericoCliente) o;
        return this.getOrden()-p.getOrden();

    }
}

package Modelos.Usuarios;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="usuario") 
public class Usuario implements Serializable,Comparable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id_seq")
    @SequenceGenerator(name = "usuario_id_seq", sequenceName = "usuario_id_seq", allocationSize = 1) 
    private long id;
    
    @Column(name = "estado", columnDefinition = "Boolean default 'false'")
    private boolean estado;
    
    @Column(columnDefinition = "TEXT")
    private String nombre;
    
    @Column(columnDefinition = "TEXT")
    private String correoElectronico;
    
    @Column(columnDefinition = "TEXT")
    private String contraseña;
    
    @Column(columnDefinition = "TEXT")
    private String direccion;
    
    @Column(name="telefono", columnDefinition="Integer default '0'")
    private int telefono;

    public Usuario() {
    }
    
    public Usuario(String nombre, String correoElectronico,String contraseña,String direccion, int telefono){
        this.nombre=nombre;
        this.correoElectronico=correoElectronico;
        this.contraseña=contraseña;
        this.direccion=direccion;
        this.telefono=telefono;
    }
    
    public long getId(){
        return id;
    }
    
    public void setId(long id){
        this.id=id;
    }
    
    public boolean getEstado(){
        return estado;
    }
    
    public void setEstado(boolean estado){
        this.estado=estado;
    }

    public String getNombre(){
       return nombre; 
    }
    
    public void setNombre(String nombre){
       this.nombre = nombre;
    }

    public String getCorreo() {
        return correoElectronico;
    }
    
    public void setCorreo(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContraseña() {
        return contraseña;
    }
    
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }
    
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    public boolean isNuevo() {
        return this.getId()==0;
    }
   
    public void asEliminado() {
        this.setEstado(false);
    }

    @Override
    public int compareTo(Object o) {
        return 1;
    }
}

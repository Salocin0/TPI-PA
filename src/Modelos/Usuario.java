package Modelos;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Usuario") 
public class Usuario implements Serializable{

    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
    private long id;
    
    private int estado;
    
    private String nombre;
    private String correoElectronico;
    private String contraseña;
    private String direccion;
    private int telefono;
    private String codigo;
    
    /*public Usuario(String nombre, String correoElectronico,String contraseña,String direccion, int telefono, String codigo){
        this.nombre=nombre;
        this.correoElectronico=correoElectronico;
        this.contraseña=contraseña;
        this.direccion=direccion;
        this.telefono=telefono;
        this.codigo=codigo;
    }*/
    
    //////Set & get ////// ID
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id=id;
    }
    //////Set & get ////// ESTADO
    public int getEstado(){
        return estado;
    }
    public void setEstado(int estado){
        this.estado=estado;
    }
    //////Set & get ////// NOMBRE
    public String getNombre(){
       return nombre; 
    }
    public void setNombre(String nombre){
       this.nombre = nombre;
    }
    //////Set & get ////// APELLIDO
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo= codigo;
    }
    //////Set & get ////// CORREO ELECTRONICO
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    //////Set & get ////// CONTRASEÑA
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    //////Set & get ////// DIRECCION COMPLETA
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    //////Set & get ////// TELEFONO
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}

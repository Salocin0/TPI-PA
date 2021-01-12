package Modelos.Usuarios.Clientes;

import Modelos.Usuarios.Usuario;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name="cliente")
public class Cliente extends Usuario{
    @Column(columnDefinition = "TEXT")
    private String apellido;
    
    //@Temporal(javax.persistence.TemporalType.DATE)
    @Column(columnDefinition = "TEXT")
    private String fechaNacimiento;

    public Cliente() {
    }

    public Cliente(String nombre, String correo,String contraseña,String direccion, int telefono, String apellido,String fechaNacimiento){
        super(nombre, correo,contraseña,direccion, telefono);
        this.apellido=apellido;
        this.fechaNacimiento=fechaNacimiento;
    }
    
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
}
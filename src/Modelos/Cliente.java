package Modelos;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table (name="cliente")
public class Cliente extends Usuario{

    private String apellido;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNacimiento;

    public Cliente(String nombre, String correoElectronico,String contraseña,String direccion, int telefono, String apellido,Date fechaNacimiento){
        super(nombre, correoElectronico,contraseña,direccion, telefono);
        this.apellido=apellido;
        this.fechaNacimiento=fechaNacimiento;
    }
    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}

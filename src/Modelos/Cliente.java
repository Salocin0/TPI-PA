package Modelos;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table (name="Cliente")
public class Cliente extends Usuario{

    private String apellido;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNacimiento;

    /*public Cliente() {
    }

    public Cliente(String apellido,Date fechaNacimiento){
        //TO-DO
    }*/
    
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


package Modelos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name="Administrador")
public class Administrador extends Usuario{
    private String rango;

    public Administrador(String nombre, String correoElectronico,String contraseña,String direccion, int telefono, String rango){
        super(nombre, correoElectronico,contraseña,direccion, telefono);
        this.rango=rango;
    }
    
    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }
    
}

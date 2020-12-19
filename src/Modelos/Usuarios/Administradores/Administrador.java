
package Modelos.Usuarios.Administradores;

import Modelos.Usuarios.Usuario;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name="administrador")
public class Administrador extends Usuario{
    
    @Column(columnDefinition = "TEXT")
    private String rango;

    public Administrador() {
    }

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

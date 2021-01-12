package Modelos.Usuarios.Administradores;

import Modelos.Usuarios.Usuario;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name="administrador")
public class Administrador extends Usuario{

    public Administrador() {
    }

    public Administrador(String nombre, String correo,String contraseña,String direccion, int telefono){
        super(nombre,correo,contraseña,direccion, telefono);
    }
}
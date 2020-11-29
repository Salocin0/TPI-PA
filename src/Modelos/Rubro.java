package Modelos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name="Rubro")
public class Rubro extends TipoObjeto {
    
    public Rubro() {
        super();
    }

    public Rubro(boolean estado,String nombre,String descripcion){
        super(estado,nombre,descripcion);

    }

    @Override
    public int compareTo(Object o) {
        Rubro p=(Rubro) o;
        return this.getNombre().compareTo(p.getNombre());
    }
}
package Modelos.Productos;

import Modelos.TipoObjeto;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name="categoria_producto")
public class CategoriaProducto extends TipoObjeto {  
  
    public CategoriaProducto(){
        super();
    }
    
    public CategoriaProducto(boolean estado,String nombre, String descripcion){
        super(estado,nombre,descripcion);
    } 
    /*
    @Override
    public int compareTo(Object o) {
        Rubro p=(Rubro) o;
        return this.getNombre().compareTo(p.getNombre());
    }*/
}

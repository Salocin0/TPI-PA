package Modelos.Categoria_Producto;

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
    
    @Override
    public int compareTo(Object o) {
        CategoriaProducto p=(CategoriaProducto) o;
        return this.getNombre().compareTo(p.getNombre());
    }
    
    @Override
    public String toString(){
        return this.getNombre();
    }
}

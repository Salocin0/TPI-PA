
package Modelos;

public class CategoriaProducto {
    private String nombre;
    private String descripcion;

       public CategoriaProducto(){
           //to-do
       }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}

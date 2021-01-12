package AuxReporte;

import Modelos.Categoria_Producto.CategoriaProducto;
import Modelos.Productos.Producto;
import Modelos.Usuarios.Comercios.Comercio;

public class AuxGenericoProducto implements Comparable {
    
    private String nombre;
    private long id;
    private String descripcion;
    private double precio;
    CategoriaProducto categoria;
    Comercio comercio;
    private int orden;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public AuxGenericoProducto() {
    }

    public AuxGenericoProducto(Producto producto, int orden) {
        this.descripcion= producto.getDescripcion();
        this.nombre= producto.getNombre();
        this.orden = orden;
        this.precio= (float) producto.getPrecio();
        this.categoria = producto.getCategoria();
        this.comercio = (Comercio) producto.getComercios();
    }
    
    @Override
    public int compareTo(Object o) {
        AuxGenerico p = (AuxGenerico) o;
        return this.getOrden()-p.getOrden();

    }
}

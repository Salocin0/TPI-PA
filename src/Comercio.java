public class Comercio {
    private String nombre;
    private String correoElectronico;
    private String contraseña;
    private String direccionCompleta;
    private String coordenadas;
    private Rubro rubro;
    private Categoria categoria;
    private Productos producto;
    //////Set & get ////// NOMBRE
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //////Set & get ////// CORREO ELECTRONICO
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    //////Set & get ////// CONTRASEÑA
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    //////Set & get ////// DIRECCION COMPLETA
    public String getDireccionCompleta() {
        return direccionCompleta;
    }
    public void setDireccionCompleta(String direccionCompleta) {
        this.direccionCompleta = direccionCompleta;
    }
    //////Set & get ////// COORDENADAS
    public String getCoordenadas() {
        return coordenadas;
    }
    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }
    //////Set & get ////// RUBRO
    public Rubro getRubro() {
        return rubro;
    }
    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }
    //////Set & get ////// CATEGORIA
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    //////Set & get ////// PRODUCTO
    public Productos getProducto() {
        return producto;
    }
    public void setProducto(Productos producto) {
        this.producto = producto;
    }
}

public class Usuario {
    //@Entity
    //@Table (name="tipo_proyecto") 
    
    private long id;
    
    private int estado;
    
    private String nombre;
    private String apellido;
    private String correElectronico;
    private String contraseña;
    private String direccionCompleta;
    private int telefono;
    private String fechaNacimiento;
    private Rol rol;
    //////Set & get ////// ID
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id=id;
    }
    //////Set & get ////// ESTADO
    public int getEstado(){
        return estado;
    }
    public void setEstado(int estado){
        this.estado=estado;
    }
    //////Set & get ////// NOMBRE
    public String getNombre(){
       return nombre; 
    }
    public void setNombre(String nombre){
       this.nombre = nombre;
    }
    //////Set & get ////// APELLIDO
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    //////Set & get ////// CORREO ELECTRONICO
    public String getCorreElectronico() {
        return correElectronico;
    }
    public void setCorreElectronico(String correElectronico) {
        this.correElectronico = correElectronico;
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
    //////Set & get ////// TELEFONO
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    //////Set & get ////// FECHA NACIMIENTO
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    //////Set & get ////// ROL
    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }
}

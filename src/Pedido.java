public class Pedido {
    private Usuario usuario;
    private Comercio comercio;
    private DetallePedido detallePedido;
    private int subtotal;
    private int total;
    //////Set & get ////// USUARIO
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    //////Set & get ////// COMERCIO
    public Comercio getComercio() {
        return comercio;
    }
    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
    }
    //////Set & get ////// DETALLE PEDIDO
    public DetallePedido getDetallePedido() {
        return detallePedido;
    }
    public void setDetallePedido(DetallePedido detallePedido) {
        this.detallePedido = detallePedido;
    }
    //////Set & get ////// SUBTOTAL
    public int getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }
    //////Set & get ////// TOTAL
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
}

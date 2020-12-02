package TPI_PA;

import Hibernate.HibernateUtil;
import Modelos.Login.GestorLogin;

public class Main {
   public static void main(String[] args) {
        HibernateUtil.inicializar();
        ///////////////////////Rubro/////////////////////////
        //GestorRubro gr = new GestorRubro();
        //gr.open();
        ///////////////////////CategoriaProducto/////////////
        //GestorCatProd gr = new GestorCatProd();
        //gr.open();
        ///////////////////////Login////////////////////////
        GestorLogin gl = new GestorLogin();
        gl.open();
    }
}

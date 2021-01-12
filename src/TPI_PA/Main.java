package TPI_PA;

import Hibernate.HibernateUtil;
import Modelos.Login.GestorLogin;

public class Main {
   public static void main(String[] args) {
        HibernateUtil.inicializar();
        GestorLogin gl = new GestorLogin();
        gl.open();
    }
}
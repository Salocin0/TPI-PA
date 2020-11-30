package TPI_PA;

import Hibernate.HibernateUtil;
import Modelos.Rubros.GestorRubro;

public class Main {
   public static void main(String[] args) {
        HibernateUtil.inicializar();
        ///////////////////////Rubro/////////////////////////
        GestorRubro gr = new GestorRubro();
        gr.open();
        ///////////////////////CategoriaProducto/////////////
        //GestorCategoriaProducto gr = new GestorCategoriaProducto();
        //gr.open();
    }
}

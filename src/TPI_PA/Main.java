package TPI_PA;

import Hibernate.HibernateUtil;
import Modelos.Categoria_Producto.GestorCatProd;
import Modelos.Rubros.GestorRubro;

public class Main {
   public static void main(String[] args) {
        HibernateUtil.inicializar();
        ///////////////////////Rubro/////////////////////////
        //GestorRubro gr = new GestorRubro();
        //gr.open();
        ///////////////////////CategoriaProducto/////////////
        GestorCatProd gr = new GestorCatProd();
        gr.open();
    }
}

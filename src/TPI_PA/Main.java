package TPI_PA;

import Hibernate.HibernateUtil;
import Vistas.ABMCRubro; 

public class Main {

   public static void main(String[] args) {
        HibernateUtil.inicializar();
        ABMCRubro a = new ABMCRubro();
        a.show(true);

    }
    
}

package TPI_PA;

import Hibernate.HibernateUtil;
import Modelos.Rubro;
import Vistas.ABMCRubro; 
import java.util.List;
import javax.persistence.Query;

public class Main {

   public static void main(String[] args) {
        HibernateUtil.inicializar();
        ABMCRubro a = new ABMCRubro();
        a.show(true);

    }
    
}

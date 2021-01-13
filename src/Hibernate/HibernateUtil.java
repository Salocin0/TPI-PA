package Hibernate;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtil  {
    public static SessionFactory sessionFactory;
    public static Session session;

    public static void inicializar() {
        try {
           Configuration conf = new Configuration(); 
           try{
                conf.setProperty("hibernate.connection.driver_class","org.postgresql.Driver");
                conf.setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");                 
                conf.setProperty("hibernate.connection.url","jdbc:postgresql://localhost:5432/TPI-PA");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error de Base de Datos N° 2001");
            }
            
            conf.setProperty("hibernate.connection.username","postgres");
            conf.setProperty("hibernate.connection.password","00");
            conf.setProperty("hibernate.connection.pool_size","10");                          
            conf.setProperty("hibernate.hbm2ddl.auto","update");
            conf.addPackage("Modelos");
            
            conf.addAnnotatedClass(Modelos.Usuarios.Clientes.Cliente_Pedido.Calificacion.class);
            conf.addAnnotatedClass(Modelos.Categoria_Producto.CategoriaProducto.class);
            conf.addAnnotatedClass(Modelos.Usuarios.Clientes.Cliente.class);
            conf.addAnnotatedClass(Modelos.Rubros.Rubro.class);
            conf.addAnnotatedClass(Modelos.Usuarios.Usuario.class);
            conf.addAnnotatedClass(Modelos.TipoObjeto.class);
            
            conf.addAnnotatedClass(Modelos.Usuarios.Administradores.Administrador.class);
            conf.addAnnotatedClass(Modelos.Usuarios.Comercios.Comercio.class);
            conf.addAnnotatedClass(Modelos.Productos.Producto.class);
            
            conf.addAnnotatedClass(Modelos.Pedidos.DetallePedido.class);
            conf.addAnnotatedClass(Modelos.Pedidos.Pedido.class);
            
            try {
                    sessionFactory = conf.buildSessionFactory();
                    session=sessionFactory.openSession();
                }
                catch(HibernateException e){
                    JOptionPane.showMessageDialog(null, e);
                }
        } catch (HeadlessException | MappingException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static Session getSession()
    throws HibernateException {
        return session;
    }
}

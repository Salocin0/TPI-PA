package Modelos;
import AuxReporte.AuxGenerico;
import Hibernate.GestorHibernate;
import Vistas.ABMCRubro;
import Vistas.GestorVista;
import ireport.GestorDeReportes;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class GestorRubro extends GestorHibernate{
    ABMCRubro form;
    private GestorDeReportes gestorReportes;

    public ABMCRubro getForm() {
        return form;
    }

    public void setForm(ABMCRubro form) {
        this.form = form;
    }
        
    public List <Rubro> listar(int max){
        if(max==1){
            return this.listarClase(Rubro.class,"id",true,3);
        }
        if(max==2){
            return this.listarClase(Rubro.class,"id",true,-1);
        }
        
        return this.listarClase(Rubro.class,"id",true,1);
    }
    
    public void Guardar(){
        Rubro r = new Rubro();
        r.setDescripcion(this.getForm().getTxtDescripcion().getText());
        r.setNombre(this.getForm().getTxtNombre().getText());
        r.setEstado(this.getForm().getCbEstado().isSelected());
        
        
        this.guardarObjeto(r);
    }
    
    public void Modificar(Rubro rubro){
        Rubro r = rubro;
        r.setDescripcion(this.getForm().getTxtDescripcion().getText());
        r.setNombre(this.getForm().getTxtNombre().getText());
        r.setEstado(this.getForm().getCbEstado().isSelected());
        this.actualizarObjeto(r);
    }
     
    public void Eliminar(Rubro rubro){
        Rubro r = rubro;
        r.setEstado(false);
        this.actualizarObjeto(r);        
    }
    
    public void CargarDatos(Rubro rubro){
        Rubro r = rubro;
        this.getForm().getTxtId().setText(String.valueOf((int) r.getId()));
        this.getForm().getTxtNombre().setText(r.getNombre());
        this.getForm().getTxtDescripcion().setText(r.getDescripcion());
        this.getForm().getCbEstado().setSelected(r.getEstado());
    }
    
    public List <Rubro> listar(String dato){   
       Criteria crit = getSession().createCriteria(Rubro.class).addOrder(Order.asc("nombre"))
            .add (Restrictions.eq("estado",true));
            if (!dato.contentEquals("")) {
//                   crit.add (Restrictions.like("nombre","%"+dato+"%"));
                   crit.add (Restrictions.like("nombre",dato+"%"));
             }   
      
        return crit.list();
    }
    public DefaultTableModel listarDatos(DefaultTableModel modelTabla,int max) {
        TreeSet<Rubro> lista= new TreeSet();
        List<Rubro> list = listar(max);
        Rubro auxModel;
        Iterator it = (Iterator) list.iterator();
        while (it.hasNext())  {
            auxModel =(Rubro) it.next();
            lista.add(auxModel);
         }
       
        Iterator it2 = (Iterator) lista.iterator();
        while (it2.hasNext())  {
            auxModel =(Rubro) it2.next();
            Object[] fila = {auxModel,auxModel.getId(),auxModel.getNombre(),auxModel.getDescripcion()};
            modelTabla.addRow(fila);
           
        }
        return modelTabla;
    }
    public DefaultTableModel listarDatos2(DefaultTableModel modelTabla) {
        TreeSet<Rubro> lista= new TreeSet();
        Rubro auxModel;
        String nombre ="";
        if (!form.getTxtBuscar().getText().contentEquals("")) {
           nombre= form.getTxtBuscar().getText();
        }
        
        List<Rubro> list = this.listar(nombre);    
        Iterator it = (Iterator) list.iterator();
        while (it.hasNext())  {
            auxModel =(Rubro) it.next();
            lista.add(auxModel);
         }
       
        Iterator it2 = (Iterator) lista.iterator();
        while (it2.hasNext())  {
            auxModel =(Rubro) it2.next();
            Object[] fila = {auxModel,auxModel.getId(),auxModel.getNombre(),auxModel.getDescripcion()};
            modelTabla.addRow(fila);
           
        }
        return modelTabla;
    }
    
    public void imprimir() {
        this.abrirListado("Rubro.jasper");
        this.agregarParametroListado("titulo", "Listado de rubros");
//        this.agregarParametroListado("imagenReporte", this.pathImagenReporteLogo);
        this.agregarDatosListado(this.convertTo(this.getForm().getTableRubro()));
        this.imprimirListado();
    }

    private TreeSet convertTo(JTable tbl) {
         TreeSet<AuxGenerico> lista = new TreeSet();
        DefaultTableModel modelo = (DefaultTableModel) tbl.getModel();
        for(int i=0;i<modelo.getRowCount();i++){
            lista.add(new AuxGenerico((Rubro) modelo.getValueAt(i, 0),i));
        }
        return lista;
    }
    public void abrirListado(String archivo){
        try{
            gestorReportes= new GestorDeReportes(archivo);
            gestorReportes.agregarParametro("tituloMembrete", "");
            gestorReportes.agregarParametro("tituloMembrete2", "");
            gestorReportes.agregarParametro("frase", "");
            gestorReportes.agregarParametro("pieMembrete", "");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void imprimirListado() {
        try{
            gestorReportes.imprimir();
//             gestorReportes.imprimirDirecto();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void agregarDatosListado(HashSet lista) {
        gestorReportes.setColeccionDeDatos(lista);
    }

    public void agregarDatosListado(Set lista) {
        gestorReportes.setColeccionDeDatos(lista);
    }
  
    public void agregarDatosListado(TreeSet listaDatosOrdenada){
        gestorReportes.setColeccionDeDatos(listaDatosOrdenada);
    }

    public void agregarDatosListado(List listaDatosOrdenada){
        gestorReportes.setColeccionDeDatos(listaDatosOrdenada);
    }

    public void agregarParametroListado(String nombre,Object objeto){
        gestorReportes.agregarParametro(nombre, objeto);
    }
   
}

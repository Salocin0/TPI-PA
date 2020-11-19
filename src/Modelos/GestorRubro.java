package Modelos;
import AuxReporte.AuxGenerico;
import Hibernate.GestorHibernate;
import Vistas.ABMCRubro;
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
    private ABMCRubro form;
    private GestorDeReportes gestorReportes = new GestorDeReportes();
   private  Rubro model;

    public Rubro getModel() {
        return model;
    }

    public void setModel(Rubro model) {
        this.model = model;
    }
  
    public ABMCRubro getForm() {
        return form;
    }
    
    public void setForm(ABMCRubro form) {
        this.form = form;
    }
    
    public void guardar(){
         if (this.getModel()== null){
             this.setModel(new Rubro());
         }
         setValores(this.getModel());
         this.guardarModelo();   
    }   
    
    public void setValores(Rubro r){
        r.setDescripcion(this.getForm().getTxtDescripcion().getText());
        r.setNombre(this.getForm().getTxtNombre().getText());
        r.setEstado(true);
    }
    
    private void guardarModelo() {
        if (this.getModel().getId()==0) {
           this.guardarObjeto(this.getModel());
        }
        else{
            this.actualizarObjeto(this.getModel()); 
        }

    }
    
    public void eliminar(Rubro rubro){
        Rubro r = rubro;
        r.setEstado(false);
        this.actualizarObjeto(r);        
    }
    
    public void cargarDatos(Rubro rubro){
        Rubro r = rubro;
        this.setModel(rubro);
        this.getForm().getTxtId().setText(String.valueOf((int) r.getId()));
        this.getForm().getTxtNombre().setText(r.getNombre());
        this.getForm().getTxtDescripcion().setText(r.getDescripcion());
    }
    
    public List <Rubro> listar(String cadena,int max){   
       Criteria crit = getSession().createCriteria(Rubro.class).addOrder(Order.asc("id"))
            .add (Restrictions.eq("estado",true)).setMaxResults(max);
            if (!cadena.contentEquals("")) {
                crit.add (Restrictions.like("nombre",cadena+"%"));
            }   
        return crit.list();
    }

     public DefaultTableModel listarDatos(DefaultTableModel modelTabla,String cadena, int max) {
        TreeSet<Rubro> lista= new TreeSet();
        List<Rubro> list = listar(cadena, max);
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
    
    public void imprimir() {
        this.abrirListado("./Reportes/Rubro.jasper");
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

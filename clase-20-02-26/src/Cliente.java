
import java.util.List;


public class Cliente extends  Comparable {

    private String nombre; 
    private String identificacion; 
    private int Edad; 
    private List<Pedido> listaPedidos;




    public Cliente(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.Edad = Edad;
        this.listaPedidos = listaPedidos;
    }

    



    public String getNombre() {
        return nombre;
    }





    public void setNombre(String nombre) {
        this.nombre = nombre;
    }





    public String getIdentificacion() {
        return identificacion;
    }





    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }





    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }





    public void setListaPedidos(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }





    
    public int compareTo(Cliente o){

        return nombre.compareTo(o.getNombre());
    





        





   


    
    



}





    public int getEdad() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEdad'");
    }
}

import java.util.LinkedList;

public class Cliente {

    private String nombre;
    private String identificacion;
    private LinkedList<Pedido>listaPedidos;

    public Cliente(String identificacion, String nombre) {
        super();
        this.identificacion = identificacion;
        this.nombre = nombre;
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



    @Override
    protected Object clone() throws CloneNotSupportedException{
        Cliente cliente = new Cliente(identificacion, nombre);
        for(Pedido pedido: listaPedidos){
            cliente.getPedidos(pedido.clone);
        }
        return cliente;
    }

    private void getPedidos(Object clone) {
        throw new UnsupportedOperationException("Not supported yet.");
    }



}

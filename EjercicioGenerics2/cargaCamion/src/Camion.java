
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class Camion<E extends Paquete> implements Iterable<E> {

    private String placa; 
    private double capacidadCarga;
    private ArrayList<E> paquetes;

    public Camion(double capacidadCarga, ArrayList<E> paquetes, String placa) {
        this.capacidadCarga = capacidadCarga;
        this.paquetes = paquetes;
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public ArrayList<E> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(ArrayList<E> paquetes) {
        this.paquetes = paquetes;
    }

    @Override
    public Iterator<E> iterator() {
        return paquetes.iterator();
    }

    public void recorrerPaquetes(Consumer<E> accion) {
        Iterator<E> iterator = paquetes.iterator();
        while (iterator.hasNext()) {
            accion.accept(iterator.next());
        }
    }

    


    

    
     


    
    
}

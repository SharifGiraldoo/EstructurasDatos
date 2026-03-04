
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {


        ArrayList<Paquete> paquetes = new ArrayList<>();
        Camion<Paquete> camion = new Camion<>(20000, paquetes, "ABC123");
        paquetes.add(new Paquete("P001", 500));
        paquetes.add(new Paquete("P002", 33500));

        camion.recorrerPaquetes(paquete ->
            System.out.println("Paquete en lista: " + paquete.getCodigo() + " - " + paquete.getPeso() + " kg")
        );

        cargarCamion(camion, paquetes);
        descargarCamion(camion, paquetes);
        
        


        

    }

    public static<E extends Paquete> void cargarCamion1(Camion<E> camion, ArrayList<Paquete> paquetes, Paquete paquete) {

        if (paquete.getPeso() <= camion.getCapacidadCarga()) {
            System.out.println("Cargando paquete " + paquete.getCodigo() + " al camión " + camion.getPlaca());
            paquetes.add((E) paquete);
            camion.setCapacidadCarga(camion.getCapacidadCarga() - paquete.getPeso());
        } else {
            System.out.println("No se puede cargar el paquete " + paquete.getCodigo() + " al camión " + camion.getPlaca() + ". Peso excede la capacidad.");
        }

       
    }


    public static <T extends Paquete> T cargarCamion(Camion<T> camion, ArrayList<Paquete> paquetes) {

        for (Paquete paquete : paquetes) {
            if (paquete.getPeso() <= camion.getCapacidadCarga()) {
                System.out.println("Cargando paquete " + paquete.getCodigo() + " al camión " + camion.getPlaca());
                camion.setCapacidadCarga(camion.getCapacidadCarga() - paquete.getPeso());
            } else {
                System.out.println("No se puede cargar el paquete " + paquete.getCodigo() + " al camión " + camion.getPlaca() + ". Peso excede la capacidad.");
                
            }
        }
        return null;



       
    }


    public static <T extends Paquete> T descargarCamion(Camion<T> camion, ArrayList<Paquete> paquetes) {

        for (Paquete paquete : paquetes) {
            System.out.println("Descargando paquete " + paquete.getCodigo() + " del camión " + camion.getPlaca());
        }
        return null;

    }




}

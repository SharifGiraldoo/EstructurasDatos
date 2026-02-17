
import java.util.ArrayList;
import java.util.Iterator;

public class EliminarCadenas {

    public static void main(String[] args) throws Exception {

        ArrayList<String> e = new ArrayList<>();
        e.add("Juan");
        e.add("Raul");
        e.add("Jorge");
        e.add("Robinson");
        e.add("Julian");
        e.add("Rosa");
        System.out.println("---------------");
        System.out.println(e);
        System.out.println("---------------");
        eliminarCadenas(e);
        System.out.println("Arraylist con implementación del método eliminarCadenas: " + e);
        System.out.println("---------------");
        eliminarCadenasIterador(e);
        System.out.println("Arraylist con implementación del método eliminarCadenasIterador: " + e);
    }

    /**
     * Método que elimina los elementos(Cadenas de texto) cuya letra inicial sea
     * una R mayúscula
     *
     * @param e ArrayList de cadenas a eliminar los elementos que cumplan la condición de eliminación
     */
    public static void eliminarCadenas(ArrayList<String> e) {

        ArrayList<String> eliminados = new ArrayList<>();
        for (int i = 0; i < e.size(); i++) {

            if (e.get(i).charAt(0) == 'R') {

                eliminados.add(e.get(i));
            }
        }

        e.removeAll(eliminados);
    }


    /**
     * Método que elimina los elementos(Cadenas de texto) cuya letra inicial sea
     * una R mayúscula utilizando un iterador
     * @param e ArrayList de cadenas a eliminar los elementos que cumplan la condición de eliminación
     */
    public static void eliminarCadenasIterador(ArrayList<String> e) {

        Iterator<String> it = e.iterator();

        while (it.hasNext()) {

            String actual = it.next();

            if (!actual.isEmpty() && actual.charAt(0) == 'R') {
                it.remove();  
            }
        }
    }

}


import java.util.ArrayList;


public class Generics{


    public static void main(String[] args) {

        ArrayList<Object> lista = new ArrayList<>(); //Permite almacenar elementos de cualquier tipo, pero no proporciona seguridad de tipos

        ArrayList<String> lista2 = new ArrayList<>(); //Lanzaríia un error de compilación al intentar agregar elementos de diferentes tipos a la lista


        ArrayList<Integer> lista3 = new ArrayList<>(); //Lanzaría un error de compilación al intentar agregar elementos de diferentes tipos a la lista
        
        

        lista.add(3);
        lista.add("String");
        lista.add(new Persona("Juan"));


        for(Object object : lista){
            //int numetro = (int) object; //Lanzaría una excepción en tiempo de ejecución (ClassCastException) al intentar convertir un objeto que no es un entero a un entero

            if(object instanceof Integer){
                int numero = (int) object;
            //
        }
        
    }





}}
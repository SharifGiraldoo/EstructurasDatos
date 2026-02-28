
import java.util.ArrayList;
import java.util.ListIterator;


public class Collections2 {


    public static void main(String[] args) {
       
        ArrayList<String> lista = new ArrayList<>();

        lista.add("Juan");

        ListIterator<String> listIterator = lista.listIterator();
        listIterator.next();
        listIterator.previous();
        listIterator.hasPrevious();
        listIterator.remove();  
        //listIterator.next(); -> lanza excepción porque no hay más elementos y el límite desborda
        
        /**
         * hasNext() -> devuelve true si hay un elemento siguiente, false si no lo hay
         
        if(listIterator.hasNext()){
            listIterator.next();
        */


            //Recorre un iterador hacia adelante
            while(listIterator.hasNext()){
                String next = listIterator.next();
                System.out.println(next);
            }

            //Recorre un iterador hacia atrás
            while(listIterator.hasPrevious()){
                String previous = listIterator.previous();
                System.out.println(previous);
            }

    }
    
}

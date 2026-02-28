import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparable {

    public static void main(String[] args) {

        
        //Si fuera String lo ordena en orden alfabético (Por códigos ASCII)
        /*
         
        List<Integer> numeros = List<E>.of(2,3,4,7,5);
        Collections.sort(numeros);
        */


        List<Cliente> clientes = new ArrayList<>();

        Collections.sort(clientes, Collections.reverseOrder());

        Collections.sort(clientes, new Comparator<Cliente>() {
            @Override
            public int compare(Cliente o1, Cliente o2){
                return o1.getEdad() - o2.getEdad(); 
            }
        });



        //Función lambda
        clientes.sort((c1,c2)-> c1.getEdad() - c2.getEdad());

        //Aplicamos evaluación perezosa 
        clientes.sort(Comparator.comparing(Cliente::getEdad));


        //Si queremos hallar un cliente de nombre Juan 

        for(Cliente cliente: clientes){
            if(cliente.getNombre().equals("Juan")){
                System.out.println("ENCONTRADO");
            }
        }

        clientes.stream().filter((cliente)->cliente.getNombre().equals("Juan")).findFirst();
    }
}
    

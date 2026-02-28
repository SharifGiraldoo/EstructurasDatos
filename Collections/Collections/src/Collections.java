import java.util.ArrayList;

public class Collections {


    public static void main(String[] args) throws CloneNotSupportedException {

        Cliente cliente1 = new Cliente("Juan", "1094898051");

        cliente1.clone();



        
        Cliente cliente2 = cliente1;

        System.out.println(cliente1);
        System.out.println(cliente2);

        cliente1 = new Cliente("Juan", "1094898051");
        cliente1=null;

        ArrayList<String> lista = new ArrayList<>();
        lista.add("Robinson");
        
        
    }
   

    

    
    
}

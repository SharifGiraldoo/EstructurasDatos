
import java.util.Arrays;

public class ArrayList {

    private Object[] lista;
    private int index = 0; 


    public ArrayList(){
        this.lista = new Object[10];
    }

    public ArrayList(int size){
        this.lista = new Object[size];
    }

    public void add(int num){

        if(index == lista.length){
            Object[] arreglo = new Object[lista.length * 2];
            Arrays.copyOf(arreglo, lista.length);
            lista = arreglo;

        }
        
        lista[++index] = num; 
    }

}

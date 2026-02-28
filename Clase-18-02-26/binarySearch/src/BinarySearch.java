import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) throws Exception {
       
        int arreglo[] = {3,4,5,2,1,8};
        int pos = binarySearch(arreglo,1);
        System.out.println(pos);
    }

    private static int binarySearch(int[] arreglo, int search) {

        if(arreglo == null){
            return -1;
        }
        Arrays.sort(arreglo);
        return binarySearch(arreglo, search,0,arreglo.length-1); 
    }

    private static int binarySearch(int[] arreglo, int search, int first, int last) {
        if(first > last){
            return -1;
        }else{
            int middle = (first + last) / 2;

            if(arreglo[middle] == search){
                return middle;
            }else{
                if(arreglo[middle] > search){
                    return binarySearch(arreglo, search, first, middle-1);
            }else{
                return binarySearch(arreglo, search, middle+1, last);
            }

        }

    }


    
    }
}

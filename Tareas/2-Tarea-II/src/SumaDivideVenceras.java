public class SumaDivideVenceras {
    public static void main(String[] args) throws Exception {
        int[] array = {2,4,6,8,10};
        int resultado = sumarElementosArreglo(array, 0, array.length-1);
        System.out.println("La suma de los elementos del arreglo es: " + (resultado));

    }

    /**
     * Método que suma los elementos de un arreglo utilizando el principio de Divide y vencerás
     * @param array Arreglo de enteros a sumar
     * @param inicio Índice de inicio del arreglo a sumar
     * @param fin Índice de fin del arreglo a sumar
     * @return La suma de los elementos del arreglo entre los índices de inicio y fin
     */
    public static int sumarElementosArreglo(int[] array, int inicio, int fin){

        //Caso base(Cuando solo se tiene un elemento en el arreglo)
        //Si el inicio es igual al fin, en tecnicismo, elegimos cualquiera de los dos para retornar
        if(inicio == fin){
            return array[inicio];
        }

        //Dividimos aplicando el principio Divide y vencerás
        int medio = (inicio + fin)/2;

        //Se aplica recursividad volviendo a llamar al método sumarElementosArreglo
        int sumaIzq = sumarElementosArreglo(array, inicio, medio);
        int sumaDer = sumarElementosArreglo(array, medio + 1, fin);

        return sumaIzq + sumaDer;
    }
}

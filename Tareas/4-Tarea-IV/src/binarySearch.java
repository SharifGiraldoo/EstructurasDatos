public class binarySearch {


    public static void main(String[] args) {

    int[] datos = {4, 9, 15, 21, 34, 57, 68};

    int objetivo = 34;

    int posicion = busquedaBinaria(datos, objetivo);

    if (posicion != -1) {
        System.out.println("Elemento encontrado en índice: " + posicion);
    } else {
        System.out.println("Elemento no encontrado");
    }
}



    /**
     * Método que implementa el algoritmo de búsqueda binaria para encontrar la posición de un elemento en un arreglo ordenado
     * @param arreglo Arreglo de enteros ordenado en el que se realizará la búsqueda
     * @param objetivo Elemento que se desea encontrar en el arreglo
     * @return El índice del elemento objetivo en el arreglo si se encuentra, o -1 si no se encuentra
     */
    public static int busquedaBinaria(int[] arreglo, int objetivo) {

    int izquierda = 0;
    int derecha = arreglo.length - 1;

    while (izquierda <= derecha) {

        int medio = (izquierda + derecha) / 2;

        if (arreglo[medio] == objetivo) {
            return medio;
        }

        if (objetivo < arreglo[medio]) {
            derecha = medio - 1;
        } else {
            izquierda = medio + 1;
        }
    }

    return -1; 
}

}



/**
 * Clase principal del programa
 * @author Sharif Giraldo Obando
 * Fecha: 4 de Febrero de 2025
 * @version 1.0
 * Licencia: GNU GPL v3
 */


public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("--- INICIANDO TERMINAL ---");
        System.out.println("¿El número es triangular?: " +  buscarNumeroTriangular(20));
        imprimirPrimos();
        System.out.println("--- FINALIZADO ---");

        
    }


    /**
     * Método que define si un número n ingresado es triangular
     * @param n Número a evaluar
     * @return "YES" si es triangular, "NO" si no lo es
     */
    public static String buscarNumeroTriangular(int n){

        if(n<0){
            return "NO";
        }

        int suma = 0;
        int contador = 0;

        while(suma < n){
            suma += contador; 
            contador ++;
        }

        if(suma == n){
            return "YES";
        }else{
            return "NO";
        }
    }

    /**
     * Método que imprime los primeros 5 números primos
     * @return void
     */
    public static void imprimirPrimos(){
        System.out.println("1,2,3,5,7"); 
    }
}

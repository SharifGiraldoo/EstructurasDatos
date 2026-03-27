package co.edu.uniquindio.listaenlazada;

public class App {
    public static void main(String[] args) {

        ListaEnlazada<Integer> lista = new ListaEnlazada<>();

        lista.insertarEnPosicion(10, 0);
        lista.insertarEnPosicion(20, 1);
        lista.insertarEnPosicion(15, 2);
        lista.insertarEnPosicion(5, 0);

        lista.imprimir();

        lista.removerPorIndice(1);

        lista.imprimir();
    }
}

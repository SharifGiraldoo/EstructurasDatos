package co.edu.uniquindio.listaenlazada;

public class ListaEnlazada<T> {

    private Nodo<T> head;
    private int size;

    public ListaEnlazada() {
        head = null;
        size = 0;
    }


    public void insertarEnPosicion(T dato, int pos) {

        
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("Posición fuera de rango");
        }

        Nodo<T> nuevo = new Nodo<>(dato);

        
        if (pos == 0) {
            nuevo.siguiente = head;
            head = nuevo;
        } else {
            Nodo<T> actual = head;

            
            for (int i = 0; i < pos - 1; i++) {
                actual = actual.siguiente;
            }

           
            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
        }

        size++;
    }


    public void removerPorIndice(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Posición fuera de rango");
        }

        if (pos == 0) {
            head = head.siguiente;
        } else {
            Nodo<T> actual = head;

            for (int i = 0; i < pos - 1; i++) {
                actual = actual.siguiente;
            }

            actual.siguiente = actual.siguiente.siguiente;
        }

        size--;
    }

   
    public void imprimir() {
        Nodo<T> actual = head;

        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }

        System.out.println("null");
    }

    
    public int size() {
        return size;
    }
}

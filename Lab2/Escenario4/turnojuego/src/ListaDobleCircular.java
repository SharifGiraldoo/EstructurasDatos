
public class ListaDobleCircular<T> {

    private NodoDoble<T> nodoPrimero;
    private NodoDoble<T> nodoUltimo;
    private int tamanio;

    public ListaDobleCircular() {
        nodoPrimero = null;
        nodoUltimo = null;
        tamanio = 0;
    }


    /**
     * Agrega un nuevo nodo al final de la lista. Si la lista está vacía, 
     * el nuevo nodo se convierte en el primero y el último, apuntando a sí mismo para mantener la circularidad. 
     * Si la lista no está vacía, el nuevo nodo se enlaza al final y se actualizan los punteros del último nodo y 
     * del nuevo nodo para mantener la estructura circular.
     * @param valorNodo
     * @throws ListaException si el valor del nodo es nulo, ya que no se permiten valores nulos en la lista.
     */
    public void agregarFinal(T valorNodo) {

        if (valorNodo == null) {
            throw new ListaException("No se permiten valores nulos");
        }

        NodoDoble<T> nuevoNodo = new NodoDoble<>(valorNodo);

        if (estaVacia()) {
            nodoPrimero = nodoUltimo = nuevoNodo;
            nodoPrimero.setSiguienteNodo(nodoPrimero);
            nodoPrimero.setAnteriorNodo(nodoPrimero);
        } else {

            nuevoNodo.setSiguienteNodo(nodoPrimero);
            nuevoNodo.setAnteriorNodo(nodoUltimo);

            nodoUltimo.setSiguienteNodo(nuevoNodo);
            nodoPrimero.setAnteriorNodo(nuevoNodo);

            nodoUltimo = nuevoNodo;
        }

        tamanio++;
    }

    
    /**
     * Inserta un nuevo nodo en una posición específica de la lista. Si la posición es 0, el nuevo nodo se convierte en el primero.
     * Si la posición es igual al tamaño de la lista, el nuevo nodo se agrega al final. Para posiciones intermedias, el nuevo nodo se inserta 
     * entre los nodos existentes, y se actualizan los punteros de los nodos adyacentes para mantener la estructura circular. 
     * Se lanzan excepciones si el valor del nodo es nulo o si 
     * la posición está fuera de rango.
     * @param valor
     * @param posicion
     * @throws ListaException si el valor es nulo o si la posición es inválida (menor que 0 o mayor que el tamaño de la lista).
     */
    public void insertar(T valor, int posicion) {

        if (valor == null) {
            throw new ListaException("El valor no puede ser null");
        }

        if (posicion < 0 || posicion > tamanio) {
            throw new ListaException("Posición fuera de rango");
        }

        NodoDoble<T> nuevo = new NodoDoble<>(valor);

        if (estaVacia()) {
            nodoPrimero = nodoUltimo = nuevo;
            nodoPrimero.setSiguienteNodo(nodoPrimero);
            nodoPrimero.setAnteriorNodo(nodoPrimero);
        } else if (posicion == 0) {

            nuevo.setSiguienteNodo(nodoPrimero);
            nuevo.setAnteriorNodo(nodoUltimo);

            nodoPrimero.setAnteriorNodo(nuevo);
            nodoUltimo.setSiguienteNodo(nuevo);

            nodoPrimero = nuevo;

        } else if (posicion == tamanio) {

            agregarFinal(valor);
            return;

        } else {

            NodoDoble<T> aux = nodoPrimero;

            for (int i = 0; i < posicion; i++) {
                aux = aux.getSiguienteNodo();
            }

            NodoDoble<T> anterior = aux.getAnteriorNodo();

            anterior.setSiguienteNodo(nuevo);
            nuevo.setAnteriorNodo(anterior);

            nuevo.setSiguienteNodo(aux);
            aux.setAnteriorNodo(nuevo);
        }

        tamanio++;
    }



    /**
     * Método para buscar un valor específico en la lista. Recorre la lista desde el nodo primero, comparando el valor de cada nodo con el valor buscado.
     * Si encuentra el valor, devuelve su posición (índice) en la lista. Si no encuentra el valor después de recorrer toda la lista, devuelve -1. 
     * Si la lista está vacía, lanza una excepción indicando que no se puede buscar en una lista vacía.
     * @param valor el valor a buscar en la lista
     * @return la posición del valor en la lista, o -1 si no se encuentra
     * @throws ListaException si la lista está vacía, indicando que no se puede realizar la búsqueda en una lista sin elementos.
     */
    public int buscar(T valor) {

        if (estaVacia()) {
            throw new ListaException("No se puede buscar en una lista vacía");
        }

        NodoDoble<T> aux = nodoPrimero;

        for (int i = 0; i < tamanio; i++) {
            if (aux.getValorNodo().equals(valor)) {
                return i;
            }
            aux = aux.getSiguienteNodo();
        }

        return -1;
    }

  
    /**
     * Elimina un nodo que contiene un valor específico de la lista. Recorre la lista para encontrar el nodo con el valor dado. 
     * Si encuentra el nodo, lo elimina ajustando los punteros de los nodos adyacentes para mantener la estructura circular.
     *  Si el nodo a eliminar es el primero o el último, se actualizan los punteros correspondientes. Si la lista tiene solo un nodo, 
     * se vacía la lista. Si no encuentra el valor después de recorrer toda la lista, lanza una excepción indicando que el elemento no existe en la lista. T
     * ambién lanza una excepción si se intenta eliminar de una lista vacía.
     * @param valor
     * @return
     * @throws ListaException si la lista está vacía o si el elemento a eliminar no se encuentra en la lista.
     */
    public boolean eliminar(T valor) {

        if (estaVacia()) {
            throw new ListaException("No se puede eliminar en lista vacía");
        }

        NodoDoble<T> aux = nodoPrimero;

        for (int i = 0; i < tamanio; i++) {

            if (aux.getValorNodo().equals(valor)) {

                if (tamanio == 1) {
                    nodoPrimero = nodoUltimo = null;
                } else {

                    NodoDoble<T> anterior = aux.getAnteriorNodo();
                    NodoDoble<T> siguiente = aux.getSiguienteNodo();

                    anterior.setSiguienteNodo(siguiente);
                    siguiente.setAnteriorNodo(anterior);

                    if (aux == nodoPrimero) {
                        nodoPrimero = siguiente;
                    }

                    if (aux == nodoUltimo) {
                        nodoUltimo = anterior;
                    }
                }

                tamanio--;
                return true;
            }

            aux = aux.getSiguienteNodo();
        }

        throw new ListaException("El elemento no existe en la lista");
    }

    
    /**
     * Avanza el turno al siguiente nodo en la lista. Si la lista está vacía, lanza una excepción indicando que no hay jugadores en la lista.
     * Si la lista no está vacía, actualiza el nodo primero y el nodo último para apuntar al siguiente nodo en la secuencia circular, 
     * lo que efectivamente avanza el turno al siguiente jugador.
     * @throws ListaException si la lista está vacía, indicando que no hay jugadores en la lista y por lo tanto no se puede avanzar el turno.
     */
    public void siguienteTurno() {

        if (estaVacia()) {
            throw new ListaException("No hay jugadores en la lista");
        }

        nodoPrimero = nodoPrimero.getSiguienteNodo();
        nodoUltimo = nodoUltimo.getSiguienteNodo();
    }

    
    /**
     * Retrocede el turno al nodo anterior en la lista. Si la lista está vacía, lanza una excepción indicando que no hay jugadores en la lista.
     * Si la lista no está vacía, actualiza el nodo primero y el nodo último para apuntar al nodo anterior en la secuencia circular, lo que retrocede 
     * el turno al jugador anterior.
     * @throws ListaException si la lista está vacía, indicando que no hay jugadores en la lista y por lo tanto no se puede retroceder el turno.
     */
    public void turnoAnterior() {

        if (estaVacia()) {
            throw new ListaException("No hay jugadores en la lista");
        }

        nodoPrimero = nodoPrimero.getAnteriorNodo();
        nodoUltimo = nodoUltimo.getAnteriorNodo();
    }


    /**
     * Obtiene el valor del nodo actual (nodo primero) en la lista. Si la lista está vacía, lanza una excepción indicando que no hay jugadores en la lista.
     * Si la lista no está vacía, devuelve el valor del nodo primero, que representa el jugador o elemento actual en la secuencia circular.
     * @param <T>
     * @return el valor del nodo actual (nodo primero) en la lista
     * @throws ListaException si la lista está vacía, indicando que no hay jugadores en la lista y por lo tanto no se puede obtener un valor actual.
     */
    public T getActual() {

        if (estaVacia()) {
            throw new ListaException("No hay jugadores en la lista");
        }

        return nodoPrimero.getValorNodo();
    }

    /**
     * Imprime los elementos de la lista en orden, comenzando desde el nodo primero y siguiendo la secuencia circular. 
     * Si la lista está vacía, lanza una excepción indicando que no se pueden imprimir elementos de una lista vacía.
     * Si la lista no está vacía, recorre la lista desde el nodo primero, imprimiendo el valor de cada nodo seguido de una flecha para indicar la conexión entre los nodos.
     * Al finalizar el recorrido, imprime "(circular)" para indicar que la lista es circular.
     * @return una representación visual de los elementos en la lista, mostrando la conexión circular entre ellos.
     * @throws ListaException si la lista está vacía, indicando que no se pueden imprimir
     */
    public void imprimirLista() {

        if (estaVacia()) {
            throw new ListaException("Lista vacía");
        }

        NodoDoble<T> aux = nodoPrimero;

        for (int i = 0; i < tamanio; i++) {
            System.out.print(aux.getValorNodo() + " <-> ");
            aux = aux.getSiguienteNodo();
        }

        System.out.println("(circular)");
    }

    
    /**
     * Verifica si la lista está vacía. Devuelve true si el nodo primero es null, lo que indica que no hay elementos en la lista, y false en caso contrario.
     * @return true si la lista está vacía, false si contiene elementos.
     */
    public boolean estaVacia() {
        return nodoPrimero == null;
    }

    /**
     * Devuelve el número de elementos en la lista, representado por la variable tamanio, que se actualiza cada vez que se agregan o eliminan nodos de la lista.
     * @return el número de elementos en la lista.
     */
    public int size() {
        return tamanio;
    }
}
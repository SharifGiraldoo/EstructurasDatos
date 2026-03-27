
public class NodoDoble<T> {

    private final T valorNodo;
    private NodoDoble<T> siguienteNodo;
    private NodoDoble<T> anteriorNodo;

    public NodoDoble(T valorNodo) {
        this.valorNodo = valorNodo;
        this.siguienteNodo = null;
        this.anteriorNodo = null;
    }

    public T getValorNodo() {
        return valorNodo;
    }

    public NodoDoble<T> getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(NodoDoble<T> siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }

    public NodoDoble<T> getAnteriorNodo() {
        return anteriorNodo;
    }

    public void setAnteriorNodo(NodoDoble<T> anteriorNodo) {
        this.anteriorNodo = anteriorNodo;
    }
}
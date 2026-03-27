

public class Main {

    public static void main(String[] args) {

        ListaDobleCircular<String> lista = new ListaDobleCircular<>();

        try {

            lista.agregarFinal("Sharif");
            lista.agregarFinal("Juanse");
            lista.agregarFinal("Sntop07");

            lista.imprimirLista();

            lista.siguienteTurno();
            System.out.println("Turno: " + lista.getActual());

            lista.eliminar("Juannse");
            lista.imprimirLista();

        } catch (ListaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
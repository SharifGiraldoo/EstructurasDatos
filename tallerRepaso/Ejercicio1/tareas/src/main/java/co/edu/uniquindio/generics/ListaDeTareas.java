package co.edu.uniquindio.generics;

import java.util.Comparator;
import java.util.LinkedList;

public class ListaDeTareas<T extends Tarea<?>> {

    private final LinkedList<T> listaTareas;

    public ListaDeTareas() {
        this.listaTareas = new LinkedList<>();
    }

    public static <T extends Tarea<?>> void agregarTareas(ListaDeTareas<T> listaTareas, T tarea) {
        listaTareas.listaTareas.add(tarea);
    }

    public static <T extends Tarea<?>> void obtenerTareas(ListaDeTareas<T> listaTareas, int prioridad) throws IllegalArgumentException {

        LinkedList<T> tareasPrioridad = new LinkedList<>();

        for (T t : listaTareas.listaTareas) {
            if (listaTareas.listaTareas.isEmpty()) {
                throw new IllegalArgumentException("La lista de tareas está vacía");
            } else {

                if (t.getPrioridad() == prioridad) {
                    tareasPrioridad.add(t);

                    System.out.println("\nTareas con prioridad " + prioridad + ": " + tareasPrioridad.toString());
                }
            }

        }

    }

    public static <T extends Tarea<T>> LinkedList<T> tareasOrdenadasFechaVencimiento(ListaDeTareas<T> listaTareas)
            throws IllegalArgumentException {

        if (listaTareas == null) {
            throw new IllegalArgumentException("La lista de tareas no puede ser nula");
        }

        LinkedList<T> tareasOrdenadasPorVencimiento = new LinkedList<>();

        for (T t : tareasOrdenadasPorVencimiento) {
            if (t.getFechaVencimiento() == null) {
                throw new IllegalArgumentException("Ninguna tarea puede tener fecha de vencimiento nula");
            }
        }

        tareasOrdenadasPorVencimiento.sort(Comparator.comparing(Tarea::getFechaVencimiento));
        System.out.println("\nTareas ordenadas por fecha de vencimiento: " + tareasOrdenadasPorVencimiento);;
        return tareasOrdenadasPorVencimiento;

    }

}

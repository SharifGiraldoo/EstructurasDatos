package co.edu.uniquindio.generics;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Tarea<?> tarea1 = new Tarea<>("Tarea 1",LocalDate.of(2024, 6, 30), 4);
        Tarea<?> tarea2 = new Tarea<>("Tarea 2",LocalDate.of(2024, 7, 15), 2);
        Tarea<?> tarea3 = new Tarea<>("Tarea 3",LocalDate.of(2024, 8, 1), 5);
        Tarea<?> tarea4 = new Tarea<>("Tarea 4",LocalDate.of(2024, 6, 25), 3);

        ListaDeTareas<Tarea<?>> listaTareas = new ListaDeTareas<>();
        ListaDeTareas.agregarTareas(listaTareas, tarea1);
        ListaDeTareas.agregarTareas(listaTareas, tarea2);
        ListaDeTareas.agregarTareas(listaTareas, tarea3);
        ListaDeTareas.agregarTareas(listaTareas, tarea4);

        try {
            ListaDeTareas.obtenerTareas(listaTareas, 3);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


        
}

}

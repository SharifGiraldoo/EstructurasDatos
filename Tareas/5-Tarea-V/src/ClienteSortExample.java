
import java.util.Collections;
import java.util.Comparator;

import java.util.ArrayList;

public class ClienteSortExample {

    public static void main(String[] args) {

        ArrayList<Cliente> lista = new ArrayList<>();

        lista.add(new Cliente("Ana", 30));
        lista.add(new Cliente("Luis", 25));
        lista.add(new Cliente("Carlos", 40));
        lista.add(new Cliente("Maria", 28));

        System.out.println("Lista original:");
        for (Cliente c : lista) {
            System.out.println(c);
        }

        // Orden menor a mayor (usa Comparable)
        Collections.sort(lista);

        System.out.println("\nOrden menor a mayor (edad):");
        for (Cliente c : lista) {
            System.out.println(c);
        }

        // Orden mayor a menor (usa Comparator)
        Collections.sort(lista, new Comparator<Cliente>() {
            @Override
            public int compare(Cliente c1, Cliente c2) {
                return c2.getEdad() - c1.getEdad();
            }
        });

        System.out.println("\nOrden mayor a menor (edad):");
        for (Cliente c : lista) {
            System.out.println(c);
        }
    }
} 

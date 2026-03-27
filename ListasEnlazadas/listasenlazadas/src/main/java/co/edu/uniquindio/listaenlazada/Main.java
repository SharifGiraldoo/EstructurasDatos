package co.edu.uniquindio.listaenlazada;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        LinkedSimpleList list = new LinkedSimpleList();

        System.out.println("=== PRUEBA DE LISTA ENLAZADA ===");

        // 1. agregarInicio
        list.addFirst(10);
        list.addFirst(5);

        // 2. agregarFinal
        list.addLast(20);
        list.addLast(30);

        System.out.println("\nLista inicial:");
        list.printList();

        // 3. agregar en posición específica
        list.addAtPosition(15, 2);
        System.out.println("\nDespués de insertar 15 en posición 2:");
        list.printList();

        // 4. obtenerValorNodo
        System.out.println("\nValor en índice 2: " + list.getNodeValue(2));

        // 5. obtenerNodo
        System.out.println("Nodo en índice 3: " + list.getNode(3));

        // 6. obtenerPosicionNodo
        System.out.println("Posición del valor 20: " + list.getNodePosition(20));

        // 7. indiceValido
        System.out.println("¿Índice 4 válido?: " + list.isValidIndex(4));
        System.out.println("¿Índice 10 válido?: " + list.isValidIndex(10));

        // 8. estaVacia
        System.out.println("¿Lista vacía?: " + list.isEmpty());

        // 9. eliminarPrimero
        list.removeFirst();
        System.out.println("\nDespués de eliminar primero:");
        list.printList();

        // 10. eliminarUltimo
        list.removeLast();
        System.out.println("\nDespués de eliminar último:");
        list.printList();

        // 11. eliminar por valor
        list.removeByValue(15);
        System.out.println("\nDespués de eliminar valor 15:");
        list.printList();

        // 12. modificarNodo
        list.modifyNode(1, 99);
        System.out.println("\nDespués de modificar índice 1 a 99:");
        list.printList();

        // 13. ordenarLista
        list.addLast(3);
        list.addLast(50);
        list.addLast(1);

        System.out.println("\nAntes de ordenar:");
        list.printList();

        list.sortList();

        System.out.println("\nDespués de ordenar:");
        list.printList();

        // 14. imprimirLista (ya usado varias veces)

        // 15. Iterator (recorrido)
        System.out.println("\nRecorrido con Iterator:");
        Iterator<Integer> it = list.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }

        // remove() del iterator
        System.out.println("\nEliminando con iterator (primer elemento):");
        Iterator<Integer> it2 = list.iterator();
        if(it2.hasNext()){
            it2.next();
            it2.remove();
        }

        list.printList();

        // 16. borrarLista
        list.clearList();
        System.out.println("\nDespués de borrar lista:");
        list.printList();

        System.out.println("¿Lista vacía?: " + list.isEmpty());


        
    }
}
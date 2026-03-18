package co.edu.uniquindio.listaenlazada;

public class Main {
    public static void main(String[] args) {
        LinkedSimpleList list1 = new LinkedSimpleList();
        list1.addFirst(6);
        list1.addFirst(4);
        list1.addFirst(5);

        list1.addLast(2);
        list1.removeFirst();

        list1.removeByIndex(3);

        list1.printList();


    }
}
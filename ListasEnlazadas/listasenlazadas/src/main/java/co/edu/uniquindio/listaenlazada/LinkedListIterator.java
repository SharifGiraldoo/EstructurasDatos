package co.edu.uniquindio.listaenlazada;

import java.util.Iterator;

public class LinkedListIterator implements Iterator<Integer> {

    private Node current;
    private Node previous;
    private LinkedSimpleList list;

    public LinkedListIterator(LinkedSimpleList list) {
        this.list = list;

        if (list == null) {
            throw new RuntimeException("La lista no puede ser null");
        }

        this.current = list.getFirstNode();
        this.previous = null;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Integer next() {
        int data = current.getData();
        previous = current;
        current = current.getNext();
        return data;
    }

    @Override
    public void remove() {
        if (previous == null) {
            throw new IllegalStateException("Debe llamar a next() antes de remove()");
        }

        list.removeByValue(previous.getData());
        previous = null;
    }
}

package co.edu.uniquindio.listaenlazada;

import java.util.Iterator;

public class LinkedSimpleList implements Iterable<Integer> {

    private Node firstNode;
    int size;

    public LinkedSimpleList() {
        this.firstNode = null;
        size = 0;
    }

    public Node getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(Node firstNode) {
        this.firstNode = firstNode;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data, null);

        if (isEmpty()) {
            firstNode = newNode;
        } else {
            newNode.setNext(firstNode);
            firstNode = newNode;
        }

        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data, null);

        if (isEmpty()) {
            firstNode = newNode;
        } else {
            Node current = firstNode;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }

        size++;
    }

    public void removeFirst() throws RuntimeException {
        if (!isEmpty()) {
            Node next = firstNode.getNext();
            firstNode.setNext(null);
            firstNode = next;
            size--;
        } else {
            throw new RuntimeException("La lista está vacía");
        }
    }

    public void printList() {

        Node aux = firstNode;
        if (aux == null) {
            System.out.println("List is empty");
        } else {
            while (aux != null) {
                System.out.println(aux.toString());
                aux = aux.getNext();
            }
        }
    }

    public void removeLast() throws RuntimeException {

        if (!isEmpty()) {
            if (size == 1) {
                firstNode = null;
            } else {
                Node current = firstNode;
                while (current.getNext().getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(null);
            }
            size--;
        } else {
            throw new RuntimeException("La lista está vacía");
        }
    }

    public void removeByIndex(int index) throws RuntimeException {

        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        } else {
            if (index == 0) {
                removeFirst();
            } else if (index == size - 1) {
                removeLast();
            } else if (index > 0 && index < size - 1) {
                Node current = firstNode;
                for (int i = 0; i < index - 1; i++) {
                    current = current.getNext();
                }
                Node toRemove = current.getNext();
                current.setNext(toRemove.getNext());
                toRemove.setNext(null);
                size--;
            }
        }
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public void addAtPosition(int data, int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("Índice inválido");
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size) {
            addLast(data);
            return;
        }

        Node newNode = new Node(data, null);
        Node current = firstNode;

        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }

        newNode.setNext(current.getNext());
        current.setNext(newNode);
        size++;
    }

    public int getNodeValue(int index) {
        return getNode(index).getData();
    }

    public Node getNode(int index) {
        if (!isValidIndex(index)) {
            throw new RuntimeException("Índice inválido");
        }

        Node current = firstNode;

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current;
    }

    public int getNodePosition(int data) {
        Node current = firstNode;
        int index = 0;

        while (current != null) {
            if (current.getData() == data) {
                return index;
            }
            current = current.getNext();
            index++;
        }

        return -1; // No encontrado
    }

    public boolean isValidIndex(int index) {
        return index >= 0 && index < size;
    }

    public void removeByValue(int data) {
        if (isEmpty()) {
            throw new RuntimeException("Lista vacía");
        }

        if (firstNode.getData() == data) {
            removeFirst();
            return;
        }

        Node current = firstNode;

        while (current.getNext() != null && current.getNext().getData() != data) {
            current = current.getNext();
        }

        if (current.getNext() != null) {
            Node toRemove = current.getNext();
            current.setNext(toRemove.getNext());
            toRemove.setNext(null);
            size--;
        } else {
            throw new RuntimeException("Elemento no encontrado");
        }
    }

    public void modifyNode(int index, int newData) {
        Node node = getNode(index);
        node.setData(newData);
    }

    public void sortList() {
        if (size < 2) {
            return;
        }

        boolean swapped;

        do {
            swapped = false;
            Node current = firstNode;

            while (current.getNext() != null) {
                if (current.getData() > current.getNext().getData()) {
                    int temp = current.getData();
                    current.setData(current.getNext().getData());
                    current.getNext().setData(temp);
                    swapped = true;
                }
                current = current.getNext();
            }

        } while (swapped);
    }

    public void clearList() {
        firstNode = null;
        size = 0;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new LinkedListIterator(this); 
    }


            

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedSimpleList{");
        sb.append("firstNode=").append(firstNode);
        sb.append(", size=").append(size);
        sb.append('}');
        return sb.toString();
    }

}

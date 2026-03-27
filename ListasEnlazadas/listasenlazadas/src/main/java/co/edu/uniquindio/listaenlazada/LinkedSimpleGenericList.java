package co.edu.uniquindio.listaenlazada;

public class LinkedSimpleGenericList {

    private Node firstNode;
    int size;

    public LinkedSimpleGenericList() {
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


    

}

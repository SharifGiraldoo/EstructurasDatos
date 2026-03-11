package co.edu.uniquindio.listaenlazada;

public class LinkedSimpleList {
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



    public void addFirst(int data){
        Node newNode = new Node(data,  null);

        if(isEmpty()){
            firstNode = newNode;
        }else{
            newNode.setNext(firstNode);
            firstNode = newNode;
        }

        size++;
    }


    public void addLast(int data){
        Node newNode = new Node(data,  null);

        if(isEmpty()){
            firstNode = newNode;
        }else{
            Node current = firstNode;
            while(current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(newNode);
        }

        size++;
    }


    public void removeFirst() throws RuntimeException {
        if(!isEmpty()){
            Node next = firstNode.getNext();
            firstNode.setNext(null);
            firstNode = next;
            size--;
        }else{
            throw new RuntimeException("La lista está vacía");
        }
    }



    public void printList(){

        Node aux = firstNode;
        if(aux == null){
            System.out.println("List is empty");
        }else{
            while(aux != null){
                System.out.println(aux.toString());
                aux = aux.getNext();
            }
        }
    }



    public void removeLast() throws RuntimeException{

        if(!isEmpty()){
            if(size == 1){
                firstNode = null;
            }else{
                Node current = firstNode;
                while(current.getNext().getNext() != null){
                    current = current.getNext();
                }
                current.setNext(null);
            }
            size--;
        }else{
            throw new RuntimeException("La lista está vacía");
        }
    }


    public void removeByIndex(int index) throws RuntimeException{

        if(isEmpty()){
            throw new RuntimeException("Empty list");
        }else{
            if(index == 0){
                removeFirst();
            }else if(index == size - 1){
                removeLast();
            }else if(index > 0 && index < size - 1){
                Node current = firstNode;
                for(int i = 0; i < index - 1; i++){
                    current = current.getNext();
                }
                Node toRemove = current.getNext();
                current.setNext(toRemove.getNext());
                toRemove.setNext(null);
                size--;
            }
        }
    }






    private boolean isEmpty() {
        return firstNode == null;
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

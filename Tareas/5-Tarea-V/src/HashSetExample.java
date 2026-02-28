import java.util.Iterator;
import java.util.LinkedList;

public class HashSetExample {

    public static void main(String[] args) {

        MyHashSet<String> set = new MyHashSet<>(8);

        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");
        set.add("A"); // duplicado

        System.out.println("Content" + set);
        System.out.println("Size: " + set.size());
        System.out.println("Contains B: " + set.contains("B"));

        set.remove("B");
        System.out.println("After Deleting B: " + set);

        set.clear();
        System.out.println("After clear(): " + set);
    }

    
    static class MyHashSet<T> {

        private LinkedList<T>[] table;
        private int capacity;
        private int size;
        private final double LOAD_FACTOR = 0.75;

        @SuppressWarnings("unchecked")
        public MyHashSet(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            table = new LinkedList[capacity];

            for (int i = 0; i < capacity; i++) {
                table[i] = new LinkedList<>();
            }
        }

        private int hash(T element) {
            return Math.abs(element.hashCode()) % capacity;
        }

        public boolean add(T element) {

            if ((double) size / capacity >= LOAD_FACTOR) {
                rehash();
            }

            int index = hash(element);
            LinkedList<T> bucket = table[index];

            for (T e : bucket) {
                if (e.equals(element)) {
                    return false;
                }
            }

            bucket.add(element);
            size++;
            return true;
        }

        public boolean contains(T element) {

            int index = hash(element);
            LinkedList<T> bucket = table[index];

            for (T e : bucket) {
                if (e.equals(element)) {
                    return true;
                }
            }

            return false;
        }

        public boolean remove(T element) {

            int index = hash(element);
            LinkedList<T> bucket = table[index];

            Iterator<T> iterator = bucket.iterator();

            while (iterator.hasNext()) {
                T e = iterator.next();
                if (e.equals(element)) {
                    iterator.remove();
                    size--;
                    return true;
                }
            }

            return false;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void clear() {
            for (int i = 0; i < capacity; i++) {
                table[i].clear();
            }
            size = 0;
        }

        private void rehash() {

            LinkedList<T>[] oldTable = table;
            capacity = capacity * 2;

            table = new LinkedList[capacity];

            for (int i = 0; i < capacity; i++) {
                table[i] = new LinkedList<>();
            }

            size = 0;

            for (LinkedList<T> bucket : oldTable) {
                for (T element : bucket) {
                    add(element);
                }
            }
        }

        @Override
        public String toString() {

            StringBuilder sb = new StringBuilder();
            sb.append("{ ");

            for (LinkedList<T> bucket : table) {
                for (T element : bucket) {
                    sb.append(element).append(" ");
                }
            }

            sb.append("}");
            return sb.toString();
        }
    }
}
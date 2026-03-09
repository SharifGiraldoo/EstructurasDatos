package co.edu.uniquindio.generics;

import java.util.ArrayList;
import java.util.List;

public class PairList<K, V> {

    private final List<Pair<K, V>> pairs;

    public PairList() {
        pairs = new ArrayList<>();
    }

    public void add(K key, V value) {
        pairs.add(new Pair<>(key, value));
    }

    public void remove(K key) {

        for (int i = 0; i < pairs.size(); i++) {

            if (pairs.get(i).getKey().equals(key)) {
                pairs.remove(i);
                return;
            }

        }

    }

    public V get(K key) {

        for (Pair<K, V> pair : pairs) {

            if (pair.getKey().equals(key)) {
                return pair.getValue();
            }

        }

        return null;
    }

    public int size() {
        return pairs.size();
    }

}

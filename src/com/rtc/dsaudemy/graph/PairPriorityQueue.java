package com.rtc.dsaudemy.graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PairPriorityQueue<K, V extends Comparable<V>> extends PriorityQueue<PairPriorityQueue.Pair<K, V>> {

    private Map<K, Pair<K, V>> pairMap = new HashMap<>();

    public PairPriorityQueue() {
        super(Comparator.comparing(Pair::getValue));
    }

    public PairPriorityQueue(int numNodes) {
        super(2 * numNodes, Comparator.comparing(Pair::getValue));
    }

    @Override
    public boolean offer(Pair<K, V> pair) {
        if (pairMap.containsKey(pair.getKey())) {
            Pair<K, V> existingPair = pairMap.get(pair.getKey());
            if (pair.getValue().compareTo(existingPair.getValue()) < 0) {
                super.remove(existingPair);
                super.offer(pair);
                pairMap.put(pair.getKey(), pair);
                return true;
            }
            return false;
        } else {
            super.offer(pair);
            pairMap.put(pair.getKey(), pair);
            return true;
        }
    }

    public static class Pair<K, V extends Comparable<V>> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }
    }
}

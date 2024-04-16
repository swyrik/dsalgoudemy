package com.rtc.dsaudemy.graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class IndexedPairPriorityQueue<K, V extends Comparable<V>> extends PriorityQueue<Pair<K,V>> {

    private Map<K, Pair<K,V>> pairMap = new HashMap<>();

    public IndexedPairPriorityQueue() {
        super(Comparator.comparing(Pair::getValue));
    }

    public IndexedPairPriorityQueue(int numNodes) {
        super(numNodes, Comparator.comparing(Pair::getValue));
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

}

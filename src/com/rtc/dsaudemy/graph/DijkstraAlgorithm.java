package com.rtc.dsaudemy.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    public static void main(String[] args) {
        Map<String, List<Edge<String>>> graph = new HashMap<>();
        GraphUtil.addDirectedEdge(graph, "A", "B", 4);
        GraphUtil.addDirectedEdge(graph, "A", "C", 1);
        GraphUtil.addDirectedEdge(graph, "C", "B", 2);
        GraphUtil.addDirectedEdge(graph, "C", "D", 5);
        GraphUtil.addDirectedEdge(graph, "B", "D", 1);
        GraphUtil.addDirectedEdge(graph, "D", "E", 3);

        Map<String, Integer> dijkstraDistance = dijkstra(graph, 5, "A");
        System.out.println(dijkstraDistance);

    }

    public static Map<String, Integer> dijkstra(Map<String, List<Edge<String>>> graph, int numNodes, String start){

        //visited nodes map
        Map<String, Boolean> visited = new HashMap<>();
        // distance node map
        Map<String, Integer> distance = new HashMap<>();
        distance.put(start, 0);
        //priority queue to get the least cost node
        PriorityQueue<Pair> pq = new PriorityQueue<>(2 * numNodes, (p1, p2) -> p1.getValue().compareTo(p2.getValue()));
        pq.offer(new Pair(start, 0));

        while (pq.size() != 0){
            Pair node = pq.poll();
            visited.put(node.getKey(), true);
            List<Edge<String>> edges = graph.get(node.getKey());
            // We already found a better path before we got to
            // processing this node so we can ignore it.
            if(distance.get(node.getKey()) < node.getValue()) continue;
            System.out.println(node);
            if(edges != null)
                for(Edge<String> edge : edges){
                    if(!visited.containsKey(edge.to)) {
                        int newDistance = distance.get(node.getKey()) + edge.cost;
                        Integer valuePresent = distance.putIfAbsent(edge.to, newDistance);
                        if(valuePresent != null){
                            distance.put(edge.to, Math.min(newDistance, valuePresent));
                        }
                        pq.offer(new Pair(edge.to , distance.get(edge.to)));
                    }
                }

        }

        return distance;
    }

    static class Pair {
        String key;
        int value;

        Pair(String key, int value){
            this.key = key;
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public String getKey() {
            return key;
        }

        @Override
        public String toString() {
            return "Pair=> key: " + this.key + " value: " + this.value;
        }
    }
}

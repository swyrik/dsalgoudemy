package com.rtc.dsaudemy.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFordAlgorithm {

    public static void main(String[] args) {
//        Map<String, List<<String>>> graph = new HashMap<>();
//        GraphUtil.addDirectedEdge(graph, "A", "B", 1);
//        GraphUtil.addDirectedEdge(graph, "A", "C", 1);
//        GraphUtil.addDirectedEdge(graph, "B", "D", 4);
//        GraphUtil.addDirectedEdge(graph, "C", "B", 1);
//        GraphUtil.addDirectedEdge(graph, "D", "C", -6);
//        GraphUtil.addDirectedEdge(graph, "D", "E", 1);
//        GraphUtil.addDirectedEdge(graph, "D", "F", 1);
//        GraphUtil.addDirectedEdge(graph, "E", "F", 1);
//        GraphUtil.addDirectedEdge(graph, "E", "G", 1);
//        GraphUtil.addDirectedEdge(graph, "F", "G", 1);
//
//
//        Map<String, Double> dijkstraDistance = bellmanFord(graph, 7, "A");
//        System.out.println(dijkstraDistance);

        Map<String, List<Edge<String>>> graph2 = new HashMap<>();
        GraphUtil.addDirectedEdge(graph2, "A", "B", 5);
        GraphUtil.addDirectedEdge(graph2, "B", "C", 20);
        GraphUtil.addDirectedEdge(graph2, "B", "F", 30);
        GraphUtil.addDirectedEdge(graph2, "B", "G", 60);
        GraphUtil.addDirectedEdge(graph2, "C", "E", 75);
        GraphUtil.addDirectedEdge(graph2, "C", "D", 10);
        GraphUtil.addDirectedEdge(graph2, "D", "C", -15);
        GraphUtil.addDirectedEdge(graph2, "E", "J", 100);
        GraphUtil.addDirectedEdge(graph2, "F", "E", 25);
        GraphUtil.addDirectedEdge(graph2, "F", "G", 5);
        GraphUtil.addDirectedEdge(graph2, "F", "I", 50);
        GraphUtil.addDirectedEdge(graph2, "G", "H", -50);
        GraphUtil.addDirectedEdge(graph2, "H", "I", -10);


        Map<String, Double> dijkstraDistance2 = bellmanFord(graph2, 10, "A");
        System.out.println(dijkstraDistance2);
    }

    private static Map<String, Double> bellmanFord(Map<String, List<Edge<String>>> graph, int numNodes, String start) {

        Map<String, Double> distance = new HashMap<>();
        distance.put(start, 0d);

        // Relax each edge for the first time with the shorter path and update
        // distance map with node and it's cost
        for (String key: graph.keySet()) {
            if(graph.get(key) != null) {
                for(Edge<String> edge: graph.get(key)){
                    double newDistance = distance.get(edge.from) + edge.cost;
                    Double valuePresent = distance.putIfAbsent(edge.to, newDistance);
                    if(valuePresent != null){
                        distance.put(edge.to, Math.min(valuePresent, newDistance));
                    }
                }
            }
        }

        //Repeat to find nodes caught in a negative cycle
        System.out.println(distance);
        for (String key: graph.keySet()) {
            if(graph.get(key) != null) {
                for(Edge<String> edge: graph.get(key)){
                    double newDistance = distance.get(edge.from) + edge.cost;
                    if(distance.get(edge.to) > newDistance) {
                        distance.put(edge.to, Double.NEGATIVE_INFINITY);
                    }
                }
            }
        }

        return distance;

    }
}

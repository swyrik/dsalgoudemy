package com.rtc.dsaudemy.graph;

import java.util.*;
import java.util.stream.Collectors;

public class TopologicalSort {

    public static void main(String[] args) {
        Map<String, List<Edge<String>>> graph = new HashMap<>();
        GraphUtil.addDirectedEdge(graph, "A", "D", 0);
        GraphUtil.addDirectedEdge(graph, "C", "A", 0);
        GraphUtil.addDirectedEdge(graph, "C", "B", 0);
        GraphUtil.addDirectedEdge(graph, "B", "D", 0);
        GraphUtil.addDirectedEdge(graph, "D", "H", 0);
        GraphUtil.addDirectedEdge(graph, "D", "G", 0);
        GraphUtil.addDirectedEdge(graph, "E", "A", 0);
        GraphUtil.addDirectedEdge(graph, "E", "D", 0);
        GraphUtil.addDirectedEdge(graph, "E", "F", 0);
        GraphUtil.addDirectedEdge(graph, "F", "K", 0);
        GraphUtil.addDirectedEdge(graph, "F", "J", 0);
        GraphUtil.addDirectedEdge(graph, "G", "I", 0);
        GraphUtil.addDirectedEdge(graph, "H", "J", 0);
        GraphUtil.addDirectedEdge(graph, "H", "I", 0);
        GraphUtil.addDirectedEdge(graph, "I", "L", 0);
        GraphUtil.addDirectedEdge(graph, "J", "M", 0);
        GraphUtil.addDirectedEdge(graph, "J", "L", 0);
        GraphUtil.addDirectedEdge(graph, "K", "J", 0);

        String collect = Arrays.stream(topSort(graph)).collect(Collectors.joining(","));
        System.out.println(collect);

    }

    public static String[] topSort(Map<String, List<Edge<String>>> graph){
        // number of nodes
        int numberOfNodes = 13;
        // to maintain already visited nodes
        Map<String, Boolean> visited = new HashMap<>();
        // to maintain the top sort elements
        String[] ordering = new String[numberOfNodes];
        int index = numberOfNodes - 1;

        //iterating through all the nodes
        for (String node : graph.keySet()){
            if(!visited.containsKey(node)){
                // linked hashmap is used to maintain the order.
                // we can also use array as well, since the lookup time is O(1)
                // we can't use LinkedList, since the lookup time is O(n)
                Map<String, Boolean> visitedNodes = new LinkedHashMap<>();
                dfs(node, visited, visitedNodes, graph);
                for (String key: visitedNodes.keySet()) {
                    ordering[index] = key;
                    index--;
                }
            }
        }
        return ordering;

    }

    private static void dfs(String node, Map<String, Boolean> visited, Map<String, Boolean> visitedNodes, Map<String, List<Edge<String>>> graph) {
        visited.putIfAbsent(node, true);
        List<Edge<String>> edges = graph.get(node);
        if(edges != null)
            for(Edge<String> edge: edges){
                if(!visited.containsKey(edge.to)){
                    dfs((String) edge.to,visited, visitedNodes, graph);
                }
            }
        visitedNodes.put(node, true);
    }
}

package com.rtc.dsaudemy.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.rtc.dsaudemy.graph.GraphUtil.addDirectedEdge;

public class DepthFirstSearchRecusrive {

    public static <T> void main(String[] args) {
        Map<Integer, List<Edge<Integer>>> graph = new HashMap<>();
        addDirectedEdge(graph, 0, 1, 4);
        addDirectedEdge(graph, 0, 2, 5);
        addDirectedEdge(graph, 1, 2, -2);
        addDirectedEdge(graph, 1, 3, 6);
        addDirectedEdge(graph, 2, 3, 1);
        addDirectedEdge(graph, 2, 2, 10);

        int numNodes = 5;
        Map<Integer, Boolean> visited = new HashMap<>();
        long nodeCount = dfs(graph, 0, visited);
        System.out.println("BFS node count starting at node 0: " + nodeCount);
    }

    private static long dfs(Map<Integer, List<Edge<Integer>>> graph, int start, Map<Integer, Boolean> visited) {
        if(visited.get(start) != null) return 0;
        visited.putIfAbsent(start, true);
        long count = 1;

        List<Edge<Integer>> edges = graph.get(start);
        if(edges != null){
            for(Edge edge : edges){
                count += dfs(graph, (Integer) edge.to, visited);
            }
        }
        return count;
    }
}

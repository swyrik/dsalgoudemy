package com.rtc.dsaudemy.graph;

import java.util.*;

import static com.rtc.dsaudemy.graph.GraphUtil.addDirectedEdge;

public class BreadthFirstSearch {

    public static <T> void main(String[] args) {
        Map<Integer, List<Edge<Integer>>> graph = new HashMap<>();
        addDirectedEdge(graph, 0, 1, 4);
        addDirectedEdge(graph, 0, 2, 5);
        addDirectedEdge(graph, 1, 2, -2);
        addDirectedEdge(graph, 1, 3, 6);
        addDirectedEdge(graph, 2, 3, 1);
        addDirectedEdge(graph, 2, 2, 10);

        int numNodes = 5;
        long nodeCount = bfs(graph, 0);
        System.out.println("BFS node count starting at node 0: " + nodeCount);
    }

    private static long bfs(Map<Integer, List<Edge<Integer>>> graph, int start) {
        long count = 0l;
        Queue<Integer> queue = new LinkedList<>();

        Map<Integer, Boolean> visitedNodes = new HashMap<>();
        queue.add(start);
        visitedNodes.putIfAbsent(start, true);
        while(!queue.isEmpty()){
            Integer vertex = queue.poll();
            count++;
            List<Edge<Integer>> edges = graph.get(vertex);
            if(edges != null){
                for(Edge<Integer> edge: edges){
                    if(!visitedNodes.containsKey(edge.to) && !queue.contains(edge.to)){
                        queue.add((Integer) edge.to);
                        visitedNodes.put((Integer) edge.to, true);
                    }
                }
            }
        }
        return count;

    }
}

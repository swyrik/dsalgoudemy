package com.rtc.dsaudemy.graph;

import java.util.*;

import static com.rtc.dsaudemy.graph.GraphUtil.addDirectedEdge;

public class BreadthFirstSearchShortestPath {

    public static <T> void main(String[] args) {
        Map<String, List<Edge<String>>> graph = new HashMap<>();
        addDirectedEdge(graph, "A", "B", 4);
        addDirectedEdge(graph, "B", "C", 5);
        addDirectedEdge(graph, "B", "E", -2);
        addDirectedEdge(graph, "C", "F", 6);
        addDirectedEdge(graph, "C", "D", 1);
        addDirectedEdge(graph, "E", "F", 10);

        int numNodes = 5;
        Map<String, String> prevMap = bfs(graph, "A");
        System.out.println(prevMap);
        reconstructPath(prevMap, "A", "F");
    }

    public static List<String> reconstructPath(Map<String, String> prevMap, String start, String end){

        List<String> path = new LinkedList<>();
        path.add(end);
        while(prevMap.get(path.get(path.size()-1)) != null){
            path.add(prevMap.get(path.get(path.size()-1)));
        }

        Collections.reverse(path);
        /**
         * some times we may not reach the end position than we need to
         * return an empty path
         * this happens when the graph is disjoint
         */
        if(path.get(0) == start){
            return new LinkedList<>();
        }
        return path;

    }

    private static Map<String, String> bfs(Map<String, List<Edge<String>>> graph, String start) {
        long count = 0l;
        Queue<String> queue = new LinkedList<>();
        Map<String, String> prevMap = new HashMap<>();
        Map<String, Boolean> visitedNodes = new HashMap<>();
        queue.add(start);
        visitedNodes.putIfAbsent(start, true);
        while(!queue.isEmpty()){
            String vertex = queue.poll();
            count++;
            List<Edge<String>> edges = graph.get(vertex);
            if(edges != null){
                for(Edge<String> edge: edges){
                    if(!visitedNodes.containsKey(edge.to) && !queue.contains(edge.to)){
                        queue.add((String) edge.to);
                        visitedNodes.put((String) edge.to, true);
                        prevMap.put((String) edge.to, vertex);
                    }
                }
            }
        }
        return prevMap;

    }
}

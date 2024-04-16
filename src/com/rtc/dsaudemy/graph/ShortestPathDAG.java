package com.rtc.dsaudemy.graph;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.rtc.dsaudemy.graph.GraphUtil.*;

/**
 * The shortest path algorithm for a directed acyclic graph (DAG) is also known
 * as the "topological sort" algorithm. This algorithm computes the shortest
 * path from a source node to all other nodes in a DAG. The time complexity
 * of this algorithm is O(V + E), where V is the number of vertices and E is
 * the number of edges in the DAG.
 */
public class ShortestPathDAG {

    public static void main(String[] args) {

        Map<String, List<Edge<String>>> graph = new HashMap<>();
        addDirectedEdge(graph, "A","B", 3);
        addDirectedEdge(graph, "A","C", 6);
        addDirectedEdge(graph, "B","C", 4);
        addDirectedEdge(graph, "B","D", 4);
        addDirectedEdge(graph, "B","E", 11);
        addDirectedEdge(graph, "C","D", 8);
        addDirectedEdge(graph, "C","G", 11);
        addDirectedEdge(graph, "D","E", -4);
        addDirectedEdge(graph, "D","F", 5);
        addDirectedEdge(graph, "D","G", 2);
        addDirectedEdge(graph, "E","H", 9);
        addDirectedEdge(graph, "F","H", 1);
        addDirectedEdge(graph, "G","H", 2);

        Map<String, Integer> shortestPath = dgaShortestPath(graph, "A", 8);
        System.out.println("Shortest Path");
        System.out.println("=============");
        System.out.println(shortestPath);

        /*
          for longest path convert all edge cost with -1
          and multiply the resultant distance map path -1
         */
        negativeEdges(graph);

        Map<String, Integer> longestPath = dgaShortestPath(graph, "A", 8);
        longestPath.forEach((s, integer) -> {
            longestPath.put(s, integer*-1);
        });

        System.out.println("Longest Path");
        System.out.println("=============");
        System.out.println(longestPath);

    }

    private static void negativeEdges(Map<String, List<Edge<String>>> graph) {
        for(String key : graph.keySet()){
            List<Edge<String>> edges = graph.get(key);
            edges = edges.stream().map(e -> {
                e.cost = e.cost * -1;
                return e;
            }).collect(Collectors.toList());
            graph.put(key, edges);
        }
    }

    /**
     * shortest path relies on top sort.
     * so, we will calculate the top sort first
     * Initialize an array or map with num nodes capacity.
     * from there on relax the nodes with minimum distance.
     *
     * numNodes is not necessarily present in the list.
     * since you can have singleton nodes with no edges which wouldn't be
     * present in the adjacency list but still part of the graph.
     * @param graph
     * @param start
     * @param numNodes
     * @return map
     */
    public static Map<String, Integer> dgaShortestPath(Map<String, List<Edge<String>>> graph, String start, int numNodes) {

        String[] topSort = TopologicalSortOptimized.topSort(graph,numNodes);
        Map<String, Integer> distance = new LinkedHashMap<>();
        distance.put(start, 0);

        for(int i =0; i<numNodes; i++){
            String node = topSort[i];
            if(distance.get(node) != null){
                List<Edge<String>> edges = graph.get(node);
                if(edges != null){
                    for (Edge<String> edge : edges){
                        /*
                         * calculating new distance and placing it in the map
                         * if the existing distance is null set the value
                         * or else replace the value with minimum distance
                         */
                        int newDist = distance.get(node) + edge.cost;
                        if(distance.get(edge.to) == null) distance.put((String) edge.to, newDist);
                        else distance.put((String) edge.to, Math.min(newDist, distance.get(edge.to)));
                    }
                }
            }
        }
        return distance;
    }
}

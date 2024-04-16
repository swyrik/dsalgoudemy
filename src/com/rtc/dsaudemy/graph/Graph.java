package com.rtc.dsaudemy.graph;

import java.lang.reflect.Array;
import java.util.*;

public class Graph<T extends Comparable<T>> {

    private HashMap<T , ArrayList<T>> adjList = new HashMap<>();

    public boolean addVertex(T value){
        if(adjList.get(value) == null) {
            adjList.put(value,  new ArrayList<T>());
            return true;
        }
        return false;
    }

    public boolean addEdge(T vertexA, T vertexB){
        if(adjList.get(vertexA) !=null && adjList.get(vertexB) != null){
            adjList.get(vertexA).add(vertexB);
            adjList.get(vertexB).add(vertexA);
            return true;
        }
        return false;
    }

    public boolean removeEdge(T vertexA, T vertexB){
        if(adjList.get(vertexA) !=null && adjList.get(vertexB) != null) {
            adjList.get(vertexA).remove(vertexB);
            adjList.get(vertexB).remove(vertexA);
            return true;
        }
        return false;
    }

    public boolean removeVertex(T vertex){
        if(adjList.get(vertex) == null) return false;
        for(T t : adjList.get(vertex)){
            adjList.get(t).remove(vertex);
        }
        adjList.remove(vertex);
        return true;
    }

    /**
     * Depth first search can solve many of the below problems
     * Compute a graph's minimum spanning tree
     * detect and find cycles in a graph
     * check if a graph is bipartite
     * find strongly connected components
     * topologically sort the nodes of a graph
     * fond bridges and articulation points
     * find augmenting paths in a flow of network
     * Generate mazes
     * @param start
     * @return
     * @param <T>
     */
    public <T> long dfs(T start){
        long count = 0l;
        // creating a stack to keep track of nodes
        Stack<T> stack = new Stack<T>();
        stack.add(start);

        // maintaing a map whether to check visited or not
        Map<T, Boolean> visited = new HashMap<>();
        visited.putIfAbsent(start, true);

        while(!stack.isEmpty()){
            T node = stack.pop();
            count++;
            ArrayList<T> edges = (ArrayList<T>) adjList.get(node);
            if(edges != null){
                for(T edge : edges){
                    if(!visited.containsKey(edge)){
                        stack.push(edge);
                        visited.putIfAbsent(edge, true);
                    }
                }
            }
        }

        return count;
    }

    public void printGraph(){
        System.out.println(adjList);
    }

    public static void main(String[] args) {
        Graph<String> stringGraph = new Graph<>();

        stringGraph.addVertex("A");
        stringGraph.addVertex("B");
        stringGraph.addVertex("C");
        stringGraph.addVertex("D");
        stringGraph.addEdge("A", "B");
        stringGraph.addEdge("A", "C");
        stringGraph.addEdge("A", "D");
        stringGraph.addEdge("B", "C");
        stringGraph.addEdge("B", "D");
        stringGraph.printGraph();
//        stringGraph.removeEdge("A","D");
//        stringGraph.printGraph();
//        stringGraph.removeVertex("A");
        stringGraph.printGraph();

        stringGraph.dfs("A");

        Graph<String> stGraph = new Graph<>();
        stGraph.addVertex("A");
        stGraph.addVertex("B");
        stGraph.addVertex("C");
        stGraph.addVertex("D");
        stGraph.addVertex("E");
        stGraph.addVertex("F");
        stGraph.addVertex("H");
        stGraph.addEdge("A","B");
        stGraph.addEdge("A","C");
        stGraph.addEdge("B","D");
        stGraph.addEdge("C","D");
        stGraph.addEdge("C","H");
        stGraph.addEdge("C","E");
        stGraph.addEdge("E","F");
        stGraph.addEdge("D","F");
        stGraph.dfs("A");

    }

}

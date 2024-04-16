package com.rtc.dsaudemy.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class GraphUtil {

    public static <T> void addDirectedEdge(Map<T, List<Edge<T>>> graph, T from, T to, int cost){
        List<Edge<T>> edges = graph.get(from);
        if(edges == null){
            edges = new ArrayList<>();
            graph.put(from, edges);
        }
        edges.add(new Edge<T>(from, to, cost));
    }

    public static <T> void addDirectedEdge(Map<T, List<Edge>> graph, Edge edge) {
        List<Edge> list = graph.get(edge.from);
        if(null == list){
            list =  new ArrayList<Edge>();
            graph.put((T)edge.from, list);
        }
        list.add(edge);
    }

    public static <T> int numberOfNodes(Map<T, List<Edge>> graph){
        return graph.keySet().size();
    }
}

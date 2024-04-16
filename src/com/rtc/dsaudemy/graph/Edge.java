package com.rtc.dsaudemy.graph;

public class Edge<T> {

    T from;
    T to;
    int cost;

    public Edge(T from, T to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

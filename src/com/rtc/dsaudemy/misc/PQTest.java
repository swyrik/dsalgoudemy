package com.rtc.dsaudemy.misc;

import java.util.PriorityQueue;

public class PQTest {

    public static void main(String[] args) {
        PriorityQueue<Pair> integers = new PriorityQueue<Pair>((p1, p2) -> p1.getValue().compareTo(p2.getValue()));
        integers.add(new Pair("A",3));
        integers.add(new Pair("B",1));
        integers.add(new Pair("A",6));
        System.out.println(integers.poll());

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

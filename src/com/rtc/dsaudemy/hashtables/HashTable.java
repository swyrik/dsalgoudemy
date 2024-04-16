package com.rtc.dsaudemy.hashtables;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashTable<T extends Comparable<T>> {

    // having prime to minimize the collisions
    private int size = 7;
    Node[] dataMap;

    class Node {
        T key;
        T value;
        Node next;

        Node(T key, T value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key +" : " + value +" -> " + (next != null ? next.toString() : "");
        }
    }

    public HashTable(){
        dataMap = (Node[]) Array.newInstance(Node.class, size);
    }

    public void set(T key, T value){
        int index = hash(key);
        Node newNode = new Node(key, value);
        if(dataMap[index] == null){
            dataMap[index] = newNode;
        }else{
            Node temp = dataMap[index];
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public T get(T key){
        int index = hash(key);
        Node temp = dataMap[index];
        while(temp!=null){
            if(temp.key == key){
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    public List<T> keys(){
        List<T> keys = new ArrayList<>();
        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];
            while(temp != null){
                keys.add(temp.key);
                temp = temp.next;
            }
        }
        return keys;
    }

    private int hash(T key){
        int hash = 0;
        char[] keyChars = key.toString().toCharArray();
        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dataMap.length; i++) {
            sb.append(i + " : ");
            if(dataMap[i] != null) sb.append(dataMap[i].toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        HashTable ht = new HashTable();
        ht.set("nails", 100);
        ht.set("tile", 50);
        ht.set("lumber", 100);

        ht.set("bolts", 200);
        ht.set("screws", 140);
        System.out.println(ht);

        System.out.println(ht.get("lumber"));
        System.out.println(ht.keys());
    }
}

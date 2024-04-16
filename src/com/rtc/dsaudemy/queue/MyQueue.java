package com.rtc.dsaudemy.queue;

import com.sun.jdi.Value;

public class MyQueue<T extends Comparable<T>> {

    class Node {
        T value;
        Node next;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value + " -> " + (next != null ? next.toString() : "null");
        }
    }

    private Node first;
    private Node last;
    private int length;

    public MyQueue(T value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public void enqueue(T value){
        Node newNode = new Node(value);
        if(length == 0){
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public Node dequeue(){
        if(length == 0){
            return null;
        }
        Node temp = first;
        if (length == 1){
            first = null;
            last = null;
        }else{
            first = first.next;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public void getFirst() {
        System.out.println("First: "+ ((first != null) ? first.value : "null"));
    }

    public void getLast(){
        System.out.println("Last: " + ((last != null) ? last.value : "null"));
    }

    public void getLength(){
        System.out.println("Length: "+length);
    }

    @Override
    public String toString() {
        if(this.length == 0){
            return "";
        }
        return first.toString();
    }

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<Integer>(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.enqueue(5);
        myQueue.enqueue(6);
        System.out.println(myQueue);
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue);
        myQueue.getFirst();
        myQueue.getLast();
    }
}

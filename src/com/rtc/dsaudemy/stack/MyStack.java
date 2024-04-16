package com.rtc.dsaudemy.stack;

import java.util.Stack;

public class MyStack<T extends Comparable<T>> {

    class Node<T> {
        T value;
        Node next;

        Node(T value){
            this.value= value;

        }

        @Override
        public String toString() {
            return this.value + " -> " + (next != null ? next.toString() : "null");
        }
    }

    private Node top;
    private int height;

    public MyStack(T value){
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void push(T t){
        Node newNode = new Node(t);
        newNode.next = top;
        top = newNode;
        height++;
    }

    public Node pop(){
        if(top == null) return null;
        Node temp = top;
        top = temp.next;
        temp.next = null;
        height--;
        return temp;
    }

    @Override
    public String toString() {
        if(top == null){
            return "";
        }
        return top.toString();
    }

    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>(3);
        myStack.push(5);
        myStack.push(35);
        myStack.push(25);
        myStack.push(15);
        System.out.println(myStack);
        System.out.println(myStack.pop());
        System.out.println(myStack);
    }
}

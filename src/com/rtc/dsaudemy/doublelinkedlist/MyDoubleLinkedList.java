package com.rtc.dsaudemy.doublelinkedlist;

import com.rtc.dsaudemy.linkedlist.MyLinkedList;

import java.util.Comparator;

public class MyDoubleLinkedList<T extends Comparable<T>> {
    private Node<T> head;
    private Node<T> tail;
    private int length;

    public class Node<T extends Comparable<T>> {

        T value;
        Node<T> next;
        Node<T> prev;
        Node(T t){
            this.value = t;
        }

        @Override
        public String toString() {
            return value + " <=> " + (next != null ? next.toString() : null);
        }
    }

    public MyDoubleLinkedList(T t) {
        Node newNode = new Node(t);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    @Override
    public String toString() {
        if(head == null) {
            return "";
        }
        return head.toString();
    }

    public void getHead(){
        System.out.println("Head: "+head.value);
    }

    public void getTail(){
        System.out.println("Tail: "+tail.value);
    }

    public void getLength(){
        System.out.println("Length: "+ length);
    }

    public void append(T t){
        Node newNode = new Node(t);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public Node removeFirst(){
        if(length == 0) return null;
        Node temp = head;
        if(length == 1){
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;

        }
        length--;
        return temp;
    }

    public Node removeLast(){
        if(length == 0) return null;
        Node temp = tail;

        if(length == 1){
            head = null;
            tail = null;
        } else {
            tail = temp.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;

        return temp;
    }

    public void prepend(T t){
        Node newNode = new Node(t);
        if(length == 0){
            head = newNode;
            tail = newNode;
        } else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public Node get(int index){
        if(index<0 || index >= length){
            return null;
        }
        if(index <= length/2){
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else{
            Node temp = tail;
            for (int i = length-1; i > index; i--) {
                temp = temp.prev;
            }
            return temp;
        }
    }

    public boolean set(int index, T t){
        Node temp = get(index);
        if(temp != null){
            temp.value = t;
            return true;
        }
        return false;
    }
    public boolean insert(int index, T t){
        if(index < 0 || index > length) return false;
        if(index == 0) {
            prepend(t);
            return true;
        }
        if(index == length - 1){
            append(t);
            return true;
        }
        Node newNode = new Node(t);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        newNode.prev= temp;
        temp.next.prev = newNode;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node<T> remove(int index){
        if(index < 0 || index > length) return null;
        if(index == 0) return removeFirst();
        if(index == length-1) return removeLast();
        Node temp = get(index);
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.prev = null;
        temp.next = null;
        length--;
        return temp;
    }

    public static void main(String[] args) {
        MyDoubleLinkedList<Integer> myddl = new MyDoubleLinkedList<Integer>(4);
        myddl.getHead();
        myddl.getTail();
        myddl.getLength();
        System.out.println(myddl);
        myddl.append(23);
        myddl.append(3);
        myddl.append(6);
        myddl.append(48);
        System.out.println(myddl);
        System.out.println(myddl.removeLast().value);
        System.out.println(myddl.removeLast().value);
        System.out.println(myddl);
        myddl.prepend(21);
        myddl.prepend(22);
        System.out.println(myddl);
        System.out.println(myddl.removeFirst().value);
        System.out.println(myddl.removeFirst().value);
        System.out.println(myddl);
        myddl.append(23);
        myddl.append(3);
        myddl.append(6);
        myddl.append(48);
        System.out.println(myddl);
        System.out.println(myddl.get(5).value);
        myddl.set(5, 77);
        System.out.println(myddl.get(5).value);
        System.out.println(myddl);
        myddl.insert(5, 98);
        System.out.println(myddl);
        myddl.remove(2);
        System.out.println(myddl);


    }
}

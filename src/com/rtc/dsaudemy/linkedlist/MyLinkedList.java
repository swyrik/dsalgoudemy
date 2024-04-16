package com.rtc.dsaudemy.linkedlist;

public class MyLinkedList<T> {



    public class Node<T> {

        T value;
        Node next;

        Node(T t){
            this.value = t;
        }

        @Override
        public String toString() {
            return String.valueOf(value) + " -> " + (next == null? "null" : next.toString());
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int length;

    public MyLinkedList(T t){
        Node newNode = new Node(t);
        head = newNode;
        tail = newNode;
        length = 1;

    }

    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead(){
        System.out.println("Head:" + head.value);
    }

    public void getTail(){
        System.out.println("Tail:" + tail.value);
    }

    public void getLength(){
        System.out.println("Length:" + length);
    }

    public void append(T t){
        Node newNode = new Node(t);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeAtLast(){
        if(head == null){
            return null;
        }
        Node temp = head;
        Node pre = head;
        while(temp.next != null){
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if(length == 0){
            head = null;
            tail = null;
        }
        return temp;

    }

    public void prepend(T t){
        Node newNode = new Node(t);
        if(length == 0){
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;

    }

    public Node removeFirst(){
        if(length == 0){
            return null;
        }
        Node temp = head;
        head = head.next;
        length--;
        if(length == 0){
            tail = null;
        }
        return temp;
    }

    public Node get(int index){
        if(index < 0 || index >= length){
            return null;
        }
        Node temp = head;
        while(index > 0){
            temp = temp.next;
            index--;
        }
        return temp;
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
        if(index == 0){
            prepend(t);
            return true;
        }
        if(length == index){
            append(t);
            return true;
        }
        Node newNode = new Node(t);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index){
        if(index < 0 || index >= length) return null;
        if(index == 0) return removeFirst();
        if(index == length - 1) return removeAtLast();
        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = null;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public void reverseBetween(int startIndex, int lastIndex){
        if(length == 0 || length ==1) return;

        if(startIndex < 0 || lastIndex > length || startIndex > lastIndex) return;

        Node startIndexHead = head;
        Node startIndexPrev = null;
        Node lastIndexTail = null;
        int start = 0;
        while(start < startIndex) {
            startIndexPrev = startIndexHead;
            startIndexHead = startIndexHead.next;
            start++;
        }

        lastIndexTail = startIndexHead;
        Node lastIndexNext = startIndexHead.next;
        while(start < lastIndex){
            lastIndexTail = lastIndexTail.next;
            lastIndexNext = lastIndexTail.next;
            start++;
        }

        Node before = null;
        Node after  = null;
        Node temp = startIndexHead;
        startIndexHead = lastIndexTail;
        lastIndexTail = temp;

        for (int i = 0; i <= lastIndex - startIndex; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }

        if(startIndexPrev != null){
            startIndexPrev.next = startIndexHead;
        } else {
            head = startIndexHead;
        }

        lastIndexTail.next = lastIndexNext;


    }

    @Override
    public String toString() {
        if(head == null){
            return "";
        }
        return head.toString();
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> intList = new MyLinkedList<>(3);
        intList.append(4);
        intList.append(5);
        System.out.println(intList);
        intList.removeAtLast();
        System.out.println(intList);
        intList.prepend(7);
        System.out.println(intList);
        intList.removeFirst();
        System.out.println(intList);
        intList.prepend(1);
        intList.prepend(8);
        System.out.println(intList);
        System.out.println(intList.get(0).value);
        intList.set(1, 22);
        intList.insert(2, 21);
        System.out.println(intList);
        intList.remove(1);
        System.out.println(intList);
        intList.reverse();
        intList.append(5);
        System.out.println(intList);
        intList.reverseBetween(1,3);
        System.out.println(intList);

    }
}

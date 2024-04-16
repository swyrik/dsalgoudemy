package com.rtc.dsaudemy.heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap<T extends Comparable<T>> {

    private List<T> heap;

    public MinHeap() {
        this.heap = new ArrayList<T>();
    }

    public List<T> getHeap() {
        return new ArrayList<>(heap);
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(T value) {
        heap.add(value);
        int current = heap.size() - 1;

        while (current > 0 && heap.get(current).compareTo(heap.get(parent(current))) < 0) {
            swap(current, parent(current));
            current = parent(current);
        }
        System.out.println(heap);
    }

    private void sinkDown(int index) {
        int minIndex = index;
        while (true) {
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);

            if (leftIndex < heap.size() && heap.get(leftIndex).compareTo(heap.get(minIndex)) < 0) {
                minIndex = leftIndex;
            }

            if (rightIndex < heap.size() && heap.get(rightIndex).compareTo(heap.get(minIndex)) < 0) {
                minIndex = rightIndex;
            }

            if (minIndex != index) {
                swap(index, minIndex);
                index = minIndex;
            } else {
                return;
            }
        }
    }

    public T remove() {
        if (heap.size() == 0) {
            return null;
        }

        if (heap.size() == 1) {
            return heap.remove(0);
        }

        T minValue = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        sinkDown(0);

        System.out.println(heap);
        return minValue;
    }
    private void print(){
        System.out.println(heap);
    }

    public static void main(String[] args) {
        MinHeap<Integer> heap = new MinHeap<>();
        heap.insert(34);
        heap.insert(44);
        heap.insert(12);
        heap.insert(60);
        heap.insert(99);
        heap.insert(101);

        System.out.println("\n remove starts\n");
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();


    }

}

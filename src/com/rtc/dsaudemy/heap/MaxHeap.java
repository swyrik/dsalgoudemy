package com.rtc.dsaudemy.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * MAX HEAP Implementation
 * @param <T>
 */
public class MaxHeap<T extends Comparable<T>> {

    public List<T> heap;

    public MaxHeap(){
        heap = new ArrayList<>();
    }
    private int leftChild(int index){
        return 2 * index + 1;
    }

    private int rightChild(int index){
        return 2 * index + 2;
    }

    private int parent(int index){
        return (index -1)/2;
    }

    private void swap(int index1, int index2){
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    private void insert(T value){
        heap.add(value);
        int current = heap.size() -1;
        while(current > 0 && heap.get(current).compareTo(heap.get(parent(current))) > 0){
            swap(current, parent(current));
            current = parent(current);
        }
        System.out.println(heap);

    }

    private T remove(){
        if(heap.isEmpty()){
            return null;
        }

        if(heap.size() == 1){
            return heap.remove(0);
        }

        T maxValue = heap.get(0);
        // remove the last element and set it at the first index.
        heap.set(0, heap.remove(heap.size() -1));
        sinkDown(0);

        System.out.println(heap);
        return maxValue;
    }

    private void sinkDown(int index) {
        int maxIndex = index;
        while(true){
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);

            if(leftIndex < heap.size() && heap.get(leftIndex).compareTo(heap.get(maxIndex)) > 0){
                maxIndex = leftIndex;
            }

            if(rightIndex < heap.size() && heap.get(rightIndex).compareTo(heap.get(maxIndex)) > 0){
                maxIndex = rightIndex;
            }

            if(maxIndex != index){
                swap(index, maxIndex);
                index = maxIndex;
            } else {
                return;
            }
        }
    }

    private void print(){
        System.out.println(heap);
    }

    public static void main(String[] args) {
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.insert(34);
        heap.insert(44);
        heap.insert(12);
        heap.insert(60);
        heap.insert(99);
        heap.insert(101);
        heap.print();

        System.out.println("\n remove starts\n");
        Integer remove = heap.remove();
        System.out.println(remove);
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();


    }
}

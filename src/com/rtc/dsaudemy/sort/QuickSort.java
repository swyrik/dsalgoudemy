package com.rtc.dsaudemy.sort;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickSort<T extends Comparable> {

    public static void main(String[] args) {
        Integer[] myArray = {4,2,55,1,-34,22};
        QuickSort<Integer> qs =new QuickSort<>();
        qs.quickSort(myArray, 0, myArray.length -1 );
        Stream.of(myArray).forEach(System.out::println);
    }

    public void quickSort(T[] arr, int left, int right){
        if(left < right){
            int pivotIndex = pivot(arr, left, right);
            quickSort(arr, left, pivotIndex-1);
            quickSort(arr, pivotIndex+1, right);
        }
    }

    public int pivot(T[] arr, int pivotIndex, int endIndex){
        int swapIndex = pivotIndex;
        for (int i = pivotIndex+1; i <= endIndex; i++) {
            if(arr[i].compareTo(arr[pivotIndex]) < 0){
                swapIndex++;
                swap(arr, swapIndex, i);
            }
        }
        swap(arr, pivotIndex, swapIndex);
        return swapIndex;
    }

    public void swap(T[] arr, int swapIndex, int i){
        T temp = arr[swapIndex];
        arr[swapIndex] = arr[i];
        arr[i] = temp;
    }
}

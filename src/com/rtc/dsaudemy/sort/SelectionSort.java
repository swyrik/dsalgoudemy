package com.rtc.dsaudemy.sort;

import java.util.Arrays;
import java.util.List;

public class SelectionSort<T extends Comparable> {
    public static void main(String[] args) {
        SelectionSort<Integer> bs = new SelectionSort<>();
        List<Integer> integers = List.of(34, 245, 647, 4543, 424, 53, 4, 34, 2452);
        Integer[] arrSorted= bs.sort(integers.toArray(value -> integers.toArray(new Integer[0])));
        Arrays.stream(arrSorted).forEach(System.out::println);
    }

        public T[] sort(T[] arr){
            for (int i = 0; i < arr.length; i++) {
                int minIndex = i;
                for (int j = i+1; j < arr.length; j++) {
                    if (arr[minIndex].compareTo(arr[j]) > 0) {
                        minIndex = j;
                    }
                }
                if(i != minIndex){
                    T temp = arr[i];
                    arr[i] = arr[minIndex];
                    arr[minIndex] = temp;
                }
            }
            return arr;
        }
}

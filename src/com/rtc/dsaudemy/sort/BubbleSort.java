package com.rtc.dsaudemy.sort;

import java.util.Arrays;
import java.util.List;

public class BubbleSort<T extends Comparable> {

    public static void main(String[] args) {
        BubbleSort<Integer> bs = new BubbleSort<>();
        List<Integer> integers = List.of(34, 245, 647, 4543, 424, 53, 4, 34, 2452);
        Integer[] arrSorted= bs.sort(integers.toArray(value -> integers.toArray(new Integer[0])));
        Arrays.stream(arrSorted).forEach(System.out::println);
    }

    public T[] sort(T[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i].compareTo(arr[j]) < 0) {
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}

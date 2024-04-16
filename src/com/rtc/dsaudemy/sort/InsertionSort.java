package com.rtc.dsaudemy.sort;

import java.util.Arrays;
import java.util.List;

public class InsertionSort<T extends Comparable> {
    public static void main(String[] args) {
        InsertionSort<Integer> bs = new InsertionSort<>();
        List<Integer> integers = List.of(34, 245, 647, 4543, 424, 53, 4, 34, 2452);
        Integer[] arrSorted= bs.sort(integers.toArray(value -> integers.toArray(new Integer[0])));
        Arrays.stream(arrSorted).forEach(System.out::println);
    }

    public T[] sort(T[] arr){
        for (int i = 1; i < arr.length; i++) {
            T temp = arr[i];
            int j = i-1;
            while(temp.compareTo(arr[j]) < 0){
                arr[j+1] = arr[j];
                arr[j] = temp;
                if(j == 0){
                    break;
                } else{
                    j--;
                }
            }
        }
        return arr;
    }
}

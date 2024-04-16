package com.rtc.dsaudemy.sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Space Complexity is O(N)
 * Time Complexity is O(NlogN)
 * @param <T>
 */

public class MergeSort<T extends Comparable> {

    public static void main(String[] args) {

        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] arr1 = {21,1,-1,4,22,6,99,12};
        Stream.of(ms.mergeSort(arr1, Integer.class)).forEach(System.out::println);

    }

    public T[] mergeSort(T[] array, Class<?> T){
        if(array.length == 1) return array;

        int midIndex = array.length/2;
        T[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex), T);
        T[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length), T);

        return merge(left, right, T);
    }

    public T[] merge(T[] array1, T[] array2, Class<?> T){
        T[] combined = (T[]) Array.newInstance(T, array1.length + array2.length);
        int index = 0;
        int i = 0;
        int j = 0;
        while(i< array1.length && j < array2.length){
            if(array1[i].compareTo(array2[j]) < 0){
                combined[index] = array1[i];
                i++;
            } else {
                combined[index] = array2[j];
                j++;
            }
            index++;
        }

        while(j < array2.length) {
            combined[index] = array2[j];
            j++;
            index++;
        }

        while(i < array1.length) {
            combined[index] = array1[i];
            i++;
            index++;
        }
        return combined;
    }
}

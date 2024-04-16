package com.rtc.dsaudemy;

import java.util.*;

public class MaxElementMap {
    public static Map<Integer, Integer> createMaxElementMap(int[] arr) {
        Map<Integer, Integer> maxElementMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (!maxElementMap.containsKey(i) || num > maxElementMap.get(i)) {
                maxElementMap.put(i, num);
            }
        }

        return maxElementMap;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 2, 4};
        Map<Integer, Integer> maxElementMap = createMaxElementMap(arr);

        // To get the maximum element at a specific index (e.g., index 2):
        int index = 0;
        if (maxElementMap.containsKey(index)) {
            int maxElement = maxElementMap.get(index);
            System.out.println("The maximum element at index " + index + " is " + maxElement);
        } else {
            System.out.println("No maximum element found at index " + index);
        }
    }
}

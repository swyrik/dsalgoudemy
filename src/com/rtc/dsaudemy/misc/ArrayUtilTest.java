package com.rtc.dsaudemy.misc;

import java.util.Arrays;

import static java.util.Arrays.*;

public class ArrayUtilTest {


    public static void main(String[] args) {
        int[] arr = new int[]{3,90,42,2,3,2,5,2,55,67,84,43};
//        Arrays.sort(arr);
//        Arrays.parallelSort(arr);
        // sort only first five numbers
        sort(arr, 0, 5);
        System.out.println(Arrays.toString(arr));

        int[] newarr = new int[]{3,2,1,90,8,9,78,6,7,5};
        int[] ints = copyOf(newarr, 5);
        sort(ints);
        System.out.println(Arrays.toString(ints));
        parallelPrefix(ints, (left, right) -> left-1);
        System.out.println(Arrays.toString(ints));

        System.out.println(Arrays.equals(ints, newarr));

        int[][] fd = new int[][]{{1,2},{3,4}};
        int[][] sd = new int[][]{{1,2},{3,4}};

        // deep equals can check multi dimensional array
        System.out.println(Arrays.deepEquals(fd, sd));

        int[] allTwoArr = new int[7];
        Arrays.fill(allTwoArr, 3,7, 2);
        System.out.println(Arrays.toString(allTwoArr));

    }

}

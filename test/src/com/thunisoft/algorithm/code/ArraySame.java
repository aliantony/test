package com.thunisoft.algorithm.code;

import java.util.Arrays;

public class ArraySame {
    
    public static void main(String arg[]) {
        int[] array_1 = new int[] { 1, 2, 1, 4, 6, 9 };
        int[] array_2 = new int[] { 5, 7, 2, 3, 6, 1, 9, 1, 3 };
        Arrays.sort(array_1);
        Arrays.sort(array_2);
        int len = array_1.length;
        for (int i = 0; i < len; i++) {
            if (Arrays.binarySearch(array_2, array_1[i]) >= 0) {
                System.out.println(array_1[i]);
            }
        }
        // Arrays.binarySearch 返回-1就没有找到
    }
    
}

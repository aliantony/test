package com.thunisoft.algorithm.code;

import java.util.Arrays;

public class ArraySame1 {
    
    public static void main(String[] args) {
        int param[] = { 1, 2, 4, 4, 5, 6, 7, 3, 9 };
        int param2[] = { 3, 4, 6, 9, 4, 70, 8 };
        Arrays.sort(param);
        Arrays.sort(param2);
        int result;
        int old = 0;
        int news = 0;
        System.out.print("两数组之间的公共元素:");
        for (int i = 0; i < param2.length; i++) {
            result = Arrays.binarySearch(param, param2[i]);
            if (result >= 0) {
                news = param[result];
                // 去除重复的值
                if (news != old) {
                    System.out.print(news + ",");
                    old = news;
                }
            }
        }
        int[] param3 = { 2, 1, 5, 2, 32, 12, 9, 10, 3 };
        sort1(param3, 0, 6);// 对数组前6位排序
    }
    
    private static int[] sort1(int x[], int off, int len) {
        // Insertion sort on smallest arrays
        if (len <= x.length) {
            for (int i = off; i < len + off; i++) {
                for (int j = i; j > off && x[j - 1] > x[j]; j--) {
                    swap(x, j, j - 1);
                }
            }
            
        }
        System.out.println("排序后的数组:");
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }
        return x;
    }
    
    private static int[] swap(int x[], int index, int index2) {
        int temp = x[index];
        x[index] = x[index2];
        x[index2] = temp;
        return x;
    }
}

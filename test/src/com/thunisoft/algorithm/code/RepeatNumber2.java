package com.thunisoft.algorithm.code;

public class RepeatNumber2 {
    
    public static void go(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                i++;
            }
            else if (a[i] > b[j]) {
                j++;
            }
            else {
                System.out.print(a[i] + " ");
                i++;
                j++;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] a = { 1, 5, 8, 10, 14, 15, 17, 18, 20, 22, 24, 25, 12, 12, 28 };
        int[] b = { 2, 4, 6, 8, 10, 12 };
        go(a, b);
    }
}

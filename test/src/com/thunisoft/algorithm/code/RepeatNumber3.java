package com.thunisoft.algorithm.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RepeatNumber3 {
    
    public static int find(int key, int[] N) {
        int lb = 0;
        int ub = N.length - 1;
        int in;
        while (true) {
            in = (lb + ub) / 2;
            if (N[in] == key) {
                return in;
            }
            else if (lb > ub) {
                return -1;
            }
            else {
                if (N[in] < key) {
                    lb = in + 1;
                }
                else {
                    ub = in - 1;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[] M = RandomIntArray(30);
        int[] N = RandomIntArray(30);
        System.out.println(Arrays.toString(M));
        System.out.println(Arrays.toString(N));
        Set<Integer> list = new HashSet<Integer>();
        for (int m : M) {
            int getInt = find(m, N);
            if (getInt != -1) {
                list.add(N[getInt]);
            }
        }
        System.out.println("两个数组中重复的元素有：" + list);
    }
    
    public static int[] RandomIntArray(int count) {
        int[] array = new int[count];
        Random r = new Random();
        for (int i = 0; i < count; i++) {
            array[i] = r.nextInt(100);
        }
        Arrays.sort(array);
        return array;
    }
}

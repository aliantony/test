package com.thunisoft.algorithm.code;

public class ThirteenthTwiceSqrt {
    
    public static void main(String[] args) {
        for (long l = 1L; l < 100000; l++) {
            if (Math.sqrt((l + 100)) % 1 == 0) {
                if (Math.sqrt((l + 268)) % 1 == 0) {
                    System.out.println(l + "加100是一个完全平方数，再加168又是一个完全平方数");
                }
            }
        }
        
    }
}

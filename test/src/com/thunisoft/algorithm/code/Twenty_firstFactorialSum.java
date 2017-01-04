package com.thunisoft.algorithm.code;

/*
 * 【程序21】 作者 若水飞天 题目：求1+2!+3!+...+20!的和 1.程序分析：此程序只是把累加变成了累乘。
 */
public class Twenty_firstFactorialSum {
    
    static long sum = 0;
    
    static long fac = 0;
    
    public static void main(String[] args) {
        long sum = 0;
        long fac = 1;
        for (int i = 1; i <= 10; i++) {
            fac = fac * i;// 太高级了，此处是把每次的值做了保留
            sum += fac;
        }
        System.out.println(sum);
    }
    
}

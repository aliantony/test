package com.thunisoft.algorithm.code;

/*
 * 【程序22】 作者 若水飞天 题目：利用递归方法求5!。 1.程序分析：递归公式：fn=fn_1*4!
 */
import java.util.Scanner;

public class Twenty_secondFactorialRecursion {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Twenty_secondFactorialRecursion tfr = new Twenty_secondFactorialRecursion();
        System.out.println(tfr.recursion(n));
        
    }
    
    public long recursion(int n) {
        long value = 0;
        if (n == 1 || n == 0) {
            value = 1;
        }
        else if (n > 1) {
            value = n * recursion(n - 1);
        }
        return value;
    }
    
}

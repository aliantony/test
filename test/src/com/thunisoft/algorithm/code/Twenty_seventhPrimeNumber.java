package com.thunisoft.algorithm.code;

/*
 * 【程序27】 作者 若水飞天 题目：求100之内的素数 1.程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)， 如果能被整除，
 * 则表明此数不是素数，反之是素数。
 */
public class Twenty_seventhPrimeNumber {
    
    public static void main(String[] args) {
        boolean b = false;
        int count = 0;
        for (int i = 2; i < 100; i += 1) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    b = false;
                    break;
                }
                else {
                    b = true;
                }
            }
            
            if (b == true) {
                count++;
                System.out.print(i + " ");
            }
        }
        System.out.println("/n" + "The number of PrimeNumber is :" + count);
    }
}

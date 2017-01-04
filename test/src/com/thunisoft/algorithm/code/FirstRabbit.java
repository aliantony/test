package com.thunisoft.algorithm.code;

/*
 * 【程序1】
 * 题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
 * 1.程序分析： 兔子的规律为数列1,1,2,3,5,8,13,21....
 */
public class FirstRabbit {
    
    public static void main(String[] args) {
        int m1 = 1, m2 = 1;
        int month = 12;
        for (int i = 3; i <= month; i++) {
            int rabbitNum = m1 + m2;
            m1 = m2;
            m2 = rabbitNum;
            System.out.println("当前月份:" + i + "兔子数:" + rabbitNum);
        }
    }
}

package com.thunisoft.algorithm.code;

/*
 * 【程序16】 作者 若水飞天题目：输出9*9口诀。1.程序分析：分行与列考虑，共9行9列，i控制行，j控制列。
 */
public class SixteenthMultiplicationTable {
    
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + j * i + " ");
            }
            System.out.println();
        }
        
    }
    
}

package com.thunisoft.algorithm.code;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.bag.HashBag;

public class RepeatNumber {
    
    public static void main(String[] args) {
        int[] M = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3 };
        int[] N = { 5, 2, 5, 6, 7, 8, 9 };
        Set<Integer> setM = new HashSet<Integer>();
        for (int m : M) {
            setM.add(m);// 将数组M添加到setM中为了为了避免M中的重复元素
        }
        Set<Integer> setN = new HashSet<Integer>();
        for (int n : N) {
            setN.add(n);// 将数组N添加到setN中为了为了避免N中的重复元素
        }
        HashBag bag = new HashBag();// HashBag是一个org.apache.commons.collections.bag包中的类，可以很简单的求出两个集合中的交集
        bag.addAll(setM);
        bag.addAll(setN);
        System.out.println(bag);
        // A:B B代表元素 A代表重复的次数，重复次数大于1说明在两个数组中都出现过
        // [1:1,2:2,1:3,1:4,2:5,2:6,2:7,2:8,2:9]
    }
}

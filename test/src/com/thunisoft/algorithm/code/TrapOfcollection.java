package com.thunisoft.algorithm.code;

import java.util.LinkedList;
import java.util.List;

public class TrapOfcollection {
    
    public static void main(String[] args) {
        List<String> list = new LinkedList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("即将删除的元素：" + list.get(i));
            list.remove(i);
            i--;// 归位
        }
        System.out.println(list.size());
    }
}

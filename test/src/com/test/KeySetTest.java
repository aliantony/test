package com.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/** 
 * 2015年4月9日下午3:33:44 
 * @version 1.0 
 */  
public class KeySetTest {  
    public static void main(String[] args) {  
        Map<String, String> map = new HashMap<String, String>();  
        map.put("a", "1");  
        map.put("b", "2");  
        map.put("c", "3");  
        map.put("d", "4");  
          
        System.out.print("HashMap:");  
        for(String key : map.keySet()) {  
            System.out.print(map.get(key) + " ");  
        }  
          
        Map<String, String> linkedMap = new LinkedHashMap<String, String>();  
        linkedMap.put("a", "1");  
        linkedMap.put("b", "3");  
        linkedMap.put("c", "2");  
        linkedMap.put("d", "4");  //有序是指元素增加或访问的先后顺序，并不是按元素大小排序
          
        System.out.print("LinkedHashMap:");  
        for(String key : linkedMap.keySet()) {  
            System.out.print(linkedMap.get(key) + " ");  
        }  
          
        Map<String, String> treeMap = new TreeMap<String, String>();  
        treeMap.put("a", "1");  
        treeMap.put("b", "2");  
        treeMap.put("c", "3");  
        treeMap.put("d", "4");  
          
        System.out.print("TreeMap:");  
        for(String key : treeMap.keySet()) {  
            System.out.print(treeMap.get(key) + " ");  
        }  
    }  
}  
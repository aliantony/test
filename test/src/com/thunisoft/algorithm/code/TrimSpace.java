package com.thunisoft.algorithm.code;

public class TrimSpace {
    
    public static void main(String[] args) {
        String str = "   https://www.b     aidu.com/   ";
        str = str.trim();
        str = str.replaceAll("\\s+", " ");
        System.out.println(str);
    }
}

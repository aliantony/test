package com.processors;

public class TestProcess {
   public static void main(String[] args) {
   int i =Runtime.getRuntime().availableProcessors();
   System.out.println("您的电脑可用CPU数量是:"+i);
}
}

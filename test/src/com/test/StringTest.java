package com.test;

public class StringTest {
  public static void main(String[] args) {
	String a = "abc";
	String b = "abc";
	String c = new String("abc");
	System.out.println(a==b);
	System.out.println(a==c);
	System.out.println(b==c);
	System.out.println(a==c.intern()); //c虽然开辟了新堆内存，在常量池里是引用的一个值
	
}
}

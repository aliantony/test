package com.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class StringOutOfMem {
  public static void main(String[] args) {
	List<String> handler = new ArrayList<String>();
	for(int i=0;i<1000;i++)
	{
		HugeStr h =new HugeStr();
		ImproveHugeStr h1= new ImproveHugeStr();
		handler.add(h1.getSubString(1, 5));
	}
}
  static class HugeStr{
	  private String str = new String(new char[100000000]);
	  public String getSubString(int begin,int end)
	  {
		  return str = str.substring(begin,end); //此方法的构造函数使用了以空间换时间的办法，容易出现内存泄露
	  }
  }
  
  static class ImproveHugeStr{
	  private String str = new String(new char[100000000]);
	  public String getSubString(int begin,int end)
	  {
		  return new String(str.substring(begin,end)); //不会有内存溢出，构造了新对象能被及时回收
	  }
  }
  
  
  /**
   * Integer、Long的toString()存在内存溢出 
   * concat replace subString toLowerCase toUpperCase valueOf字符串很大，就会出现内存溢出
   */
  
}

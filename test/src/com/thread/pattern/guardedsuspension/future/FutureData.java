package com.thread.pattern.guardedsuspension.future;

import java.util.concurrent.Callable;


public class FutureData implements Callable<RealData>,Data{
    private RealData realData;
    
	@Override
	public RealData call() throws Exception {
		System.out.println("处理后返回结果，客户端可以取了");
		return realData;
	}
	public RealData getRealData() {
		return realData;
	}
	public void setRealData(RealData realData) {
		this.realData = realData;
	}
	@Override
	public String getResult() {
		return "服务器端处理完了，结果返回给客户端";
	}
	
	
   
}

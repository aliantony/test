package com.thread.pattern.guardedsuspension.simple;


public class ClientThread extends Thread {
    private RequestQueue requestQueue;
    public ClientThread(RequestQueue requestQueue, String name) {
        super(name);
        this.requestQueue = requestQueue;
    }
    public void run() {
        for (int i = 0; i < 10; i++) {
            Request request = new Request("RequestID:" + i+" Thread_Name:"+Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName() + " requests " + request);
            requestQueue.addRequest(request);
            try {
                Thread.sleep(10); //客户端提交请求的速度快于服务器端处理的速度，把请求放到队列中
            } catch (InterruptedException e) {
            }
            System.out.println("ClientThread Name is:"+Thread.currentThread().getName());
        }
        System.out.println(Thread.currentThread().getName()+" request end");
    }
}

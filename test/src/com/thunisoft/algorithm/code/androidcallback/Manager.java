package com.thunisoft.algorithm.code.androidcallback;

public class Manager {
    
    public void onCreate() {
        Worker worker = new Worker();
        worker.make(new Worker.onMakeEndListener() {
            
            // 此处实现Worker类中的接口，但本身自己不用，而是回传给Worker类
            // 这就是回调函数
            @Override
            public void onMakeEnd(int sum) {
                sell(sum);
            }
        });
    }
    
    public void sell(int sum) {
        System.out.println("共" + sum + "台机器，经理将以每台机器100,00元的价格，卖给客户");
    }
    
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.onCreate();
    }
}

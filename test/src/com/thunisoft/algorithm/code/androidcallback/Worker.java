package com.thunisoft.algorithm.code.androidcallback;

public class Worker {
    
    public void make(onMakeEndListener listener) {
        int sum = 0;
        while (sum < 50) {
            sum++;
            System.out.println("工人生产了" + sum + "台机器");
        }
        listener.onMakeEnd(sum);
    }
    
    public interface onMakeEndListener {
        
        void onMakeEnd(int sum);
    }
}

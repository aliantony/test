package com.thread.pattern.masterworker;
public class PlusWorker extends Worker {  
  
    @Override  
    public Object handle(Object input) {  
          
        Integer i =(Integer)input;  
        return i*i*i;  
    }  
  
      
}  
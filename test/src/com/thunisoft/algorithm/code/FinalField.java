package com.thunisoft.algorithm.code;

public class FinalField {
    
    public static void main(String[] args) {
        // 非final用在本地类中编译器会报错
        final int x = 0;
        final int y = 0;
        Foo foo = new Foo() { // Foo接口的实现就是一个本地类
        
            @Override
            public void doBar() {
                int z = x + y;
                System.out.println(z);
            }
        };
        foo.doBar();
    }
    
}

interface Foo {
    
    void doBar();
}

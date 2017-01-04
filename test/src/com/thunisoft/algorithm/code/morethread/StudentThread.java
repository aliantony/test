package com.thunisoft.algorithm.code.morethread;

import java.util.ArrayList;
import java.util.List;

public class StudentThread extends Thread {
    
    private List<Student> students = new ArrayList<Student>();
    
    public StudentThread(List<Student> students) {
        this.students = students;
        
    }
    
    @Override
    public void run() {
        
        for (Student student : students) {
            System.out.println("当前线程：" + Thread.currentThread().getName());
            System.out.println("name = " + student.getName() + " age = "
                    + student.getAge() + " sex = " + student.getSex());
            // 导入学生信息到数据库中
        }
    }
    
}

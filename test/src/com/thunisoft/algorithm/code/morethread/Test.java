package com.thunisoft.algorithm.code.morethread;

import java.util.ArrayList;
import java.util.List;

public class Test {
    
    public static void main(String[] args) {
        
        Test test = new Test();
        // 查询所有的学生信息
        List<Student> students = test.getAllStudents();
        // 定义一个临时集合，用于存放学生信息
        List<Student> tempStudents = new ArrayList<Student>();
        
        for (int i = 0; i < students.size(); i++) {
            tempStudents.add(students.get(i));
            if (i != 0 && i % 5000 == 0) {
                test.createThread4ExportStudentInfo(tempStudents, i);
            }
        }
        
        test.createThread4ExportStudentInfo(tempStudents, students.size());
        
    }
    
    /**
     * <li>创建线程，导入学生信息</li>
     * 
     * @param tempStudents 每个线程，需要导入的学生信息的数量
     * @param i
     */
    public void createThread4ExportStudentInfo(List<Student> tempStudents, int i) {
        
        List<Student> students = new ArrayList<Student>();
        
        for (Student student : tempStudents) {
            students.add(student);
        }
        
        StudentThread studentThread = new StudentThread(students);
        // 设置线程名称
        studentThread.setName("Thread-" + i);
        // 启动线程
        studentThread.start();
        
        // 重新生成一个新的临时学生集合。
        tempStudents = new ArrayList<Student>();
    }
    
    /**
     * <li>查询所有的学生信息</li>
     * 
     * @return
     */
    public List<Student> getAllStudents() {
        
        List<Student> students = new ArrayList<Student>();
        
        for (int i = 1; i <= 100000; i++) {
            Student student = new Student();
            
            student.setName("liudong" + i);
            student.setAge(i);
            student.setSex(i + "");
            
            students.add(student);
        }
        
        return students;
    }
}

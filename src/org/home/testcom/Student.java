package org.home.testcom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Student implements Comparable<Student>{


    boolean isPriority;
    int time;
    int id;

    @Override
    public String toString() {
        return "Student{" +
                "isPriority=" + isPriority +
                ", time=" + time +
                ", id=" + id +
                '}';
    }

    public Student(boolean isPriority, int time, int id) {
        this.isPriority = isPriority;
        this.time = time;
        this.id = id;
    }

    @Override
    public int compareTo(Student otherStudent) {
        if (this.isPriority && !otherStudent.isPriority)
            return -1;
        if (!this.isPriority && otherStudent.isPriority)
            return 1;
        // 相同优先级
        if (this.time < otherStudent.time)
            return -1;
        else if (this.time > otherStudent.time)
            return 1;
        // 相同优先级 且相同时间

        return this.id < otherStudent.id ? -1 : 1;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Random r = new Random(666);
        for (int i = 0; i < 30; i++) {
            students.add(new Student(i % 2 == 0, r.nextInt(5),i));
        }
        Collections.sort(students);
        System.out.println();
    }
}
